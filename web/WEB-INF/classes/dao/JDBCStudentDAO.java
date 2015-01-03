
package dao;

import myObjects.Student;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myObjects.Discipline;


public class JDBCStudentDAO implements StudentDao {

    Connection connection ;
    
    private static final String URL = "jdbc:mysql://localhost:3306/application_users";
    private static final String NAME = "root";
    private static final String PASSWORD = "140488";

   
    public static String getURL() {
        return URL;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null){
                connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            }
        }catch (ClassNotFoundException e){
            System.out.println("Class not found ecxeption");
        }catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
    
    public int getStudentID(Connection connection, String firstName, String lastName){
        int i = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("select ID, First_Name, Last_Name from student where First_Name = ? and Last_Name = ?");
            ps.setString(1, firstName );
            ps.setString(2, lastName );
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
              i = Integer.parseInt(resultSet.getString("ID"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
        return i;
    }
    
    @Override
    public String addStudent(Connection connection, String firstName, String lastName) {
        String message = null;
        Boolean bool = null;
        try{
            PreparedStatement pstmt = connection.prepareStatement("insert into student (First_Name, Last_Name) values (?, ?)");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            bool = pstmt.execute();
            pstmt.close();
        }catch (SQLException e){
            System.out.println("Sql exception when addStudent.");
        }
        message = "Student " + firstName + " " + lastName + " successfully added into student table.";
        
        return message; 
    }
    
    @Override
    public String deleteStudent(Connection connection, String firstName, String lastName) {
       String message = null;
        
            int i = this.getStudentID(connection, firstName, lastName);
            if(i == 0){
                return "No such student";
            }
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM DISCIPLINE WHERE ID_STUDENT = ?");
                ps.setInt(1, i);
                ps.execute();
                ps.close();
                PreparedStatement pstmt = connection.prepareStatement("DELETE FROM STUDENT WHERE ID = ?");
                pstmt.setInt(1, i);
                pstmt.execute();
                pstmt.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            message = "Student " + firstName + " " + lastName + " succsessfully deleted.";
        
        return message;
    }
    
    @Override
    public LinkedList<Student> selectAllStudents(Connection connection) {
        LinkedList<Student> studentList = new LinkedList<Student>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            Student student = null;
            while(resultSet.next()){
                student = new Student();
                student.setId(Integer.parseInt(resultSet.getString("ID")));
                student.setFirstName(resultSet.getString("First_Name"));
                student.setLastName(resultSet.getString("Last_Name"));
                studentList.add(student);        
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(studentList);
        
        return studentList;
        
    }
    
    public Student findStudent(Connection connection, String firstName, String lastName){
        Student student = null;
            int i = 0;
        try {
            i = this.getStudentID(connection, firstName, lastName);
            if(i==0){
                return student;
            }
            PreparedStatement ps = connection.prepareStatement("select * from student where ID = ?");
            ps.setInt(1, i);
            ResultSet resultSet = ps.executeQuery();
            student = new Student();
            while(resultSet.next()){
                student.setId(Integer.parseInt(resultSet.getString("ID")));
                student.setFirstName(resultSet.getString("First_Name"));
                student.setLastName(resultSet.getString("Last_Name"));
            }
           resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return student;
    }
    //redy
    public String changeFirstName(Connection connection, String currentFirstName, String currentLastName, String firstNameAfter){
        String message = null;
        Boolean bool = null;
        int i = this.getStudentID(connection, currentFirstName, currentLastName);
        if(i==0){
            return message = "Student not found";
        }
        try {
            PreparedStatement ps = connection.prepareStatement("update student set First_Name = ? where ID = ?");
            ps.setString(1, firstNameAfter);
            ps.setInt(2, i);
            bool = ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(i!=0){
            message = "Student first name changed from" + currentFirstName + " to "+ firstNameAfter;
        }
        
        return message;
    }
    //redy
    public String changeLastName(Connection connection, String currentFirstName, String currentLastName, String lastNameAfter) {
        String message = null;
        Boolean bool = null;
        int i = this.getStudentID(connection, currentFirstName, currentLastName);
        if(i==0){
            return message = "Student not found";
        }
        try {
            PreparedStatement ps = connection.prepareStatement("update student set Last_Name = ? where ID = ?");
            ps.setString(1, lastNameAfter);
            ps.setInt(2, i);
            bool = ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(i!=0){
            message = "Student last name changed from" + currentLastName + " to "+ lastNameAfter;
        }
        
        return message;
    }
    
    public String assignDiscipline(Connection connection, String firstName, String lastName, String disciplineName){
        String message = null;
        int i = this.getStudentID(connection, firstName, lastName);
        if(i==0){
             message = "Student not found";
        }
        try {
            PreparedStatement ps = connection.prepareStatement("insert into discipline (ID_student, Name) values (?, ?)");
            ps.setInt(1, i);
            ps.setString(2, disciplineName);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(i!=0){
            message = "Discipline " + disciplineName + " was succsessfully assign to student "+ firstName + " " + lastName;
        }
        
        return message;
    }
    
    public LinkedList<Discipline> getAllStudentsDisciplines(Connection connection, String firstName, String lastName){
        LinkedList<Discipline> list = null;
        int i = this.getStudentID(connection, firstName, lastName);
        if(i == 0 ){
            return list;
        }
        try {
            list = new LinkedList<Discipline>();
            PreparedStatement preparedStatement = connection.prepareStatement("select Name from discipline where ID_student = ?");
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               Discipline discipline = new Discipline();
               discipline.setName(resultSet.getString("Name"));
               list.add(discipline);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    
   
    
}
