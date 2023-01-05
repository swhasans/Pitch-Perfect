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
public class Search_Servlet extends HttpServlet {

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
                + "        <link rel=\"stylesheet\" href=\"resources/search.css\">\n"
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
                + "            <h1>Search</h1> \n"
                + "        </header>\n"
                + "\n"
                + "            <div class=\"clearfix\">\n"
                + "            <div class=\"box\">\n"
                + "                <img src=\"img/volleyball.png\" alt=\"volleyball_logo\" width=\"250\" height=\"250\">\n"
                + "                <h2>Volleyball</h2>\n"
                + "                <div>\n"
                + "                    <h3>List of available facilities</h3>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"VB_Servlet\">Site 1</a>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"Demo_Servlet\">Site 2</a>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"Demo_Servlet\">Site 3</a>\n"
                + "                </div>\n"
                + "            </div>    \n"
                + "                \n"
                + "            <div class=\"box\">\n"
                + "                <img src=\"img/dumbbell.png\" alt=\"dumbbell_logo\" width=\"250\" height=\"250\">\n"
                + "                <h2>Gymnasium</h2>\n"
                + "                <div>\n"
                + "                    <h3>List of available facilities</h3>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"TS_Servlet\">Site 1</a>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"Demo_Servlet\">Site 2</a>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"Demo_Servlet\">Site 3</a>\n"
                + "                </div>\n"
                + "            </div>    \n"
                + "                \n"
                + "            <div class=\"box\">\n"
                + "                <img src=\"img/football.png\" alt=\"football_logo\" width=\"250\" height=\"250\">\n"
                + "                <h2>Football</h2>\n"
                + "                <div>\n"
                + "                    <h3>List of available facilities</h3>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"FT_Servlet\">Site 1</a>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"Demo_Servlet\">Site 2</a>\n"
                + "                </div>\n"
                + "                <div>\n"
                + "                    <a href=\"Demo_Servlet\">Site 3</a>\n"
                + "                </div>\n"
                + "            </div>    \n"
                + "        </div>\n"
                + "            \n"
                + "    </body>\n"
                + "</html>\n"
                + "");

    }

}
