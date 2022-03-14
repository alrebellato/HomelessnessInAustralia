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
public class Page6 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page6.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

html = html + "        <head>";
html = html + "    <meta charset='UTF-8'>";
html = html + "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>";
html = html + "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>";
html = html + "    <link rel='stylesheet' href='page6.css'>";
html = html + "    <title>Change in Homelessness Over Time</title>";
html = html + "</head>";

html = html + "<body>";

html = html + "    <!-- NAVIGATION START -->";
html = html + "    <div class='topnav'>";
html = html + "        <div class='flexbox'>";
html = html + "            <a href='/page1.html'><img src='commonImages/logo_new.png' alt='Homefull' height = 35px style='object-fit: contain; border-radius: 0px;'></a>";
html = html + "        </div>";
html = html + "        <div class='flexbox' style='flex-grow: 100;'></div>";
html = html + "        <div class='dropdownNAV'>";
html = html + "            <button class='dropbtnNAV'>Big Picture</button>";
html = html + "            <div class='dropdown-contentNAV'>";
html = html + "                <a href='page1.html'>Home and Explore</a>";
html = html + "                <a href='page2.html'>Three Big Facts</a>";
html = html + "            </div>";
html = html + "        </div>";
html = html + "        <div class='dropdownNAV'>";
html = html + "            <button class='dropbtnNAV'>Shallow Glance</button>";
html = html + "            <div class='dropdown-contentNAV'>";
html = html + "                <a href='page3.html'>Homelessness by Area</a>";
html = html + "                <a href='page4.html'>People at Risk</a>";
html = html + "            </div>";
html = html + "        </div>";
html = html + "        <div class='dropdownNAV' style='margin-right: 120px;'>";
html = html + "            <button class='dropbtnNAV'>Deep Dive</button>";
html = html + "            <div class='dropdown-contentNAV'>";
html = html + "                <a href='page5.html'>Who Experiences Homelessness</a>";
html = html + "                <a href='page6.html'>Change Over Time</a>";
html = html + "            </div>";
html = html + "        </div>";
html = html + "    </div>";
html = html + "    <!-- NAVIGATION END -->";

html = html + "    <!-- .bod start CONTENT START -->";
html = html + "    <div class='bod'>";
html = html + "        <div class='deepdive'>";
html = html + "            >Deep <br> Dive_";
html = html + "        </div>";

html = html + "        <div class='slogan'>";
html = html + "            <h1>Change in</h1>";
html = html + "            <h1>Homelessness</h1>";
html = html + "            <h1>Over Time</h1>";
html = html + "        </div>";

html = html + "        <div class='decobox'></div>";

JDBCConnection connection = new JDBCConnection();
html = html + "        <!-- SPECIFIC LGA SEARCH -->";
html = html + "        <div class='querytitle'>";
html = html + "            <h2>>Specific LGA Search_</h2>";
html = html + "        </div>";
html = html + "        <div class='querybox'>";
html = html + "            <form action='/page6.html' method='post'>";
html = html + "                <!-- Prompt -->";
html = html + "                <div class='prompt'>";
html = html + "                    <label class='promptheader'>Rate of</label>";
html = html + "                    <!-- Gender Selection -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX'>[GENDER]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='firstfemale' name='firstgender' value='female'>";
html = html + "                            <label for='firstfemale'>Female</label><br>";
html = html + "                            <input type='radio' id='firstmale' name='firstgender' value='male'>";
html = html + "                            <label for='firstmale'>Male</label>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader'>Changes in </label>";
html = html + "                     <!-- Specific Area Selection -->";
html = html + "                    <input type='text' id='lganame' name='lganame' placeholder='[LGA_NAME]'>";
html = html + "                    <label class='promptheader'> &#160;over 2016-2018 aged between</label>";
html = html + "                     <!-- Age Selection -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX'>[AGE_GROUP]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='0-10FIRST' name='ageFIRST' value='0'>";
html = html + "                            <label for='0-10FIRST'>0-10</label><br>";
html = html + "                            <input type='radio' id='10-19FIRST' name='ageFIRST' value='10'>";
html = html + "                            <label for='10-19FIRST'>10-19</label><br>";
html = html + "                            <input type='radio' id='20-29FIRST' name='ageFIRST' value='20'>";
html = html + "                            <label for='20-29FIRST'>20-29</label><br>";
html = html + "                            <input type='radio' id='30-39FIRST' name='ageFIRST' value='30'>";
html = html + "                            <label for='30-39FIRST'>30-39</label><br>";
html = html + "                            <input type='radio' id='40-49FIRST' name='ageFIRST' value='40'>";
html = html + "                            <label for='40-49FIRST'>40-49</label><br>";
html = html + "                            <input type='radio' id='50-59FIRST' name='ageFIRST' value='50'>";
html = html + "                            <label for='50-59FIRST'>50-59</label><br>";
html = html + "                            <input type='radio' id='60+FIRST' name='ageFIRST' value='60'>";
html = html + "                            <label for='60+FIRST'>60+</label>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader' style='color: #FF0000;'>.</label>";
html = html  + "                   <button type='submit' class='btn'>Submit</button>";
html = html + "                </div>";
html = html  + "           </form>";

