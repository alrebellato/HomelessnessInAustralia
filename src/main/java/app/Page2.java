package app;

import java.util.ArrayList;

import app.helperClasses.twoGrowth;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Page2 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page2.html";

    @Override
    public void handle(Context context) throws Exception {

        JDBCConnection connection = new JDBCConnection();

        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homelessness</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='page2.css' />";
        html = html + "<link rel='stylesheet' type='text/css' href='page3.css' />";
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        //CSS Internal
        html = html + "<style>";
        html = html + "p{font: 20px}";
        html = html + "</style>";
        html = html + "<body>";

        //Add the navbar
        html = htmlBuilder.addNavbar(html);

        //Page Body
        html = html + "<div class='background'>";
        html = html + "<div style='padding-top: 60px; min-height: 100%;'>";
        html = html + "    <h1 style='text-align: center;'>Did you Know...</h1>";
        html = html + "    <div class=flex-container>";



        //Percent of homeless that are female

        html = html + "        <div class=flex-item>";
        html = html + "            <p>";
        html = html + "                <img src='2Images/HomelessWomanP2.png' alt='Placeholder Image' ALIGN='left'>As of 2018, " 
                                        + connection.page2Female()
                                        + "% of people experiencing homelessness are women. Women between the ages of 30 and 39 are most vulnerable to the condition of homelessness."
                                        + "<br><br><a href='https://www.sacredheartmission.org/seek-help/help-for-women/womens-house' style='color: blue'>The Women's House</a> is a service for all women experiencing homelessness.";
        html = html + "            </p>";
        html = html + "        </div>";



        //Growth in homelessness per state

        html = html + "        <div class=flex-item>";
        html = html + "            <p>";
        html = html + "                <img src='2Images/HomelessnessMapP2.png' alt='Map of Australia' ALIGN='right'>The Australian states and territories experiencing the highest growth in homelessness are:<br>"; 
        ArrayList<twoGrowth> data = connection.page2States();
        for(twoGrowth datum: data){

            html = html + datum.getName() + " ";

            html = html + datum.getCount() + "%,<br>";
        }
        html = html + "            </p>";
        html = html + "        </div>";

        //Percent of honmeless that are under 10 in age

        html = html + "        <div class=flex-item>";
        html = html + "            <p>";
        html = html + "                <img src='2Images/child_looking_down.png' alt='Child looking downwards' ALIGN='left'>";
        html = html + "                As of 2018, " + connection.page2Children()
                                        + "% of people experiencing homelessness are under the age of 10. \"Children experiencing homelessness are an especially vulnerable population ... Homelessness can be disruptive to children's education\" -<a href=https://www.aihw.gov.au/reports/children-youth/australias-children/contents/housing/homelessness style='color: blue'>aihw.gov.au</a>";
        html = html + "            </p>";
        html = html + "        </div>";


        //Site link
        html = html + "        <div class=flex-item>";
        html = html + "            <p>";
        html = html + "                <img src='2Images/DataPhotoP2.png' alt='Placeholder Image' ALIGN='right'>";
        html = html + "                Homelessness can affect everybody. Understanding the homelessness condition can help you, when you encounter others experiencing homelessness, or if you experience it yourself.<br> To find out more and see the reality of the homelessness condition in Australia for yourself: <br><a href=/page1.html style='color: blue'>Explore the data</a>";
        html = html + "                .";
        html = html + "            </p>";
        html = html + "        </div>";
        html = html + "        <div class=flex-item>";
        html = html + "            <p style='text-align: center;'>";
        html = html + "                If you are experiencing homelessness, you can find local government support services <a href='https://www.homelessnessaustralia.org.au/are-you-experiencing-homelessness' style='color: blue'>here</a>";
        html = html + "            </p>";
        html = html + "        </div>";
        html = html + "    </div>";
        html = html + "</div>";


        html = htmlBuilder.addFooter(html);

        html = html + "</body></html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
