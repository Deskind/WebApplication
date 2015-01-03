/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import appServlets.MySessionListener;
import dao.JDBCStudentDAO;
import java.sql.Connection;

/**
 *
 * @author Katya
 */
public class AppTest {
    public static void main(String[] args){
        JDBCStudentDAO student = new JDBCStudentDAO();
        Connection connection = student.getConnection();
        String s = student.changeFirstName(connection, "Max", "Molotok", "Maxim");
        System.out.println(s);
    }
}
