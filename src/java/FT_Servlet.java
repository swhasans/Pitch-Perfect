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
public class FT_Servlet extends HttpServlet {
    
    private static final String VENUE_GLOBAL_DETAILS_URL = "https://www.everyoneactive.com/centre/broadfield-3g-pitch-pavilion/";

    private static final String VENUE_NAME_DIV_CLASS_META = "div[itemprop = image] > meta[content*= .png]";
    private static final String VENUE_NAME_DIV_CLASS = "h1.centre-info__title";
    private static final String VENUE_PHONE_DIV_CLASS = "a.centre-info__link.link--telephone";
    private static final String VENUE_ADDRESS_DIV_ATTRIBUTE = "p[itemprop]";
    private static final String VENUE_PRICE_SELECTOR = "div:not([id]), li[id=\"\"]";
    private static final String VENUE_WEBSITE_DIV_ATTRIBUTE = "meta[property=\"og:url\"]";
    private static final String VENUE_CONTACT_WEBSITE_DIV_ATTRIBUTE = "a[href*=/media/]";
    private static final String VENUE_TIMING_DIV_CLASS = "ul.centre-info__opening-times-list";

    class Venue {

        private String img;
        private String name;
        private String ph_num;
        private String address;
        private String price;
        private String link;
        private String contact_link;
        private String timing;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPh_num() {
            return ph_num;
        }

        public void setPh_num(String ph_num) {
            this.ph_num = ph_num;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getContact_link() {
            return contact_link;
        }

        public void setContact_link(String contact_link) {
            this.contact_link = contact_link;
        }

        public String getTiming() {
            return timing;
        }

        public void setTiming(String timing) {
            this.timing = timing;
        }

    }

