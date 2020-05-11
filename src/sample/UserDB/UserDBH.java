package sample.UserDB;

import sample.Assets.HashUtils;
import sample.DataBaseConsole.ModelDBHandler;
import sample.Model.User;
import sample.Model.Member;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDBH <U extends User> extends ModelDBHandler<U> {

    public static <U extends User> UserDBH getHandlerFor(U model) {
        if (model instanceof Member) {
            return new MemberDBH();
        } else {
            return new StudentDBH();
        }
    }

    public static Object authenticate(String email, String password) throws SQLException {
        String hashedPassword = HashUtils.hashPassword(password);
        try (MemberDBH memberDBH = new MemberDBH();
             StudentDBH studentDBH = new StudentDBH()) {
            if (memberDBH.authenticateUser(email, hashedPassword)) {
                return memberDBH.readByEmail(email);
            } else if (studentDBH.authenticateUser(email, hashedPassword)) {
                return studentDBH.readByEmail(email);
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return Boolean.parseBoolean(null);
    }

    public boolean userExists(String socialSecurityNo) throws SQLException {
        String query = "SELECT * FROM User WHERE ssn=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, socialSecurityNo);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                return true;
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return false;
    }

    public void updatePassword(String key, String password) throws SQLException {
        String query = "UPDATE user SET password=? WHERE email=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, password);
            statement.setString(2, key);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("No user found with that email.");
            }
        } catch (Exception e) {

        }
    }

    protected abstract boolean authenticateUser(String email, String hashedPassword);

    public abstract U readByEmail(String email) throws SQLException;

    public static User readAbstractByEmail(String email) throws SQLException {
        User userFound;
        try (MemberDBH memberDBHandler = new MemberDBH();
             StudentDBH studentDBH = new StudentDBH()) {
            userFound = memberDBHandler.readByEmail(email);
            if (userFound == null) {
                userFound = studentDBH.readByEmail(email);
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return userFound;
    }




}
