package sample.UserDB;


import sample.DataBaseConsole.ModelDBHandler;
import sample.Model.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AddressDBH extends ModelDBHandler<Address> {

    @Override
    public void insert(Address model) throws SQLException {

    }

    @Override
    public void update(Address model) throws SQLException {

    }

    @Override
    public void delete(Address model) throws SQLException {

    }

    @Override
    public List<Address> readAll() throws SQLException {
        return null;
    }

    @Override
    public Address readByPrimaryKey(String key) throws SQLException {
        return null;
    }

    @Override
    public List<Address> buildModels(ResultSet set) throws SQLException {
        return null;
    }
}
