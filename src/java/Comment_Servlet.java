/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Syed
 */
public class Comment_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private PreparedStatement ps = null;
    private PrintWriter out = null;
    static final String DB_URL = "jdbc:derby://localhost:1527/cw_db";
    //static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "M00734132";
    static final String DB_PASSWD = "admin";

    
    public static boolean addComment(String venue_name, String comment) throws SQLException {
        boolean st = false;       
        try {
            //Use the JDBC library to obtain a connection to the database
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            //Use the connection to issue SQL commands.
            //Sending query that inserts user's username, email and password to the 'USER' table in the database.
            PreparedStatement ps = con.prepareStatement("INSERT INTO SPORTSVENUE" + "(SV_NAME, SV_USER_COMMENT, SV_DATE_CREATED)" + "VALUES (?,?, DEFAULT)");

            ps.setString(1, venue_name);
            ps.setString(2, comment);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (SQLException e) {
            System.out.println("addComment Function SQLException: " + e);
        } catch (Exception e) {
            System.out.println("addComment Function Exception : " + e);
        }
        
        return st;
    }    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        
        //Fetched from the comment form.
        String venue_name = request.getParameter("name");
        String comment = request.getParameter("comment-box");
        
        if (!(venue_name.isEmpty() && comment.isEmpty())) {
            
        try {
                addComment(venue_name, comment);


            RequestDispatcher rs = request.getRequestDispatcher("Search_Servlet");
            rs.forward(request, response);
            
            } catch (SQLException ex) {
                System.out.println("SQL Exception doPost Comment_Servlet: " + ex);
            }
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
                    + "        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
                    + "        <link href=\"https://fonts.googleapis.com/css2?family=Exo+2:wght@400;700&display=swap\" rel=\"stylesheet\">");
            out.println("    <style>\n"
                    + "        * { \n"
                    + "              font-family: 'Exo 2', sans-serif; \n"
                    + "        }\n"
                    + "    </style>");
            out.println("<title>Error</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p><br><br><br></p>");
            out.println("<p><strong>Error recording user comment " + comment + ".</strong></p>" + "<p><strong> Please try again.</strong></p>");
            out.println("</body >");
            out.println("</html >");
            RequestDispatcher rs = request.getRequestDispatcher("Search_Servlet");
            rs.include(request, response);
        }
        
    } catch (Exception ex) {
        System.out.println("Add comment Exception: " + ex);
    }
    
    }
}
