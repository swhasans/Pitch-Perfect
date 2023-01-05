/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Syed
 */
public class Demo_Servlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF−8");
        
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

            try (PrintWriter out = new PrintWriter(response.getOutputStream())) {
                out.println("<!DOCTYPE html>\n"
                        + "<!--\n"
                        + "To change this license header, choose License Headers in Project Properties.\n"
                        + "To change this template file, choose Tools | Templates\n"
                        + "and open the template in the editor.\n"
                        + "-->\n"
                        + "<html lang= \"en\">\n"
                        + "    <head>\n"
                        + "        <title>Pitch Perfect</title>\n"
                        + "        <meta charset=\"UTF-8\">\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "        <link rel=\"stylesheet\" href=\"resources/WS_Sport.css\">\n"
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
                        + "            <header>\n"
                        + "                <h1>Demonstration Purposes</h1>\n"
                        + "            </header>\n"
                        + "            \n"
                        + "           <div class=\"clearfix\">\n"
                        + "                <div class=\"box\">\n"
                        + "                    <h2 id = \"email\">Purpose of Presentation</h2>\n"
                        + "                    <p id = \"signup\">Select one of the first three links for your choice of physical activity to get started. The links for each physical activity are functional; the remaining links are for demonstration purposes only.</p>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "    \n"
                        + "</body>\n"
                        + "</html>\n"
                        + "");
            } catch (Exception E) {
                System.out.println("Exception E: " + E);
            }
        }

    }


