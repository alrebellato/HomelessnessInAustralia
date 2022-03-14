package app;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;

import app.helperClasses.AgeSortFOUR;
import app.helperClasses.GenderSortFOUR;
import app.helperClasses.Pair;
import app.helperClasses.fourlgaAgeData;
import app.helperClasses.fourlgaGenderData;
import app.helperClasses.fourlgaTotalData;
import app.helperClasses.fourstateAgeData;
import app.helperClasses.fourstateGenderData;
import app.helperClasses.fourstateTotalData;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Page4 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page4.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String

String html = "<html>";


html = html  + "   <head>";
html = html  + "       <meta charset='UTF-8'>";
html = html  + "       <meta http-equiv='X-UA-Compatible' content='IE=edge'>";
html = html  + "       <meta name='viewport' content='width=device-width, initial-scale=1.0'>";
html = html  + "       <title>At Risk of Homelessness</title>";
// html = html  + "       <link rel='stylesheet' href='common.css'>";
html = html  + "       <link rel='stylesheet' href='page4.css'>";
// Map stuff
html = html + " <link rel='stylesheet' type='text/css' href='https://api.tomtom.com/maps-sdk-for-web/cdn/6.x/6.13.0/maps/maps.css'>";
html = html + "<script src='https://api.tomtom.com/maps-sdk-for-web/cdn/6.x/6.13.0/maps/maps-web.min.js'></script>";
html = html + "<script src='https://api.tomtom.com/maps-sdk-for-web/cdn/6.x/6.13.0/services/services-web.min.js'></script>";

html = html  + "   </head>";

html = html + "   <body>";

// NAVIGATION START
    html = html + "<div class='topnav'>";
    html = html + "    <div class='flexbox'>";
    html = html + "        <a href='/page1.html'><img src='commonImages/logo_new.png' alt='Homefull' height = 35px style='object-fit: contain; border-radius: 0px;'></a>";
    html = html + "    </div>";
    html = html + "    <div class='flexbox' style='flex-grow: 100;'></div>";
    html = html + "    <div class='dropdown'>";
    html = html + "        <button class='dropbtn'>Big Picture</button>";
    html = html + "        <div class='dropdown-content'>";
    html = html + "            <a href='page1.html'>Home and Explore</a>";
    html = html + "            <a href='page2.html'>Three Big Facts</a>";
    html = html + "        </div>";
    html = html + "    </div>";
    html = html + "    <div class='dropdown'>";
    html = html + "        <button class='dropbtn'>Shallow Glance</button>";
    html = html + "        <div class='dropdown-content'>";
    html = html + "            <a href='page3.html'>Homelessness by Area</a>";
    html = html + "            <a href='page4.html'>People at Risk</a>";
    html = html + "        </div>";
    html = html + "    </div>";
    html = html + "    <div class='dropdown' style='margin-right: 120px;'>";
    html = html + "        <button class='dropbtn'>Deep Dive</button>";
    html = html + "        <div class='dropdown-content'>";
    html = html + "            <a href='page5.html'>Who Experiences Homelessness</a>";
    html = html + "            <a href='page6.html'>Change Over Time</a>";
    html = html + "        </div>";
    html = html + "    </div>";
    html = html + "</div>";
// NAVIGATION END

html = html  + "       <div class='designbox1'></div>";

html = html + "       <div class='slogan'>";
html = html  + "           <h1>At Risk of <br>Homelessness</h1>";
html = html  + "       </div>";

html = html + "       <div class='boxTitle'>";
html = html  + "           <h1>Find Data for your specific State or Local Government Area</h1>";
html = html  + "       </div>";

html = html + "       <div class='statebox'>";
html = html  + "           <form action='/page4.html' method='post'>";
html = html  + "               <div class='stateheader'>";
html = html  + "                   <label for='statename'>By State: </label>";
html = html  + "                   <input type='text' id='statename' name='statename' placeholder='Enter Abbreviated State in Caps (for ex. VIC)'>";
html = html  + "                   <button type='submit' class='btn'>Submit</button>";
html = html  + "               </div>";
html = html  + "           </form>";

