/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User_Library;

/**
 *
 * @author dinht
 */
public class LibraryDAO extends BaseDAO<User_Library> {

    @Override
    public ArrayList<User_Library> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User_Library get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(User_Library model) {
        try {
            String sql = "insert into User_Library\n"
                    + "values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getUsername());
            statement.setString(2, model.getBookID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User_Library model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isInUserLibrary(String username, String BookID) {
        try {
            String sql = "select * from User_Library\n"
                    + "where Username = ? and BookID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, BookID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
        return false;
    }
}
