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

/**
 *
 * @author Syed
 */
public class registerServlet extends HttpServlet {

    private PreparedStatement ps = null;
    private PrintWriter out = null;
    static final String DB_URL = "jdbc:derby://localhost:1527/cw_db";
    //static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "M00734132";
    static final String DB_PASSWD = "admin";
    
    //Initiation of JDBC
     public void initJDBC(){
        try {
            
            //Use the JDBC library to obtain a connection to the database
            Connection con = DriverManager.getConnection
                        (DB_URL,DB_USER,DB_PASSWD);
            
            //Use the connection to issue SQL commands.
            //Sending query that inserts user's username, email and password to the 'USER' table in the database.
            ps = con.prepareStatement("INSERT INTO USERS" + "(USER_NAME, USER_EMAIL, USER_PASSWORD, USER_DATE_CREATED)" + "VALUES (?,?,?, DEFAULT)");
           
                    
            }catch(SQLException se) {
                System.out.println("SQL Exception Here! " + se);
                se.printStackTrace();
            }
    } 
    
    /**
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException
    {
        initJDBC();
    }
    
    //Takes name, email and password as parameter and then adds the user information to the 'USERS' table in the database. 
    public void addUser(String name, String email, String pass) throws SQLException{
            
            try{
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            int i = ps.executeUpdate();
            
            }catch(SQLException e){
                System.out.println("addUser Function SQLException: " + e);
            }catch(Exception e){
                System.out.println("addUser Function Exception : " + e);
            }
    }
    
        public static boolean checkUser(String name,String email){
        boolean st = false;
        try {

            //creating connection with the database
            Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
            PreparedStatement ps = con.prepareStatement("SELECT USER_NAME, USER_EMAIL FROM USERS WHERE USER_NAME = ? AND USER_EMAIL = ?");
            ps.setString(1, name);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        }catch(SQLException e) {
            System.out.println("Check User Function SQLException e: " + e);
            e.printStackTrace();
        }catch( Exception EE){
            System.out.println("Check User Function Exception EE: " + EE);
            EE.printStackTrace();
        }
        return st;                 
    }  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
	response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
	//Fetch the value of element with id name, email and pass. Then store them in the respective variables.
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
    try{  
            if(checkUser(name, email))
            {
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
                out.println("<h1>Error</h1>");
                out.println("<p><strong>Error registering user: " + name + " & email ID: " + email + " either username/email exist already! Please try again!</strong></p>");
                out.println("</body >");
                out.println("</html >");
                
               RequestDispatcher rs = request.getRequestDispatcher("register.html");
               rs.include(request, response);  
            }else{
                               
                addUser(name, email, pass);
                
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
                out.println("<title>Confirmation</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p><br><br><br></p>");
                out.println("<h1>Confirmation</h1>");
                out.println("<p>" + name + " " + email + " successfully registered </p>");
                out.println("</body >");
                out.println("</html >");
                out.println("You are sucessfully registered");  
                
                RequestDispatcher rs = request.getRequestDispatcher("login.html");
                rs.forward(request, response);  
              
            }
        }catch (SQLException ex) {
                                                                                                                                                                                                                                                                                                                        
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
                out.println("<p><strong>Error registering user " + name + " " + email + "</strong></p>");
                out.println("</body >");
                out.println("</html >");
                
               RequestDispatcher rs = request.getRequestDispatcher("register.html");
               rs.include(request, response);
            }
    }
}