String statename = context.formParam("statename");
// System.out.println("VAR statename: " + statename);

html = html + "           <div class='statecontainer'>";

try {
html = html  + "               <div class='map'>";

if (statename.equals("")){
    System.out.println("Statename is empty");
    html = html  + "<img src='4images/statemap.png' alt=''>";

}
// !("VIC".equals(statename)) || !"SA".equals(statename) || !"NSW".equals(statename) || !"WA".equals(statename) || !"NT".equals(statename) || !"ACT".equals(statename) || !"TAS".equals(statename) || !"QLD".equals(statename)
else{
    html = html + "<div id='map-div'></div>";
    System.out.println("Map Added");
}
html = html  + "               </div>";


// Script for Map
html = html + "<script>";
html = html + "const API_KEY = 'nC1mHNRuU0QdAGXYP7Lf3NV9yWsY9pLi';";
html = html + "const APPLICATION_NAME = 'HomeFull';";
html = html + "const APPLICATION_VERSION = '6.5';";

html = html + "tt.setProductInfo(APPLICATION_NAME, APPLICATION_VERSION);";

html = html + "const VIC = {";
html = html + "    lng: 144.964600,";
html = html + "    lat: -37.020100";
html = html + "};";
html = html + "const NSW = {";
html = html + "    lng: 145.612793,";
html = html + "    lat: -31.840233";
html = html + "};";
html = html + "const QLD = {";
html = html + "    lng: 142.702789,";
html = html + "    lat: -20.917574";

html = html + "};";
html = html + "const TAS = {";
html = html + "    lng: 146.315918,";
html = html + "    lat: -41.640079";
html = html + "};";
html = html + "const NT = {";
html = html + "    lng: 132.550964,";
html = html + "    lat: -19.491411";
html = html + "};";
html = html + "const SA = {";
html = html + "    lng: 136.209152,";
html = html + "    lat: -30.000233";
html = html + "};";
html = html + "const ACT = {";
html = html + "    lng: 149.012375,";
html = html + "    lat: -35.473469";
html = html + "};";
html = html + "const WA = {";
html = html + "    lng: 117.793221,";
html = html + "    lat: -25.042261";
html = html + "};";

html = html + "var map = tt.map({";
html = html + "    key: API_KEY,";
html = html + "    container: 'map-div',";



if (statename.equals("VIC")){
    html = html + "    center: VIC,";
    html = html + "    zoom: 5";
    System.out.println("VIC FOUND");
}
else if (statename.equals("NSW")){
    html = html + "    center: NSW,";
    html = html + "    zoom: 4";
}
else if (statename.equals("QLD")){
    html = html + "    center: QLD,";
    html = html + "    zoom: 3";
}
else if (statename.equals("TAS")){
    html = html + "    center: TAS,";
    html = html + "    zoom: 5";
}
else if (statename.equals("NT")){
    html = html + "    center: NT,";
    html = html + "    zoom: 4";
}
else if (statename.equals("SA")){
    html = html + "    center: SA,";
    html = html + "    zoom: 4.5";
}
else if (statename.equals("ACT")){
    html = html + "    center: ACT,";
    html = html + "    zoom: 8";
}
else if (statename.equals("WA")){
    html = html + "    center: WA,";
    html = html + "    zoom: 4";
}
else{
    html = html + "poopoo";
    System.out.println("no work");
}
html = html + "});";
html = html + "</script>";
// End Script
// System.out.println(html);

System.out.println("statename: "+statename);




} catch (Exception nullpointerException) {
    html = html  + "<img src='4images/statemap.png' alt=''>";
    System.out.println("statename is null");
    html = html  + "               </div>";
}



html = html + "               <div class='tablegrid'>";

