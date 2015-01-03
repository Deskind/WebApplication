/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import myObjects.Student;
import java.util.LinkedList;
import myObjects.Discipline;
import java.sql.Connection;

/**
 *
 * @author Katya
 */
public interface StudentDao {
    
    public String addStudent(Connection connection, String firstName, String lastName);
    public int getStudentID(Connection connection, String firstName, String lastName);
    public LinkedList<Student> selectAllStudents(Connection connection);
    public Student findStudent(Connection connection, String firstName, String lastName);
    public String deleteStudent(Connection connection, String firstName, String lastName);
    public LinkedList<Discipline> getAllStudentsDisciplines(Connection connection, String firstName, String lastName);
    public String changeFirstName(Connection connection, String currentFirstName, String currentLastName, String firstNameAfter);
    public String changeLastName(Connection connection, String currentFirstName, String currentLastName, String firstNameAfter);
    public String assignDiscipline(Connection connection, String firstName, String lastName, String disciplineName);
}
