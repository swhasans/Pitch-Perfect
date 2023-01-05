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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.helper.Validate;

/**
 *
 * @author Syed
 */
public class loginServlet extends HttpServlet{

        private PreparedStatement ps = null;
        private PrintWriter out = null;
        static final String DB_URL = "jdbc:derby://localhost:1527/cw_db";
        //static final String DB_DRV = "com.mysql.jdbc.Driver";
        static final String DB_USER = "M00734132";
        static final String DB_PASSWD = "admin";
    
 
    public static boolean checkUser(String email,String pass){
        boolean st = false;
        try {
            
            //creating connection with the database
            Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            
            //Use the connection to issue SQL commands.
            //Sending query that fetches the user's email and password from the 'USER' table in the database.
            PreparedStatement ps = con.prepareStatement("SELECT USER_EMAIL, USER_PASSWORD FROM USERS WHERE USER_EMAIL = ? AND USER_PASSWORD = ? ");
            
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        }catch(SQLException e) {
            System.out.println("SQLException e: " + e);
            e.printStackTrace();
        }catch( Exception EE){
            System.out.println("Exception EE: " + EE);
            EE.printStackTrace();
        }
        return st;                 
    }  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        
        //Fetched from the login form.
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        
            if(checkUser(email, pass)){
                                    
                    //creating  a session
                    HttpSession session = request.getSession();
                    //Setting the attribute with the string variable.
                    session.setAttribute("email", email); 
                    
                    
                    RequestDispatcher rs = request.getRequestDispatcher("Welcome");
                    rs.forward(request, response);                                                   
            }else{
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
                out.println("<p><strong>Error signing user " + email + ".</strong></p>" + "<p><strong>Username/password incorrect. Please try again.</strong></p>");
                out.println("</body >");
                out.println("</html >");
               RequestDispatcher rs = request.getRequestDispatcher("login.html");
               rs.include(request, response);
            }
    }

}