    public List<Venue> extractVenues() {

        List<Venue> venues = new ArrayList<>();
        Document doc;

        try {
            doc = Jsoup.connect(VENUE_GLOBAL_DETAILS_URL).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Venue venue = new Venue();

        Elements imgElements = doc.select(VENUE_NAME_DIV_CLASS_META);
        if (!imgElements.isEmpty()) {
            venue.setImg(imgElements.attr("content"));
        }

        Elements titleElements = doc.select(VENUE_NAME_DIV_CLASS);
        if (!titleElements.isEmpty()) {
            venue.setName(titleElements.text());
        }

        Elements addrElements = doc.select(VENUE_ADDRESS_DIV_ATTRIBUTE);
        if (!addrElements.isEmpty()) {
            venue.setAddress(addrElements.text());
        }

        Elements phoneNumElements = doc.select(VENUE_PHONE_DIV_CLASS);
        if (!phoneNumElements.isEmpty()) {
            venue.setPh_num(phoneNumElements.text());
        }

        Elements priceElements = doc.select(VENUE_PRICE_SELECTOR);
        if (!priceElements.isEmpty()) {
            venue.setPrice(priceElements.val() + "£54.10");
        }

        Elements websiteElements = doc.select(VENUE_WEBSITE_DIV_ATTRIBUTE);
        if (!websiteElements.isEmpty()) {
            venue.setLink(websiteElements.attr("content"));
        }

        Elements contactWebsiteElements = doc.select(VENUE_CONTACT_WEBSITE_DIV_ATTRIBUTE);
        if (!contactWebsiteElements.isEmpty()) {
            venue.setContact_link(contactWebsiteElements.attr("href"));
        }

        Elements timingElements = doc.select(VENUE_TIMING_DIV_CLASS);
        if (!timingElements.isEmpty()) {
            for (Element timingElement : timingElements) {
                venue.setTiming(timingElement.text());
            }
        }

        venues.add(venue);

        return venues;
    }           
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setCharacterEncoding("UTF−8");  
         
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
    
        FT_Servlet WS = new FT_Servlet();
        List<Venue> venues = WS.extractVenues();
        
        for (Venue venue : venues) {

            try(PrintWriter out = new PrintWriter(response.getOutputStream())){
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
                        + "        <header>\n"
                        + "            <h1>Football - 1st Facility </h1> \n"
                        + "        </header>\n"
                        + "    \n"
                        + "    <div>           \n"
                        + "            <table class = \"box\">            \n"
                        + "                <caption>Sports complex/facility images:</caption> \n"
                        + "                    <tr>\n"
                        + "                        <td><img src= \"" + venue.getImg() + "\" alt=\"football_logo\" width=\"1300\" height=\"550\"></td> \n"
                        + "                    </tr> \n"
                        + "            </table>     \n"
                        + "    </div> \n"
                        + "    \n"
                        + "    <div>           \n"
                        + "            <form>\n"
                        + "                <table class = \"box\">            \n"
                        + "                    <caption>Related Available Information:</caption> \n"
                        + "                        <tr>\n"
                        + "                            <td><label for = \"place_name\">Name: " + venue.getName() + " </label></td>                             \n"
                        + "                        </tr> \n"
                        + "                        <tr>\n"
                        + "                            <td><label for = \"contact_num\">Contact No: " + venue.getPh_num() + " </label></td> \n"
                        + "                        </tr> \n"
                        + "                        <tr>\n"
                        + "                            <td><label for = \"address\">Address/Location: " + venue.getAddress() + " </label></td> \n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td><label for = \"price\">Price*: " + venue.getPrice() + " </label></td> \n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td><label for = \"site\">Web site: " + venue.getLink() + " </label></td> \n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td><label for = \"contact_email\">Contact link: " + venue.getContact_link() + " </label></td> \n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td><label for = \"timing\">Hours: " + venue.getTiming() + " </label></td> \n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td><label for = \"rating\">Rating:</label></td> \n"
                        + "                        </tr> \n"
                        + "                </table>\n"
                        + "            </form>        \n"
                        + "    </div>    \n"
                        + "    \n"
                        + "\n"
                        + "    <div>           \n"
                        + "        <form id = \"comment\" method=\"post\" action=\"Comment_Servlet\"  >\n"
                        + "                <table>            \n"
                        + "                    <caption>Feel free to comment</caption> \n"
                        + "                    <tr>\n"
                        + "                        <td>                               \n"
                        + "                            <p>Please choose the sports facility you'd like to make a comment on:</p>\n"
                        + "                              <input type=\"radio\" id=\"Volleyball\" name=\"venue\" value=\"Volleyball\">\n"
                        + "                              <label for=\"Volleyball\">Paddington Recreation Ground</label><br>\n"
                        + "                              <input type=\"radio\" id=\"Gymnasium\" name=\"venue\" value=\"Gymnasium\">\n"
                        + "                              <label for=\"Gymnasium\">Alton Sports Centre</label><br>\n"
                        + "                              <input type=\"radio\" id=\"Football\" name=\"venue\" value=\"Football\">\n"
                        + "                              <label for=\"Football\">Broadfield 3G Pitch & Pavilion</label>\n"
                        + "                        </td> \n"
                        + "                    </tr>  \n"
                        + "                    \n"
                        + "                        <tr>\n"
                        + "                            <td>\n"
                        + "                                <input class = \"form clear fix\" id=\"comment-box\" type=\"text\" placeholder= \"Comment Here!\" name=\"comment-box\" size=\"75\">\n"
                        + "                            </td> \n"
                        + "                        </tr> \n"
                        + "                        \n"
                        + "                        <tr>\n"
                        + "                            <td>                               \n"
                        + "                                <ul id=\"unordered\"> <li>This is a fantastic location, staff was courteous and helpful.</li> <li>The available equipment is of poor quality.</li>  <li>This is a horrible location.</li> </ul>\n"
                        + "                            </td> \n"
                        + "                        </tr>  \n"
                        + "                        \n"
                        + "                        <tr>\n"
                        + "                            <td></td> \n"
                        + "                        </tr>  \n"
                        + "                </table>                    \n"
                        + "            </form>                       \n"
                        + "    </div>\n"
                        + "    \n"
                        + "      \n"
                        + "    <input class = \"submit_form button\" id = \"post\" onclick = \"alert('Your comment is recorded!')\" type=\"submit\" value=\"Submit\">\n"
                        + "\n"
                        + "\n"
                        + "    <footer>\n"
                        + "        <p>* - Approximate cost for one adult, for more information please visit the respective web site</p>\n"
                        + "    </footer>    \n"
                        + "    \n"
                        + "    \n"
                        + "    <script src=\"./js/main.js\"></script>\n"
                        + "    \n"
                        + "</body>\n"
                        + "</html>\n"
                        + "");
                }catch(Exception E){
                    System.out.println("Exception E: " + E);
                }
    }        
   
}

}