html = html + "                   <div class='occupy'></div>";

html = html + "                   <div class='statetable'>";

html = html + "                       <div class='sort'>";
html = html  + "                           <div class='best'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                           <div class='worst'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <div class='table'>";

JDBCConnection connection = new JDBCConnection();

if(statename == null){
    html = html  + "                       <img src='4images/table.png' alt=''>";
}
else{

    html = html + "<ul>Population of Homelessness Per Age Group:";


    ArrayList<fourstateAgeData> data = connection.page4Age(statename);

    for(fourstateAgeData datum: data){
    html = html + "<li>" + datum.getBRACKETfourstateAgeData() + ": " + datum.getBRACKETDATAfourstateAgeData() + " people(s)</li>";
    }
html = html + "    </ul>";
}

html = html  + "                   </div>";

html = html + "                   <div class='insight'>";
html = html  + "                       <div class='insightheader'>";
html = html  + "                           <h3>State Insights</h3>";
html = html  + "                       </div>";
html = html  + "                       <div class='insightcontent'>";

html = html + "                           <div class='thp'>";
html = html  + "                               <div class='thpheader'>";
html = html  + "                                   <h4>Total Homeless Population:</h4>";
html = html  + "                               </div>";

html = html + "                               <div class='thpno'>";

if(statename == null){
html = html  + "                                   <p>9XXXXX</p>";
}
else{
    ArrayList<fourstateTotalData> data = connection.page4TotalDatas(statename);
        int stateTotalPop = fourstateTotalData.gettotalStatePop();
    html = html + "<p>"+ stateTotalPop +"</p>";
}

html = html  + "                               </div>";
html = html  + "                           </div>";

html = html + "                           <div class='gender'>";
html = html  + "                               <div class='genderheader'>";
html = html  + "                                   <h4>Gender Breakdown: </h4>";
html = html  + "                               </div>";

html = html + "                               <div class='genderno'>";
html = html  + "                                   <div class='female'>";
html = html  + "                                       <img src='4images/ficon.png' alt='female gender icon'>";

if(statename == null){
html = html  + "                                       <p>42%</p>";
}
else{
    ArrayList<fourstateGenderData> data = connection.page4GenderDatas(statename);
    DecimalFormat df = new DecimalFormat("#.#");
    double stategendertotal = (fourstateGenderData.getmale() + fourstateGenderData.getfemale());
    double displaystateFemale = (fourstateGenderData.getfemale() / stategendertotal) * 100;
            // System.out.println("%%%%%%%%%%%%%%%%%%%%" + displaylgaMale);
            // System.out.println("%%%%%%%%%%%%%%%%%%%%  m " + fourlgaGenderData.getmale());
            // System.out.println("%%%%%%%%%%%%%%%%%%%%  f " + fourlgaGenderData.getfemale());
        html = html +"<p>" + df.format(displaystateFemale) + "%</p>";
}

html = html  + "                                   </div>";
html = html  + "                                   <div class='male'>";
html = html  + "                                       <img src='4images/micon.png' alt='male gender icon'>";

if(statename == null){
html = html  + "                                       <p>58%</p>";
}
else{
    ArrayList<fourstateGenderData> data = connection.page4GenderDatas(statename);
    DecimalFormat df = new DecimalFormat("#.#");
    double stategendertotal = (fourstateGenderData.getmale() + fourstateGenderData.getfemale());
    double displaystateMale = (fourstateGenderData.getmale() / stategendertotal) * 100;
            
        html = html +"<p>" + df.format(displaystateMale) + "%</p>";
}


html = html  + "                                   </div>";

html = html + "                               </div>";
html = html  + "                           </div>";
html = html  + "                       </div>";

html = html + "                   </div>";
html = html  + "               </div>";

