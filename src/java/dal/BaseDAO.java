package dal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonnt
 */
public abstract class BaseDAO<T> {
    protected Connection connection;
    public BaseDAO()
    {
        try {
            String username = "sa";
            String password = "sa";
            String url ="jdbc:sqlserver://localhost:1433;databaseName=BookReadingWeb";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public abstract ArrayList<T> all();
    public abstract T get(String id);
    public abstract void insert(T model);  
    public abstract void update(T model);
    public abstract void delete(String id);
    
}
