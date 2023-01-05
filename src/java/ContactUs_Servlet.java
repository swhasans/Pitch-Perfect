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
public class ContactUs_Servlet extends HttpServlet {

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
        
        
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

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
                + "        <link rel=\"stylesheet\" href=\"resources/contactus.css\">\n"
                + "        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
                + "        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
                + "        <link href=\"https://fonts.googleapis.com/css2?family=Exo+2:wght@400;700&display=swap\" rel=\"stylesheet\">\n"
                + "    </head>\n"
                + "           \n"
                + "<body>\n"
                + "    <nav>\n"
                + "            <ul>\n"
                + "                <li><a href=\"Features_Servlet\" class=\"left_bar\"><strong>Pitch Perfect </strong></a></li>\n"
                + "                <li><a href=\"Search_Servlet\" class=\"mid_bar\">Search</a></li>\n"
                + "                <li><a href=\"Features_Servlet\" class=\"mid_bar\">Features</a></li>\n"
                + "                <li><a href=\"ContactUs_Servlet\" class=\"mid_bar\">Contact Us</a></li>\n"
                + "                <li><a href=\"AboutUs_Servlet\" class=\"mid_bar\">About Us</a></li>\n"
                + "                <li><a href=\"logoutServlet\" class=\"right_bar\">Log Out</a></li>\n"
                + "            </ul>    \n"
                + "    </nav>\n"
                + "    \n"
                + "        <header>\n"
                + "            <h1>Contact Us</h1> \n"
                + "        </header>\n"
                + "    \n"
                + "            <div class=\"clearfix\">\n"
                + "                <div class=\"box\">\n"
                + "                    <p>Email Us:</p>\n"
                + "                </div>    \n"
                + "                <div class=\"div-1\">\n"
                + "                    <p>hello@pitchperfect.com</p>\n"
                + "                </div> \n"
                + "            </div>\n"
                + "    \n"
                + "    <form>\n"
                + "                <table>          \n"
                + "                    <tr>\n"
                + "                        <td><input class = \"form\" type=\"text\" id=\"your_name\" name=\"f=yourname\" placeholder= \"Your name\" required ></td> \n"
                + "                    </tr>\n"
                + "                    \n"
                + "                    <tr>\n"
                + "                        <td><input class = \"form\" type= \"email\" id = \"email\" name= \"email\" placeholder= \"E-mail address\" required ></td>\n"
                + "                    </tr>\n"
                + "                    \n"
                + "                    <tr>\n"
                + "                        <td>\n"
                + "                            <textarea class = \"form button clearfix\" rows=\"5\" cols=\"200\" placeholder = \"Leave your message\"></textarea>\n"
                + "                        </td> \n"
                + "                    </tr> \n"
                + "                    \n"
                + "                    <tr>\n"
                + "                        <td> <input class = \"submit_form button\" onclick = \"alert('Done!')\" type=\"submit\" value=\"Send\"></td>\n"
                + "                    </tr>\n"
                + "                </table>\n"
                + "    </form>\n"
                + "    \n"
                + "    <footer>\n"
                + "        <p>Follow Us</p>\n"
                + "        <img src=\"img/followus.png\" alt=\"followus_logo\" width=\"300\" height=\"50\">\n"
                + "    </footer>\n"
                + "    \n"
                + "    </body>\n"
                + "</html>");

    }

}