html = html + "           </div>";
html = html  + "       </div>";
html = html  + "       </div>";
html = html  + "       <!-- Space Divider -->";
html = html  + "       <div class='designbox2'></div>";
html = html  + "       <div class='spacedivider'></div>";
html = html  + "       <!-- LGA BOX -->";
html = html  + "       <div class='statebox'>";
html = html  + "           <form action='/page4.html#lgabox' method='post'>";
html = html  + "               <div id='lgabox' class='stateheader'>";
html = html  + "                   <label for='lganame'>By LGA: </label>";
html = html  + "                   <input type='text' id='lganame' name='lganame' placeholder='Enter Local Governement Area'>";
html = html  + "                   <button type='submit' class='btn'>Submit</button>";
html = html  + "               </div>";
html = html  + "           </form>";

html = html + "           <div class='statecontainer'>";
html = html  + "               <div class='map'>";
html = html  + "                   <img src='4images/lgaSearch.jpg' alt=''>";
html = html  + "               </div>";

html = html + "               <div class='tablegrid'>";

html = html + "                   <div class='occupy'></div>";

html = html + "                   <div class='statetable'>";

html = html + "                       <div class='sort'>";
html = html  + "                           <div class='best'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                           <div class='worst'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <div class='table'>";

String lganame = context.formParam("lganame");

if (lganame == null){
html = html  + "                       <img src='4images/table.png' alt=''>";
}
else{

    html = html + "<ul>Population of Homelessness Per Age Group:";


    ArrayList<fourlgaAgeData> data = connection.page4AgeLGA(lganame);

    for(fourlgaAgeData datum: data){
    html = html + "<li>" + datum.getBRACKETfourlgaAgeData() + ": " + datum.getBRACKETDATAlgaAgeData() + " people(s)</li>";
    }
html = html + "    </ul>";
}

html = html  + "                   </div>";

html = html + "                   <div class='insight'>";
html = html  + "                       <div class='insightheader'>";
html = html  + "                           <h3>State Insights</h3>";
html = html  + "                       </div>";
html = html  + "                       <div class='insightcontent'>";

html = html + "                           <div class='thp'>";
html = html  + "                               <div class='thpheader'>";
html = html  + "                                   <h4>Total Homeless Population:</h4>";
html = html  + "                               </div>";

html = html + "                               <div class='thpno'>";

if(lganame == null){
    html = html  + "                                   <p>9XXXXX</p>";
    }
else{
    ArrayList<fourlgaTotalData> data = connection.page4TotalDatasLGA(lganame);

        int totallgapop = fourlgaTotalData.gettotallgaPop();
    html = html + "<p>"+totallgapop+"</p>";
}

html = html  + "                               </div>";
html = html  + "                           </div>";

html = html + "                           <div class='gender'>";
html = html  + "                               <div class='genderheader'>";
html = html  + "                                   <h4>Gender Breakdown: </h4>";
html = html  + "                               </div>";

html = html + "                               <div class='genderno'>";
html = html  + "                                   <div class='female'>";
html = html  + "                                       <img src='4images/ficon.png' alt='female gender icon'>";

if(lganame == null){
    html = html  + "                                       <p>42%</p>";
    }
    else{
        ArrayList<fourlgaGenderData> data = connection.page4GenderDatasLGA(lganame);
        DecimalFormat df = new DecimalFormat("#.#");
        double lgagendertotal = (fourlgaGenderData.getmale() + fourlgaGenderData.getfemale());
        double displaylgaFemale = (fourlgaGenderData.getfemale() / lgagendertotal) * 100;
            // System.out.println("%%%%%%%%%%%%%%%%%%%%" + displaylgaMale);
            // System.out.println("%%%%%%%%%%%%%%%%%%%%  m " + fourlgaGenderData.getmale());
            // System.out.println("%%%%%%%%%%%%%%%%%%%%  f " + fourlgaGenderData.getfemale());
        html = html +"<p>" + df.format(displaylgaFemale) + "%</p>";
    }