String firstgender = context.formParam("firstgender");
String lganame = context.formParam("lganame");
String ageFIRST = context.formParam("ageFIRST");

// System.out.println(firstgender + lganame + ageFIRST);

// POST PROCESSING OF DATA
// at risk and homelessness diferences
ArrayList<firstBOX> data = connection.page6FIRSTBOX(firstgender, lganame, ageFIRST);

// get data for homelessness and at risk
double postAtRisk = firstBOX.getatRisk();
double postHomeless = firstBOX.gethomeless();


// System.out.println("values for atx risk and homeless: " + postAtRisk + " , H: " + postHomeless);

// inintitate string
String displayAtRisk = "";
String displayHomeless = "";


// Add signage at start of string
// if (postAtRisk > 0.0f) {
//     displayAtRisk += "+ ";
// }
// if (postHomeless > 0.0f) {
//     displayHomeless += "+ ";
// }

// total population
ArrayList<firstBOXPOP> d = connection.page6FIRSTBOXPOP(lganame);


// Get data for total population
double postCurrent = firstBOXPOP.getcurrentPop();
double postBefore = firstBOXPOP.getpreviousPop();
// calculate the total difference
double totalPop = postCurrent - postBefore;

String sPop = "";
if (totalPop > 0) {
    sPop += "+ ";
}

// Calculate the differential composition for the percentage ratio
Double postHomelessR = postHomeless * 53.47622;
// System.out.println("total change in Pop: " + totalPop);
// System.out.println("postCurrent: " + postCurrent + " , postBefore: " + postBefore);

// convert at risk and homeless into %
postAtRisk = (postAtRisk/totalPop) * 100;
postHomeless = (postHomeless/totalPop) * 100;

// Add the ints to the main string
displayAtRisk += Double.toString(postAtRisk);
displayHomeless += Double.toString(postHomeless);
sPop += Double.toString(totalPop);

// ratio
Double ratioHomless = (postHomelessR / (postCurrent - postAtRisk)) * 100.0;
Double ratioAtRisk = 100.0 - ratioHomless;

// System.out.println("display values: " + displayAtRisk + " , H: " + displayHomeless);



html = html + "                <!-- Ouput for Prompt -->";
html = html + "                <div class='output'>";
// html = html + "                    <div class='graph'>";
// html = html + "                        <img src='6images/chart.png' alt='Enter in the filters to generate chart'>";
// html = html + "                    </div>";
html = html + "                    <div class='info'>";
html = html + "                        <div class='infolabel'>% change in no. of Homeless: </div>";
html = html + "                        <div class='infooutput'>";

// before any data is entered
if (lganame == null){
html = html + "                        XX";
}
else{
html = html + displayHomeless.substring(0,6) + "%" ;
}
html = html + "                        </div>";
html = html + "                        <div class='infolabel'>% change in no. of 'At Risk': </div>";
html = html + "                        <div class='infooutput'>";

if (lganame == null){
html = html + "XX";
}
else{
    html = html + displayAtRisk.substring(0,6) + "%" ;
    }
html = html + "</div>";
html = html + "                        <div class='infolabel'>Change in total LGA population: </div>";
html = html + "                        <div class='infooutput'>";

if (lganame == null){
html = html + "XX";
}
else{
    html = html + sPop + " people(s)";
    }
html = html + "</div>";
html = html + "                        <div class='infolabel'>Percentage of change in no. of homeless in contrast to the percentage change in no. of people being at risk of being homeless:</div>";
html = html + "                        <div class='infooutput'>";


