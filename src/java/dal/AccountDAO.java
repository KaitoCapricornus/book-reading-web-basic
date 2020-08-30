/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author dinht
 */
public class AccountDAO extends BaseDAO<Account> {

    @Override
    public ArrayList<Account> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account get(String Username) {
        try {
            String sql = "select * from Accounts\n"
                    + "where Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Account a = new Account();
                a.setUsername(rs.getString("Username"));
                a.setPassword(rs.getString("Password"));
                a.setType(rs.getString("Type"));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean isRegisted(String Username) {
        try {
            String sql = "select * from Accounts\n"
                    + "where Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void insert(Account model) {
        try {
            String sql = "insert into Accounts\n"
                    + "values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getUsername());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getType());
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
