/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appServlets;

import dao.JDBCStudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import myObjects.Discipline;
import myObjects.Student;
import appServlets.MySessionListener;
import com.mysql.jdbc.MySQLConnection;
import dao.JDBCStudentDAO;

/**
 *
 * @author Katya
 */
@WebServlet(name = "WebAppServlet", urlPatterns = {"/WebAppServlet"})
public class WebAppServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    Connection connection = null;
//    public void init(){
//      try{
//            Class.forName("com.mysql.jdbc.Driver");
//            if(connection == null){
//                try {
//                    connection = DriverManager.getConnection(JDBCStudentDAO.getURL(), JDBCStudentDAO.getNAME(), JDBCStudentDAO.getPASSWORD());
//                } catch (SQLException ex) {
//                    Logger.getLogger(WebAppServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }catch (ClassNotFoundException e){
//            System.out.println("Class not found ecxeption");
//        }  
//    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        Connection connection = null;
         HttpSession httpSession = null;
        
        //Create the session
        httpSession = request.getSession();
        
        
                
//        connection = MySessionListener.connection;
        
        
        
        
        
        Student student = null;
        LinkedList<Discipline> disciplineList = null;
        String s = null;
        
        String form = request.getParameter("formName");
        switch(form) {
            case "addForm":
                response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> add student </h1>");
            out.println("<form action=\"WebAppServlet\">");
            out.println("<input type=\"text\" name=\"FirstName\" value=\"FirstName\">");
            out.println("<input type=\"text\" name=\"LastName\" value=\"LastName\">");
            out.println("<input type=\"submit\" value=\"add student\">");
            out.println("<input type=\"hidden\" name=\"formName\" value=\"addStudentForm\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

                break;
            case "delForm":
                response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> delete student </h1>");
            out.println("<form action=\"WebAppServlet\">");
            out.println("<input type=\"text\" name=\"FirstName\" value=\"FirstName\">");
            out.println("<input type=\"text\" name=\"LastName\" value=\"LastName\">");
            out.println("<input type=\"submit\" value=\"delete student\">");
            out.println("<input type=\"hidden\" name=\"formName\" value=\"deleteStudentForm\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

                break;
    
                
            case "getAllForm": 
//                getServletContext().getRequestDispatcher("/SelectAll.jsp").forward(request, response);
            LinkedList<Student> studentList = new JDBCStudentDAO().selectAllStudents(MySessionListener.connection); 
                
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            for(Student st : studentList){
                out.println("<h1>" +st.toString()+ "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
            
        }
                break;
            case "addStudentForm":
                s = new JDBCStudentDAO().addStudent(MySessionListener.connection, request.getParameter("FirstName"), request.getParameter("LastName"));
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + s + "</h1>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
                break;
            case "deleteStudentForm":
//                s = new JDBCStudentDAO().deleteStudent(connection, request.getParameter("FirstName"), request.getParameter("LastName"));
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + s + "</h1>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
                break;
            case "findStudentForm":
//                student = new JDBCStudentDAO().findStudent(connection, request.getParameter("FirstName"), request.getParameter("LastName"));
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            if(student == null){
                 out.println("<h1> Student not found </h1>");
            }else{
                 out.println("<h1>" + student.toString() + "</h1>");
            }
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
                break;
            case "firstNameChangeForm":
//                s = new JDBCStudentDAO().changeFirstName(connection, request.getParameter("FirstName"), request.getParameter("LastName"),request.getParameter("NewName"));
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + s + "</h1>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
                break;
            case "lastNameChangeForm":
//                s = new JDBCStudentDAO().changeLastName(connection, request.getParameter("FirstName"), request.getParameter("LastName"),request.getParameter("NewName"));
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + s + "</h1>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
                break;
            case "assingDisciplineForm":
//                s = new JDBCStudentDAO().assignDiscipline(connection, request.getParameter("FirstName"), request.getParameter("LastName"),request.getParameter("Discipline"));
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + s + "</h1>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
                break;
            case "getDisciplineForm":
//                disciplineList = new JDBCStudentDAO().getAllStudentsDisciplines(connection, request.getParameter("FirstName"), request.getParameter("LastName"));
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");            
            out.println("</head>");
            out.println("<body>");
            if(disciplineList.size()==0){
                out.println("<h1>The student don't have any disciplines</h1>");
            }else{
                for(Discipline d : disciplineList){
                    out.println("<h1>" + d.toString() + "</h1>");
                }
            }
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
                break;

        }
        
    }
    
    public void destroy(){
        try {
            MySessionListener.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(WebAppServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
