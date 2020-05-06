package sample.UserDB;

import sample.Model.Member;
import java.util.ArrayList;
import java.util.List;



import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDBH extends UserDBH<Member> {


    @Override
    protected boolean authenticateUser(String email, String hashedPassword) {
        return false;
    }

    @Override
    public Member readByEmail(String email) throws SQLException {
        return null;
    }

    @Override
    public void insert(Member model) throws SQLException {

    }

    @Override
    public void update(Member model) throws SQLException {

    }

    @Override
    public void delete(Member model) throws SQLException {

    }

    @Override
    public List<Member> readAll() throws SQLException {
        return null;
    }

    @Override
    public Member readByPrimaryKey(String key) throws SQLException {
        return null;
    }

    @Override
    public List<Member> buildModels(ResultSet set) throws SQLException {
        return null;
    }
}
