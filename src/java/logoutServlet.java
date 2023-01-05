/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Syed
 */
public class logoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //Getting the existing session.
        HttpSession session = request.getSession();
        
        //Terminate the existing session.
        session.invalidate();

        out.println("<!DOCTYPE html>\n"
                + "<!--\n"
                + "To change this license header, choose License Headers in Project Properties.\n"
                + "To change this template file, choose Tools | Templates\n"
                + "and open the template in the editor.\n"
                + "-->\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Pitch Perfect</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "        <link rel=\"stylesheet\" href=\"resources/search.css\">\n"
                + "        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
                + "        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
                + "        <link href=\"https://fonts.googleapis.com/css2?family=Exo+2:wght@400;700&display=swap\" rel=\"stylesheet\">\n"
                + "    </head>\n"
                + "           \n"
                + "<body>    \n"
                + "    <nav>\n"
                + "            <ul>\n"
                + "                <li><a href=\"./index.html\" class=\"left_bar\"><strong>Pitch Perfect </strong></a></li>\n"
                + "                <li><a href=\"./index.html\" class=\"mid_bar\">Features</a></li>\n"
                + "                <li><a href=\"./contactus.html\" class=\"mid_bar\">Contact Us</a></li>\n"
                + "                <li><a href=\"./aboutus.html\" class=\"mid_bar\">About Us</a></li>\n"
                + "                <li><a href=\"./login.html\" class=\"right_bar\">Login</a></li>\n"
                + "                <li><a href=\"./register.html\" class=\"right_bar\">Register</a></li>\n"
                + "            </ul>    \n"
                + "    </nav>\n"
                + "    \n"
                + "        <header>\n"
                + "            <h1>Logged Out</h1> \n"
                + "        </header>\n"
                + "        \n"
                + "        <div class=\"clearfix\">\n"
                + "            <div class=\"box\">\n"
                + "                <h2 id = \"signOut_email\">Signing off</h2>\n"
                + "                <p id = \"signout\">The user has been successfully logged out of the service.</p>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "            \n"
                + "    </body>\n"
                + "</html>\n"
                + "");
        
        out.close();  
    }

}