try{
if (lganame == null){
html = html + "XX:XX";
}
else{
    html = html + "Homeless: " + ratioHomless.toString().substring(0,6) + "%  |  At Risk: " + ratioAtRisk.toString().substring(0,6) + "%" ;
}
}
catch(Exception stringIndexOutOfBoundsException){
    html = html + "Homeless: " + ratioHomless.toString() + "%  |  At Risk: " + ratioAtRisk.toString() + "%" ;
}
html = html + "</div>";
html = html + "                    </div>";
html = html + "                </div>";
html = html + "            </form>";
html = html + "        </div>";

html = html + "        <!-- COLLECTIVE LGA SEARCH -->";
html = html + "        <div class='decobox' style='top: 60px; margin-left: 3px; width: 150px;'></div>";

html = html + "        <div class='querytitle' style='color: rgb(81, 185, 255); margin-top: 80px;'>";
html = html + "            <h2>>Collective LGA Search (States and Country)_</h2>";
html = html + "        </div>";
html = html + "        <div class='querybox'>";
html = html + "            <form action='/page6.html' method='post'>";
html = html + "                <!-- Prompt -->";
html = html + "                <div class='prompt'>";
html = html + "                    <label class='promptheader'>Rate of</label>";

html = html + "                    <!-- Gender Selection -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX'>[GENDER]</button>";
html = html + "                        <div class='dropdownBOX-content'>";


html = html + "                            <input type='radio' id='secondall' name='secondgender' value='all' checked>";
html = html + "                            <label for='secondall'>All Genders</label><br>";
html = html + "                            <input type='radio' id='secondfemale' name='secondgender' value='female'>";
html = html + "                            <label for='secondfemale'>Female</label><br>";
html = html + "                            <input type='radio' id='secondmale' name='secondgender' value='male'>";
html = html + "                            <label for='secondmale'>Male</label>";


html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader'>Changes in </label>";

html = html + "                    <!-- Collective Area Selection -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX'>[AREA]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='australiaFIRST' name='collectiveAreaSECOND' value='all' checked>";
html = html + "                            <label for='australiaFIRST'>Australia</label><br>";
html = html + "                            <input type='radio' id='VicFIRST' name='collectiveAreaSECOND' value='VIC'>";
html = html + "                            <label for='vicFIRST'>VIC</label><br>";
html = html + "                            <input type='radio' id='nswFIRST' name='collectiveAreaSECOND' value='NSW'>";
html = html + "                            <label for='nswFIRST'>NSW</label><br>";
html = html + "                            <input type='radio' id='qldFIRST' name='collectiveAreaSECOND' value='QLD'>";
html = html + "                            <label for='qldFIRST'>QLD</label><br>";
html = html + "                            <input type='radio' id='waFIRST' name='collectiveAreaSECOND' value='WA'>";
html = html + "                            <label for='waFIRST'>WA</label><br>";
html = html + "                            <input type='radio' id='saFIRST' name='collectiveAreaSECOND' value='SA'>";
html = html + "                            <label for='saFIRST'>SA</label><br>";
html = html + "                            <input type='radio' id='ntFIRST' name='collectiveAreaSECOND' value='NT'>";
html = html + "                            <label for='ntFIRST'>NT</label><br>";
html = html + "                            <input type='radio' id='tasFIRST' name='collectiveAreaSECOND' value='TAS'>";
html = html + "                            <label for='tasFIRST'>TAS</label><br>";
html = html + "                            <input type='radio' id='actFIRST' name='collectiveAreaSECOND' value='ACT'>";
html = html + "                            <label for='actFIRST'>ACT</label><br>";
html = html + "                        </div>";
html = html + "                    </div>";