html = html  + "                                   </div>";
html = html  + "                                   <div class='male'>";
html = html  + "                                       <img src='4images/micon.png' alt='male gender icon'>";

if(lganame == null){
    html = html  + "                                       <p>58%</p>";
    }
    else{
        ArrayList<fourlgaGenderData> data = connection.page4GenderDatasLGA(lganame);
        
        DecimalFormat df = new DecimalFormat("#.#");
        double lgagendertotal = (fourlgaGenderData.getmale() + fourlgaGenderData.getfemale());
        double displaylgaMale = (fourlgaGenderData.getmale() / lgagendertotal) * 100;
            // System.out.println("%%%%%%%%%%%%%%%%%%%%" + displaylgaMale);
            // System.out.println("%%%%%%%%%%%%%%%%%%%%  m " + fourlgaGenderData.getmale());
            // System.out.println("%%%%%%%%%%%%%%%%%%%%  f " + fourlgaGenderData.getfemale());
        html = html +"<p>" + df.format(displaylgaMale) + "%</p>";
    }
    
html = html  + "                                   </div>";

html = html + "                               </div>";
html = html  + "                           </div>";
html = html  + "                       </div>";

html = html + "                   </div>";
html = html  + "               </div>";

html = html + "           </div>";
html = html  + "       </div>";

html = html  + "       <div class='designbox2' style='width: 150px; top: 40px; z-index: 1;'></div>";

html = html + "       <div class='boxTitle' style='top: 20px;'>";
html = html  + "           <h1>Find the areas with the Worst and Best 'At Risk' Populations</h1>";
html = html  + "       </div>";

html = html + "       <!-- By Population -->";
html = html  + "       <div class='statebox'>";
html = html  + "           <form action='/page4.html#popsort' method='post'>";
html = html  + "               <div id='popsort' class='stateheader'>";
html = html  + "                   <label for='pname'>Population sort in </label>";

html = html + "                   <div class='dropdownBOX'>";
html = html  + "                       <button class='dropbtnBOX'>[location]</button>";
html = html  + "                       <div class='dropdownBOX-content'>";
html = html  + "                           <input type='radio' id='popSortState' name='area' value='state'>";
html = html  + "                           <label for='popSortState'>State</label><br>";
html = html  + "                           <input type='radio' id='popSortLga' name='area' value='lga_name'>";
html = html  + "                           <label for='popSortLga'>Local Govt. Area</label>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <label> by </label>";

html = html + "                   <div class='dropdownBOX'>";
html = html  + "                       <button class='dropbtnBOX'>[sort]</button>";
html = html  + "                       <div class='dropdownBOX-content'>";
html = html  + "                           <input type='radio' id='best' name='sort' value='ASC'>";
html = html  + "                           <label for='best'>Best</label><br>";
html = html  + "                           <input type='radio' id='worst' name='sort' value='DESC'>";
html = html  + "                           <label for='worst'>Worst</label>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <button type='submit' class='btn'>Submit</button>";
html = html  + "               </div>";
html = html  + "           </form>";

String area_type = context.formParam("area");
String sort_by = context.formParam("sort");

html = html + "           <div class='statecontainer'>";
html = html  + "               <div class='map'>";
html = html  + "                   <img src='4images/populationSort.jpg' alt=''>";
html = html  + "               </div>";

html = html + "               <div class='tablegrid'>";

html = html + "                   <div class='occupy'></div>";

html = html + "                   <div class='statetable'>";

html = html  + "                       <div class='sort'>";
html = html  + "                           <div class='best'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                           <div class='worst'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <div class='table'>";

