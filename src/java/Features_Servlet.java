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
public class Features_Servlet extends HttpServlet {

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
                + "        <link rel=\"stylesheet\" href=\"resources/index.css\">\n"
                + "        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
                + "        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
                + "        <link href=\"https://fonts.googleapis.com/css2?family=Exo+2:wght@400;700&display=swap\" rel=\"stylesheet\">\n"
                + "    </head>\n"
                + "           \n"
                + "<body>    \n"
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
                + "        \n"
                + "        <header>\n"
                + "            <h1>Features</h1> \n"
                + "        </header>\n"
                + "        \n"
                + "        <div class=\"clearfix\">\n"
                + "            <div class=\"box\">\n"
                + "                <img src=\"img/easeofus.png\" alt=\"easeofuse_logo\" width=\"100\" height=\"100\">\n"
                + "                <h2>Ease of use</h2>\n"
                + "                <p>Find available booking slots at your favorite sports arena in your area, as well as other relevant information, all in one place.</p>\n"
                + "            </div>\n"
                + "            <div class=\"box\">\n"
                + "                <img src=\"img/rating.png\" alt=\"rating_logo\" width=\"100\" height=\"100\">\n"
                + "                <h2>Overall rating based on user's reviews</h2>\n"
                + "                <p>Natural Language Processing (NLP) techniques are used in services like Text Analysis, Text Mining, and Text Processing. User evaluations for the sports arena will be assessed by the application. To assign a score based on the writer's tone.</p>\n"
                + "            </div>\n"
                + "            <div class=\"box\">\n"
                + "                <img src=\"img/like.png\" alt=\"like_logo\" width=\"100\" height=\"100\">\n"
                + "                <h2>Share your experience</h2>\n"
                + "                <p>Users can utilize the site's comment section to discuss their experiences with other users.</p>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    \n"
                + "    <script src=\"./js/main.js></script>\n"
                + "    \n"
                + "</body>\n"
                + "</html>\n"
                + "\n"
                + "");

    }

}