html = html + "                    <label class='promptheader'> &#160;over 2016-2018 aged between</label>";
html = html + "                    <!-- Age Selection -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX'>[AGE_GROUP]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='allAgeFIRST' name='ageSECOND' value='all' checked>";
html = html + "                            <label for='allAgeFIRST'>All Age Groups</label><br>";
html = html + "                            <input type='radio' id='0-10FIRST' name='ageSECOND' value='0'>";
html = html + "                            <label for='0-10FIRST'>0-10</label><br>";
html = html + "                            <input type='radio' id='10-19FIRST' name='ageSECOND' value='10'>";
html = html + "                            <label for='10-19FIRST'>10-19</label><br>";
html = html + "                            <input type='radio' id='20-29FIRST' name='ageSECOND' value='20'>";
html = html + "                            <label for='20-29FIRST'>20-29</label><br>";
html = html + "                            <input type='radio' id='30-39FIRST' name='ageSECOND' value='30'>";
html = html + "                            <label for='30-39FIRST'>30-39</label><br>";
html = html + "                            <input type='radio' id='40-49FIRST' name='ageSECOND' value='40'>";
html = html + "                            <label for='40-49FIRST'>40-49</label><br>";
html = html + "                            <input type='radio' id='50-59FIRST' name='ageSECOND' value='50'>";
html = html + "                            <label for='50-59FIRST'>50-59</label><br>";
html = html + "                            <input type='radio' id='60+FIRST' name='ageSECOND' value='60'>";
html = html + "                            <label for='60+FIRST'>60+</label>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader'> where</label>";

html = html + "                    <!-- Total Population Filter -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX' style='color: crimson;'>[TOTAL_POPULATION]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='secondTotPopNo' name='secondTotPop' value='0' checked>";
html = html + "                            <label for=' secondTotPopNo '>Don't Add Filter</label><br>";
html = html + "                            <input type='radio' id='secondTotINC' name='secondTotPop' value='1'>";
html = html + "                            <label for='secondTotINC'>Increase</label><br>";
html = html + "                            <input type='radio' id='secondTotDEC' name='secondTotPop' value='2'>";
html = html + "                            <label for='secondTotDEC'>Decrease</label>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader'>,</label>";

html = html + "                    <!-- Change In Homelessness Filter -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX' style='color: crimson;'>[Change In Homelessness]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='secondCIHNo' name='secondCIH' value='0' checked>";
html = html + "                            <label for=' secondCIHNo '>Don't Add Filter</label><br>";
html = html + "                            <input type='radio' id='secondCIHINC' name='secondCIH' value='1'>";
html = html + "                            <label for='secondCIHINC'>Increase</label><br>";
html = html + "                            <input type='radio' id='secondCIHDEC' name='secondCIH' value='2'>";
html = html + "                            <label for='secondCIHDEC'>Decrease</label>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader'>,</label>";

html = html + "                    <!-- Change In At Risk Filter -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX' style='color: crimson;'>[Change In At_Risk]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='secondCIARNo' name='secondCIAR' value='0' checked>";
html = html + "                            <label for='secondCIARNo'>Don't Add Filter</label><br>";
html = html + "                            <input type='radio' id='secondCIARINC' name='secondCIAR' value='1'>";
html = html + "                            <label for='secondCIARINC'>Increase</label><br>";
html = html + "                            <input type='radio' id='secondCIARDEC' name='secondCIAR' value='2'>";
html = html + "                            <label for='secondCIARDEC'>Decrease</label>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader'>,</label>";

html = html + "                    <!-- Ratio of Homeless : At Risk -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX' style='color: crimson;'>[% of Homeless : At_Risk]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='secondRatioNo' name='secondRatio' value='0' checked>";
html = html + "                            <label for='secondRatioNo'>Don't Add Filter</label><br>";
html = html + "                            <input type='radio' id='secondRatioINC' name='secondRatio' value='1'>";
html = html + "                            <label for='secondRatioINC'>Increase</label><br>";
html = html + "                            <input type='radio' id='secondRatioDEC' name='secondRatio' value='2'>";
html = html + "                            <label for='secondRatioDEC'>Decrease</label>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader'>by</label>";

html = html + "                    <!-- Sort filter -->";
html = html + "                    <div class='dropdownBOX'>";
html = html + "                        <button class='dropbtnBOX'>[Sort]</button>";
html = html + "                        <div class='dropdownBOX-content'>";
html = html + "                            <input type='radio' id='secondSortINC' name='secondSort' value='DESC' checked>";
html = html + "                            <label for='secondSortINC'>Highest Overall Population</label><br>";
html = html + "                            <input type='radio' id='secondSortDEC' name='secondSort' value='ASC'>";
html = html + "                            <label for='secondSortDEC'>Lowest Overall Population</label>";
html = html + "                        </div>";
html = html + "                    </div>";
html = html + "                    <label class='promptheader' style='color: #FF0000;'>.</label>";
html = html  + "                   <button type='submit' class='btn'>Submit</button>";
html = html + "                </div>";
html = html + "            </form>";