if((area_type == null) && (sort_by == null)){
html = html  + "                       <img src='4images/table.png' alt=''>";
}
else{

    html = html + "<table stlye='border-collapse: collapse; main:auto;'>";

    html = html + "<tr>";
    html = html +   "<th>" + area_type + "</th>";
    html = html +   "<th>Total Homeless</th>";
    html = html + "</tr>";

    ArrayList<Pair> data = connection.page4Totals("total", sort_by, area_type, "2018");

    for(Pair datum: data){
        html = html + "<tr>";
        html = html + "<td>" + datum.getName() + "</td>";
        html = html + "<td>" + datum.getCount() + "</td>";
        html = html + "</tr>";
    }  

    html = html + "</table>";
}
html = html  + "                   </div>";
html = html  + "               </div>";

html = html + "           </div>";
html = html  + "       </div>";

html = html  + "       <div class='designbox2' style='top: 20px;'></div>";

html = html + "       <!-- Gender Sort -->";
html = html  + "       <div class='statebox'>";
html = html  + "           <form action='/page4.html#gendersort' method='post'>";
html = html  + "               <div id='gendersort' class='stateheader'>";
html = html  + "                   <label>Gender sort in </label>";

html = html + "                   <div class='dropdownBOX'>";
html = html  + "                       <button class='dropbtnBOX'>[gender]</button>";
html = html  + "                       <div class='dropdownBOX-content'>";
html = html  + "                           <input type='radio' id='maleTWO' name='genderTWO' value='male'>";
html = html  + "                           <label for='maleTWO'>Male</label><br>";
html = html  + "                           <input type='radio' id='femaleTWO' name='genderTWO' value='female'>";
html = html  + "                           <label for='femaleTWO'>Female</label>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <label> by </label>";

html = html + "                   <div class='dropdownBOX'>";
html = html  + "                       <button class='dropbtnBOX'>[sort]</button>";
html = html  + "                       <div class='dropdownBOX-content'>";
html = html  + "                           <input type='radio' id='bestTWO' name='sortTWO' value='ASC'>";
html = html  + "                           <label for='bestTWO'>Best</label><br>";
html = html  + "                           <input type='radio' id='worstTWO' name='sortTWO' value='DESC'>";
html = html  + "                           <label for='worstTWO'>Worst</label>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <label> in </label>";

html = html + "                   <div class='dropdownBOX'>";
html = html  + "                       <button class='dropbtnBOX'>[location]</button>";
html = html  + "                       <div class='dropdownBOX-content'>";
html = html  + "                           <input type='radio' id='gstateTWO' name='gareaTWO' value='State'>";
html = html  + "                           <label for='gstateTWO'>State</label><br>";
html = html  + "                           <input type='radio' id='glgaTWO' name='gareaTWO' value='Lga_Name'>";
html = html  + "                           <label for='glgaTWO'>Local Govt. Area</label>";

html = html + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <button type='submit' class='btn'>Submit</button>";
html = html  + "               </div>";
html = html  + "           </form>";

String gender_type = context.formParam("genderTWO");
String gsort_by = context.formParam("sortTWO");
String garea_type = context.formParam("gareaTWO");
// System.out.println(gender_type);
// System.out.println(gsort_by);
// System.out.println(garea_type);
html = html + "           <div class='statecontainer'>";
html = html  + "               <div class='map'>";
html = html  + "                   <img src='4images/genderSort.jpg' alt=''>";
html = html  + "               </div>";

html = html + "               <div class='tablegrid'>";

html = html + "                   <div class='occupy'></div>";

html = html + "                   <div class='statetable'>";

html = html + "                       <div class='sort'>";
html = html  + "                           <div class='best'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                           <div class='worst'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <div class='table'>";

if((garea_type == null) && (gsort_by == null) && (gender_type == null)){
html = html  + "                       <img src='4images/table.png' alt=''>";
}
else{

    html = html + "<table>";

    html = html + "<tr>";
    html = html +   "<th>" + garea_type + "</th>";
    html = html +   "<th>Total Homeless (" + gender_type + ")</th>";
    html = html + "</tr>";

    ArrayList<GenderSortFOUR> data = connection.page4GenderSort(garea_type, gender_type, gsort_by);

    for(GenderSortFOUR datum: data){
        html = html + "<tr>";
        html = html + "<td>" + datum.getareaName() + "</td>";
        html = html + "<td>" + datum.getpopGender() + "</td>";
        html = html + "</tr>";
    }  

    html = html + "</table>";
}

