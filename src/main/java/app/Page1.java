package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Temporary HTML as an example page.
 * 
 * Based on the Project Workshop code examples.
 * This page currently:
 *  - Provides a link back to the index page
 *  - Displays the list of movies from the Movies Database using the JDBCConnection
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class Page1 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page1.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

html = html + "        <head>";
html = html + "    <meta charset='UTF-8'>";
html = html + "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>";
html = html + "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>";
html = html + "    <title>HomeFull</title>";
html = html + "    <link rel='stylesheet' type='text/css' href='page1.css' />";
html = html + "</head>";
html = html + "<body>";


html = html + "    <nav>";

html = html + "        <a href='#'>";
html = html + "            <img src='/1images/logo.png'>";
html = html + "        </a>";

html = html + "        <ul>";
html = html + "            <li>";
html = html + "                <a href='/'>Index</a>";
html = html + "            </li>";
html = html + "        </ul>";
html = html + "    </nav>";

html = html + "    <div class='slogan'>";
html = html + "        <h1>Bringing Awareness <br>to the Homeless.</h1>";
html = html + "    </div>";

html = html + "    <div class='gcontainer'>";
html = html + "        <div class='container'>";
html = html + "            <div class='learn'>";
html = html + "                <h3>Learn</h3>";

html = html + "                <div class='lboxes'>";
html = html + "                    <div class='lbox1'>";
html = html + "                        <a href='page2.html'> <p>Big Picture</p> </a>";
html = html + "                    </div>";

html = html + "                    <div class='lbox2 dropdown'>";
html = html + "                        <button class='dropbtn'>Shallow Glance</button>";
html = html + "                        <div style='border-top: solid rgb(163, 163, 163) 0px' class='dropdown-content'>";
html = html + "                            <a href='page3.html'>Homelessness By Area</a>";
html = html + "                            <a href='page4.html'>At Risk of Homelessness</a>";
html = html + "                        </div>";
html = html + "                    </div>";

html = html + "                    <div class='lbox3 dropdown'>";
html = html + "                        <button class='dropbtn'>Deep Dive</button>";
html = html + "                        <div style='border-top: solid rgb(163, 163, 163) 0px' class='dropdown-content'>";
html = html + "                            <a href='page5.html'>Who Experiences Homelessness?</a>";
html = html + "                            <a href='page6.html'>Change in Homelessness Over Time</a>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                </div>";
html = html + "            </div>";


html = html + "            <div class='rr'>";
html = html + "                <h3>Recommended Readings</h3>";

html = html + "                <div class='rrboxes'>";
html = html + "                    <div class='rrbox1'>";
html = html + "                        <a style='text-decoration: none; color: black;' href='https://www.missionaustralia.com.au/news-blog/safe-homes/carol-67-homeless-and-alone' target='_blank'><h4>67, Homeless and Afraid</h4></a>";
html = html + "                    </div>";

html = html + "                    <div class='rrbox2'>";
html = html + "                        <a style='text-decoration: none; color: black;' href='https://backpackbed.org/au/facts-about-homelessness' target='_blank'><h4>Homelessness in Numbers</h4></a>";
html = html + "                    </div>";

html = html + "                    <div class='rrbox3'>";
html = html + "                        <a style='text-decoration: none; color: black; position: relative; top: 11px;' href='https://www.sacredheartmission.org/about/what-is-homelessness' target='_blank'><h4>Sacred Case Study</h4></a>";
html = html + "                    </div>";
html = html + "                </div>";
html = html + "            </div>";


html = html + "            <div class='hs'>";
html = html + "                <h3>Help + Support</h3>";

html = html + "                <div class='hsboxes'>";
html = html + "                    <div class='hsbox1'>";
html = html + "                        <a style='text-decoration: none; color: black;' href='https://www.missionaustralia.com.au/servicedirectory/211-homelessness' target='_blank'><h4>Shelters</h4></a>";
html = html + "                    </div>";

html = html + "                    <div class='hsbox2'>";
html = html + "                        <a style='text-decoration: none; color: black;' href='https://www.homelessnessaustralia.org.au/are-you-experiencing-homelessness' target='_blank'><h4>Welfare</h4></a>";
html = html + "                    </div>";

html = html + "                    <div class='hsbox3'>";
html = html + "                        <a style='text-decoration: none; color: black;' href='https://www.missionaustralia.com.au/helpthiswinter' target='_blank'><h4>Donate</h4></a>";
html = html + "                    </div>";
html = html + "                </div>";
html = html + "            </div>";

html = html + "            <div class='bgsvg'>";
html = html + "                <img class='studying' src='1images/studying.svg'>";
html = html + "            </div>";

html = html + "            <div class='footer'>";

html = html + "                <div class='legal'>";
html = html + "                    <h3>Legal</h3>";
html = html + "                    <div class='flcontent'>";
html = html + "                        <p>Usage</p>";
html = html + "                        <p>Cookies</p>";
html = html + "                    </div>";
html = html + "                </div>";

html = html + "                <div class='sitemap'>";
html = html + "                    <h3>Sitemap</h3>";
html = html + "                    <div class='flearn'>";
html = html + "                        <h4>Learn</h4>";
html = html + "                        <div class='fslcontent'>";
html = html + "                            <p>What is Homelessness</p>";
html = html + "                            <p>Statistics</p>";
html = html + "                        </div>";
html = html + "                    </div>";

html = html + "                    <div class='fhelp'>";
html = html + "                        <h4>Help</h4>";
html = html + "                        <div class='fshcontent'>";
html = html + "                            <p>What can you do?</p>";
html = html + "                            <p>Support Services</p>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                </div>";

html = html + "                <div class='contact'>";
html = html + "                    <h3>Contact</h3>";
html = html + "                    <div class='ccontent'>";
html = html + "                        <p>Raf Email</p>";
html = html + "                        <p>Ad Email</p>";
html = html + "                        <p>Phone</p>";
html = html + "                        <p>RMIT Address</p>";
html = html + "                    </div>";
html = html + "                </div>";
html = html + "            </div>";

html = html + "        </div>        ";
html = html + "    </div>";

html = html + "    <div id='decobox1'></div>";
html = html + "    <div id='decobox2'></div>";


html = html + "</body>";
html = html + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