// Grab variables from form
String secondgender = context.formParam("secondgender");
String collectiveAreaSECOND = context.formParam("collectiveAreaSECOND");
String ageSECOND = context.formParam("ageSECOND");
String secondTotPop = context.formParam("secondTotPop");
String secondCIH = context.formParam("secondCIH");
String secondCIAR = context.formParam("secondCIAR");
String secondRatio = context.formParam("secondRatio");
String secondSort = context.formParam("secondSort");

// Submit data to JDBC
ArrayList<sixSecondBox> secondData = connection.page6SecondBox(secondgender, collectiveAreaSECOND, ageSECOND, secondTotPop, secondCIH, secondCIAR, secondRatio, secondSort);

// ready the data from array
try {
    // grab the last array item which will have the sum of all the rows
    sixSecondBox noRows = secondData.get(secondData.size() - 1);
    sixSecondBox citp = secondData.get(secondData.size() - 1);
    sixSecondBox cih = secondData.get(secondData.size() - 1);
    sixSecondBox ciar = secondData.get(secondData.size() - 1);
    sixSecondBox rh = secondData.get(secondData.size() - 1);
    
    System.out.println("CIAR: " + ciar.getciar() + " No. rows: " + noRows.getcitpCount() + " CITP: " + citp.getcitp() + " CIH: " + cih.getcih() + " Ratio homeless: " + rh.getrh());


html = html + "                <!-- Ouput for Prompt -->";
html = html + "                <div class='secondoutput'>";

html = html + "                    <div class='secondinfo'>";
html = html + "                        <div class='secondinfolabel'>% change in no. of Homeless: </div>";
html = html + "                        <div class='secondinfooutput'>";
if (!(secondgender.equals("all")) && !(secondgender.equals("female")) && !(secondgender.equals("male"))){
    html = html + "XX";
}
else{
    Double finalCIH = (cih.getcih() / noRows.getcitpCount());
    html = html + finalCIH.toString().substring(0,6) + "%";
}

html = html + "</div>";
html = html + "                        <div class='secondinfolabel'>% change in no. of 'At Risk': </div>";
html = html + "                        <div class='secondinfooutput'>";

if (!(secondgender.equals("all")) && !(secondgender.equals("female")) && !(secondgender.equals("male"))){
    html = html + "XX";
}
else{
    Double finalCIAR = (ciar.getciar() / noRows.getcitpCount());
    html = html + finalCIAR.toString().substring(0,6) + "%";
}
html = html + "</div>";
html = html + "                        <div class='secondinfolabel'>% change in total population in selected areas: </div>";
html = html + "                        <div class='secondinfooutput'>";

if (!(secondgender.equals("all")) && !(secondgender.equals("female")) && !(secondgender.equals("male"))){
    html = html + "XX";
}
else{
    Double finalCITP = (citp.getcitp() / noRows.getcitpCount());
    html = html + finalCITP.toString().substring(0,6) + "%";
}
html = html + "</div>";
html = html + "                        <div class='secondinfolabel'>Percentage of change in no. of homeless in contrast to the percentage change in no. of people being at risk of being homeless: </div>";
html = html + "                        <div class='secondinfooutput'>";

if (!(secondgender.equals("all")) && !(secondgender.equals("female")) && !(secondgender.equals("male"))){
    html = html + "XX:XX";
}
else{
    Double finalRH = (ciar.getrh() / noRows.getcitpCount());
    Double finalRAR = (100.0 - finalRH);

    html = html + "Homeless: " + finalRH.toString().substring(0,6) + "%  | At Risk:  " + finalRAR.toString().substring(0,6) + "%";
}
html = html + "</div>";
html = html + "                    </div>";
} catch (Exception IndexOutOfBoundsException) {
}
html = html + "                    <div class='sortedtable'>";
html = html + "                        <div class='sortedtableheader'>";
html = html + "                            <h3>Sorted LGA Table:</h3>";
html = html + "                        </div>";
html = html + "                        <div class='sortedtabledescription'>";