html = html  + "                   </div>";
html = html  + "               </div>";

html = html + "           </div>";
html = html  + "       </div>";

html = html  + "       <div class='designbox2' style='top: 20px;'></div>";

html = html + "       <!-- Age Sort -->";
html = html  + "       <div class='statebox'>";
html = html  + "           <form action='/page4.html#agesort' method='post'>";
html = html  + "               <div id='agesort'class='stateheader'>";
html = html  + "                   <label for='pname'>Age sort in </label>";

html = html + "                   <div class='dropdownBOX'>";
html = html  + "                       <button class='dropbtnBOX'>[age group]</button>";
html = html  + "                       <div class='dropdownBOX-content'>";
html = html  + "                           <input type='radio' id='0-10THREE' name='ageTHREE' value='0'>";
html = html  + "                           <label for='0-10THREE'>0-10</label><br>";
html = html  + "                           <input type='radio' id='10-19THREE' name='ageTHREE' value='10'>";
html = html  + "                           <label for='10-19THREE'>10-19</label><br>";
html = html  + "                           <input type='radio' id='20-29THREE' name='ageTHREE' value='20'>";
html = html  + "                           <label for='20-29THREE'>20-29</label><br>";
html = html  + "                           <input type='radio' id='30-39THREE' name='ageTHREE' value='30'>";
html = html  + "                           <label for='30-39THREE'>30-39</label><br>";
html = html  + "                           <input type='radio' id='40-49THREE' name='ageTHREE' value='40'>";
html = html  + "                           <label for='40-49THREE'>40-49</label><br>";
html = html  + "                           <input type='radio' id='50-59THREE' name='ageTHREE' value='50'>";
html = html  + "                           <label for='50-59THREE'>50-59</label><br>";
html = html  + "                           <input type='radio' id='60+THREE' name='ageTHREE' value='60'>";
html = html  + "                           <label for='60+THREE'>60+</label>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <label> by </label>";

html = html + "                   <div class='dropdownBOX'>";
html = html  + "                       <button class='dropbtnBOX'>[sort]</button>";
html = html  + "                       <div class='dropdownBOX-content'>";
html = html  + "                           <input type='radio' id='bestTHREE' name='sortTHREE' value='ASC'>";
html = html  + "                           <label for='bestTHREE'>Best</label><br>";
html = html  + "                           <input type='radio' id='worstTHREE' name='sortTHREE' value='DESC'>";
html = html  + "                           <label for='worstTHREE'>Worst</label>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <label> in </label>";

html = html + "                   <div class='dropdownBOX'>";
html = html  + "                       <button class='dropbtnBOX'>[location]</button>";
html = html  + "                       <div class='dropdownBOX-content'>";
html = html  + "                           <input type='radio' id='pstateTHREE' name='asareaTHREE' value='State'>";
html = html  + "                           <label for='pstateTHREE'>State</label><br>";
html = html  + "                           <input type='radio' id='plgaTHREE' name='asareaTHREE' value='Lga_Name'>";
html = html  + "                           <label for='plgaTHREE'>Local Govt. Area</label>";

html = html + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <button type='submit' class='btn'>Submit</button>";
html = html  + "               </div>";
html = html  + "           </form>";

String age_groupAgeSort = context.formParam("ageTHREE");
String sort_byAgeSort = context.formParam("sortTHREE");
String area_typeAgeSort = context.formParam("asareaTHREE");

System.out.println(age_groupAgeSort);
System.out.println(sort_byAgeSort);
System.out.println(area_typeAgeSort);

html = html + "           <div class='statecontainer'>";
html = html  + "               <div class='map'>";
html = html  + "                   <img src='4images/ageSort.jpg' alt=''>";
html = html  + "               </div>";

