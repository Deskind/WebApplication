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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession httpSession = request.getSession();
        
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
                LinkedList<Student> studentList = new JDBCStudentDAO().selectAllStudents(MySessionListener.connection); 
                request.setAttribute("studentList", new JDBCStudentDAO().selectAllStudents(new MySessionListener().connection));
                request.getRequestDispatcher("showAllStudents.jsp").forward(request, response);
                break;
            case "addStudentForm":
            request.setAttribute("message", new JDBCStudentDAO().addStudent(MySessionListener.connection,
            request.getParameter("FirstName"), request.getParameter("LastName")));
            request.getRequestDispatcher("addStudent.jsp").forward(request, response);
                break;
            case "deleteStudentForm":
            request.setAttribute("message", new JDBCStudentDAO().deleteStudent(MySessionListener.connection,
            request.getParameter("FirstName"), request.getParameter("LastName")));
            request.getRequestDispatcher("delStudent.jsp").forward(request, response);
                break;
            case "findStudentForm":
            request.setAttribute("student", new JDBCStudentDAO().findStudent(MySessionListener.connection,
            request.getParameter("FirstName"), request.getParameter("LastName")));
            request.getRequestDispatcher("findStudent.jsp").forward(request, response);
                break;
            case "firstNameChangeForm":
            request.setAttribute("message", new JDBCStudentDAO().changeFirstName(MySessionListener.connection,
            request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("NewName")));
            request.getRequestDispatcher("changeFirstName.jsp").forward(request, response);
                break;
            case "lastNameChangeForm":
            request.setAttribute("message", new JDBCStudentDAO().changeLastName(MySessionListener.connection,
            request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("NewName")));
            request.getRequestDispatcher("changeLastName.jsp").forward(request, response);
                break;
            case "assingDisciplineForm":
            request.setAttribute("message", new JDBCStudentDAO().assignDiscipline(MySessionListener.connection,
            request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("Discipline")));
            request.getRequestDispatcher("assignDiscipline.jsp").forward(request, response);
                break;
            case "getDisciplineForm":
            request.setAttribute("disciplineList", new JDBCStudentDAO().getAllStudentsDisciplines(MySessionListener.connection,
            request.getParameter("FirstName"), request.getParameter("LastName")));
            request.getRequestDispatcher("getStudentDisciplines.jsp").forward(request, response);
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
