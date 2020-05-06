package sample.UserDB;

import sample.Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDBH extends UserDBH<Student> {

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

    @Override
    protected boolean authenticateUser(String email, String hashedPassword) {
        return false;
    }

    @Override
    public Student readByEmail(String email) throws SQLException {
        return null;
    }
}