html = html + "               <div class='tablegrid'>";

html = html + "                   <div class='occupy'></div>";

html = html + "                   <div class='statetable'>";

html = html + "                       <div class='sort'>";
html = html  + "                           <div class='best'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                           <div class='worst'>";
html = html  + "                               <p></p>";
html = html  + "                           </div>";
html = html  + "                       </div>";
html = html  + "                   </div>";

html = html + "                   <div class='table'>";

if((age_groupAgeSort == null) && (sort_byAgeSort == null) && (area_typeAgeSort == null)){
html = html  + "                       <img src='4images/table.png' alt=''>";
}
else{

    html = html + "<table stlye='border-collapse: collapse; main:auto;'>";

    // Label for age group on table header
    String finalage="";
    if (!age_groupAgeSort.equals("60")) {
        Integer numericalage = Integer.parseInt(age_groupAgeSort) + 9;
        finalage = Integer.toString(numericalage);
    }
    else{
        finalage = age_groupAgeSort + "+";
    }

    html = html + "<tr>";
    html = html +   "<th>"+area_typeAgeSort+"</th>";
    html = html +   "<th>Population of Homeless between "+ age_groupAgeSort +" and "+ finalage +"</th>";
    html = html + "</tr>";

    ArrayList<AgeSortFOUR> data = connection.page4AgeSort(area_typeAgeSort, age_groupAgeSort, sort_byAgeSort);

    for(AgeSortFOUR datum: data){
        html = html + "<tr>";
        html = html + "<td>" + datum.getareaNameAS() + "</td>";
        html = html + "<td>" + datum.getpopAS() + "</td>";
        html = html + "</tr>";
    }  

    html = html + "</table>";
}

html = html  + "                   </div>";
html = html  + "               </div>";

html = html + "           </div>";
html = html  + "       </div>";


html = html + "       </div>";

html = html + "       <!-- Footer -->";
html = html  + "       <div class='footer'>";

html = html + "           <div class='legal'>";
html = html  + "               <h3>Legal</h3>";
html = html  + "               <div class='flcontent'>";
html = html  + "                   <p>Usage</p>";
html = html  + "                   <p>Cookies</p>";
html = html  + "               </div>";
html = html  + "           </div>";

html = html + "           <div class='sitemap'>";
html = html  + "               <h3>Sitemap</h3>";
html = html  + "               <div class='flearn'>";
html = html  + "                   <h4>Learn</h4>";
html = html  + "                   <!-- <div class='fslcontent'> -->";
html = html  + "                   <p>What is Homelessness</p>";
html = html  + "                   <p>Statistics</p>";
html = html  + "                   <!-- </div> -->";
html = html  + "               </div>";

html = html + "               <div class='fhelp'>";
html = html  + "                   <h4>Help</h4>";
html = html  + "                   <!-- <div class='fshcontent'> -->";
html = html  + "                   <p>What can you do?</p>";
html = html  + "                   <p>Support Services</p>";
html = html  + "                   <!-- </div> -->";
html = html  + "               </div>";
html = html  + "           </div>";

html = html + "           <div class='contact'>";
html = html  + "               <h3>Contact</h3>";
html = html  + "               <div class='ccontent'>";
html = html  + "                   <p>Raf Email</p>";
html = html  + "                   <p>Ad Email</p>";
html = html  + "                   <p>Phone</p>";
html = html  + "                   <p>RMIT Address</p>";
html = html  + "               </div>";
html = html  + "           </div>";
html = html  + "       </div>";

html = html + "       </div>";
html = html  + "       </div>";

html = html + "       <div id='decobox1'></div>";
html = html  + "       <div id='decobox2'></div>";
html = html  + "   ";

html = html  + "   </body>";

html = html + "   </html>";

        // Look up some information from JDBC
        // First we need to use your JDBCConnection class

        // Next we will ask this *class* for the movies
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
