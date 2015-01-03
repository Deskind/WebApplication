/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appServlets;

import dao.JDBCStudentDAO;
import dao.JDBCStudentDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Katya
 */
public class MySessionListener implements HttpSessionListener{
    public static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
      try{
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null){
                try {
                    connection = DriverManager.getConnection(JDBCStudentDAO.getURL(), JDBCStudentDAO.getNAME(), JDBCStudentDAO.getPASSWORD());
                } catch (SQLException ex) {
                    Logger.getLogger(WebAppServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch (ClassNotFoundException e){
            System.out.println("Class not found ecxeption");
        }  
      System.out.println("Session is created!");
//        if(connection==null){
//            connection = new JDBCStudentDAO().getConnection();
//        }
    }
        
    

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySessionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
