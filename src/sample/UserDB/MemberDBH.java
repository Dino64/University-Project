package sample.UserDB;

import sample.Model.Student;

import java.util.List;



import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDBH extends UserDBH<Student> {


    @Override
    protected boolean authenticateUser(String email, String hashedPassword) {
        return false;
    }

    @Override
    public Student readByEmail(String email) throws SQLException {
        return null;
    }

    @Override
    public void insert(Student model) throws SQLException {

    }

    @Override
    public void update(Student model) throws SQLException {

    }

    @Override
    public void delete(Student model) throws SQLException {

    }

    @Override
    public List<Student> readAll() throws SQLException {
        return null;
    }

    @Override
    public Student readByPrimaryKey(String key) throws SQLException {
        return null;
    }

    @Override
    public List<Student> buildModels(ResultSet set) throws SQLException {
        return null;
    }
}