try {
// rename if staments for display query
String displayArea = collectiveAreaSECOND;
if (collectiveAreaSECOND.equals("all")){
    displayArea = "Australia";
}
else {
    displayArea = collectiveAreaSECOND;
}

String displayTotPop = "";
if (secondTotPop.equals("0")){
    displayTotPop = "Don't Add Filter";
}
else if (secondTotPop.equals("1")){
    displayTotPop = "Increase";
}
else{
    displayTotPop = "Decrease";
}

String displayCIH = "";
if (secondCIH.equals("0")){
    displayCIH = "Don't Add Filter";
}
else if (secondCIH.equals("1")){
    displayCIH = "Increase";
}
else{
    displayCIH = "Decrease";
}

String displayCIAR = "";
if (secondCIAR.equals("0")){
    displayCIAR = "Don't Add Filter";
}
else if (secondCIAR.equals("1")){
    displayCIAR = "Increase";
}
else{
    displayCIAR = "Decrease";
}

String displayRatio = "";
if (secondRatio.equals("0")){
    displayRatio = "Don't Add Filter";
}
else if (secondRatio.equals("1")){
    displayRatio = "Increase";
}
else{
    displayRatio = "Decrease";
}

String displayAge = ageSECOND;
if (ageSECOND.equals("0") || ageSECOND.equals("10") || ageSECOND.equals("20") || ageSECOND.equals("30") || ageSECOND.equals("40") || ageSECOND.equals("50")){
    Integer calculateAge = (Integer.parseInt(ageSECOND) + 9);
    displayAge = ageSECOND + "-" + calculateAge.toString();
}
else if (ageSECOND.equals("60")){
    displayAge = ageSECOND + "+";
}
else{
    displayAge = "All Ages";
}

html = html + "                            <h4>LGA Names within "+displayArea+" by "+secondSort+" order based off your filters: Gender = "+secondgender+" | Area = "+collectiveAreaSECOND+" | Age Group = "+ displayAge +" | Total Population = "+displayTotPop+" | Change in Homelessness = "+displayCIH+" | Change in 'At Risk' = "+displayCIAR+" | Percentage of Homeless";
html = html + "                                : 'At Risk' = "+displayRatio+" | SORT: "+secondSort+"</h4>";
} catch (Exception nullPointerException) {
}
html = html + "                        </div>";
html = html + "                        <div class='OLoutside'>";
html = html + "                            <ol class='horizontal'>";
ArrayList<sixSecondBoxNAMES> secondDataNames = connection.page6SecondBoxNAMES(secondgender, collectiveAreaSECOND, ageSECOND, secondTotPop, secondCIH, secondCIAR, secondRatio, secondSort);

for(sixSecondBoxNAMES datum: secondDataNames){
    html = html + "<li>" + datum.getareaNameSecond() + "</li>";
}
html = html + "                            </ol>";
html = html + "                        </div>";
html = html + "                        <div style='clear: both;'></div>";
html = html + "                    </div>";

html = html + "                </div>";
html = html + "        </div>";



html = html + "    </div>";
html = html + "    <!-- .bod end CONTENT END-->";

html = html + "    <div class='footer'>";
html = html + "        <div class='legal'>";
html = html + "            <h3>Legal</h3>";
html = html + "            <div class='flcontent'>";
html = html + "                <p>Usage</p>";
html = html + "                <p>Cookies</p>";
html = html + "            </div>";
html = html + "        </div>";

html = html + "        <div class='sitemap'>";
html = html + "            <h3>Sitemap</h3>";
html = html + "            <div class='flearn'>";
html = html + "                <h4>Learn</h4>";
html = html + "                <!-- <div class='fslcontent'> -->";
html = html + "                <p>What is Homelessness</p>";
html = html + "                <p>Statistics</p>";
html = html + "                <!-- </div> -->";
html = html + "            </div>";

html = html + "            <div class='fhelp'>";
html = html + "                <h4>Help</h4>";
html = html + "                <!-- <div class='fshcontent'> -->";
html = html + "                <p>What can you do?</p>";
html = html + "                <p>Support Services</p>";
html = html + "                <!-- </div> -->";
html = html + "            </div>";
html = html + "        </div>";

html = html + "        <div class='contact'>";
html = html + "            <h3>Contact</h3>";
html = html + "            <div class='ccontent'>";
html = html + "                <p>Raf Email</p>";
html = html + "                <p>Ad Email</p>";
html = html + "                <p>Phone</p>";
html = html + "                <p>RMIT Address</p>";
html = html + "            </div>";
html = html + "        </div>";
html = html + "    </div>";


html = html + "</body>";

html = html + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
