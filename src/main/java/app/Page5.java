package app;

import java.util.ArrayList;
import app.helperClasses.fiveGraphData;
import app.helperClasses.fiveTotalData;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Page5 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page5.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Who Experiences Homelessness?</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='page3.css'/>";
        html = html + "<link rel='stylesheet' type='text/css' href='common.css'/>";
        html = html + "</head>";  

        // Add the body
        html = html + "<body>";

        //Add the top navbar
        html = htmlBuilder.addNavbar(html);

        //Add the HTML for the functionality

        html = html + "<div class='background'>";
        html = html + "<h1 style='text-align: center; padding-bottom: 10px;'>Who experiences Homelessness?</h1>";
        html = html + "<p style='text-align: center; padding-bottom: 10px; width: 50%; margin: auto; '>Homelessness during 2018 explored as a ratio.<br><br>Input your preferred filter options to generate a table and chart displaying data about the ratio of homelessness across all of Australia's Local Government Areas. All filters are optional.<br> The searchbar can be used to find individual Local Government Areas.</p>";

        html = html + "<form action='/page5.html' method='post'>";
        html = html + "<div class='flex-container' style='width:70%;margin:auto; padding-bottom: 50px;'>";


        //User Filters and Search

        html = html + "<div class='category'>";
        html = html + " <p>Gender:</p>";
        html = html + " <select name='gender' id='gender'>";
        html = html + "    <option value='all'>All</option>";
        html = html + "    <option value='male'>Male</option>";
        html = html + "    <option value='female'>Female</option>";
        html = html + " </select>";
        html = html + "</div>";

        html = html + "<div class='category'>";
        html = html + " <p>Age Bracket from:</p>";
        html = html + " <select name='ageFrom' id='ageFrom'>";
        html = html + "    <option value='0'>0</option>";
        html = html + "    <option value='10'>10</option>";
        html = html + "    <option value='20'>20</option>";
        html = html + "    <option value='30'>30</option>";
        html = html + "    <option value='40'>40</option>";
        html = html + "    <option value='50'>50</option>";
        html = html + "    <option value='60'>60</option>";
        html = html + " </select>";
        html = html + " <p>to:</p>";
        html = html + " <select name='ageTo' id='ageTo'>";
        html = html + "    <option value='10'>10</option>";
        html = html + "    <option value='20'>20</option>";
        html = html + "    <option value='30'>30</option>";
        html = html + "    <option value='40'>40</option>";
        html = html + "    <option value='50'>50</option>";
        html = html + "    <option value='60'>60</option>";
        html = html + "    <option value='70' selected='selected'>+</option>";
        html = html + " </select>";
        html = html + "</div>";

        // Default values set to encapsulate all data
        html = html + "<div class='flex-container' style='width:95%;margin:auto; padding-bottom: 0px;'>";

            html = html + "<div class='category'>";
            html = html + "<p>Median Income:</p>";
            html = html + "<input type='text' id='minIncome' name='minIncome' value='0'>";
            html = html + "<p> to </p>";   
            html = html + "<input type='text' id='maxIncome' name='maxIncome' value='9999'>";
            html = html + "<p> per week </p>";          
            html = html + "</div>";

            html = html + "<div class='category'>";
            html = html + "<p>Median Rent:</p>";
            html = html + "<input type='text' id='minRent' name='minRent' value='0'>";
            html = html + "<p> to </p>";   
            html = html + "<input type='text' id='maxRent' name='maxRent' value='9999'>";
            html = html + "<p> per week </p>";          
            html = html + "</div>";

            html = html + "<div class='category'>";
            html = html + "<p>Median Mortgage Repayments:</p>";
            html = html + "<input type='text' id='minMortgage' name='minMortgage' value='0'>";
            html = html + "<p> to </p>";   
            html = html + "<input type='text' id='maxMortgage' name='maxMortgage' value='9999'>";
            html = html + "<p> per week </p>";          
            html = html + "</div>";

            html = html + "<div class='category'>";
            html = html + "<p>Median Age:</p>";
            html = html + "<input type='text' id='minAge' name='minAge' value='0'>";
            html = html + "<p> to </p>";   
            html = html + "<input type='text' id='maxAge' name='maxAge' value='99'>";          
            html = html + "</div>";
        
        html = html + "</div>";
        html = html + "<div class='flex-container' style='width:90%;margin:auto; padding-bottom: 10px;'>";

            html = html + "<div class='category'>";
            html = html + "<p>Showing results for:  </p>";    
            html = html + "<select name='showing' id='showing'>";
            html = html + "  <option value='all' selected>All</option>";
            html = html + "  <option value='top10'>Top 10</option>";
            html = html + " </select>";
            html = html + "</div>";

            html = html + "<div class='category'>";
            html = html + "<p>Sort by: </p>";    
            html = html + "<select name='sort' id='sort'>";
            html = html + "  <option value='total' selected>Total Homeless</option>";
            html = html + "  <option value='ratio'>Homelessness Ratio</option>";
            html = html + "  <option value='income'>Median Income</option>";
            html = html + "  <option value='rent'>Median Rent</option>";
            html = html + "  <option value='mortgage'>Median Mortgage Repayments</option>";
            html = html + "  <option value='age'>Median Area Age</option>";
            html = html + "  <option value='population'>Area Total Population</option>";
            html = html + "  <option value='alphabetical'>Alphabetical</option>";
            html = html + " </select>";  
            html = html + "<select name='order' id='order'>";
            html = html + "  <option value='DESC' selected>Descending</option>";
            html = html + "  <option value='ASC'>Ascending</option>";
            html = html + " </select>";
            html = html + "</div>";
        
            html = html + "<div class='category'>";
            html = html + "<p for='search'>Search: </p>";
            html = html + "<input type='text' id='userSearch' name='userSearch' style='max-width: 150px'>";
            html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";
            html = html + "</div>";
        html = html + "</div>";
        html = html + "</form>";

        String sort = context.formParam("sort");
        String order = context.formParam("order");
        String gender = context.formParam("gender");
        String ageFrom = context.formParam("ageFrom");
        String ageTo = context.formParam("ageTo");
        String showing = context.formParam("showing");
        String search = context.formParam("userSearch");
        String minIncome = context.formParam("minIncome");
        String maxIncome = context.formParam("maxIncome");
        String minRent = context.formParam("minRent");
        String maxRent = context.formParam("maxRent");
        String minMortgage = context.formParam("minMortgage");
        String maxMortgage = context.formParam("maxMortgage");
        String minAge = context.formParam("minAge");
        String maxAge = context.formParam("maxAge");

        //Graph Generation
        JDBCConnection connection = new JDBCConnection();
        ArrayList<fiveGraphData> chart_data = new ArrayList<fiveGraphData>();
        int count = 0;

        try{
            ArrayList<fiveTotalData> data = connection.page5Totals(sort, order, gender, ageFrom, ageTo, search, showing, minIncome, maxIncome, minRent, maxRent, minMortgage, maxMortgage, minAge, maxAge);
            for(fiveTotalData datum: data){
                fiveGraphData chartDatum = new fiveGraphData();
                chartDatum.chartGrabTotal(datum, sort);
                chart_data.add(chartDatum);
                count += 1;
            }
        }
        catch(Exception NullPointerException){
            //Do nothing
        }

        try{  
            if(sort.equals("ratio") || sort.equals("alphabetical")){
                html = html + "<div class='table-holder'>";
                html = html + "<p style='color: white'>Sort the data by categories other than \"Homelessness Ratio\" or \"Alphabetical\" for visualisation of results.</p>";
                html = html + "</div>";
            }else{
                if(count == 0){}
                else{
                    html = html + " <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>";
                    html = html + " <script type=\"text/javascript\">";
                    html = html + " google.charts.load('current', {'packages':['corechart']});";
                    html = html + " google.charts.setOnLoadCallback(drawChart);";
                    html = html + " function drawChart(){";
                        html = html + " var data = google.visualization.arrayToDataTable([";
                        html = html + " ['" + sort + "', 'Homelessness Ratio']";
                        for(fiveGraphData row: chart_data){
                            html = html + ", [" + row.xPrint() + ", " + (row.yPrint()) + "]";
                        }
                        html = html + "]);";
                        
                        html = html + " var options = { pointSize: 10, ";
                        html = html + "  hAxis: {title: '" + sort + "', scaleType: 'log', viewWindowMode: 'pretty'}, ";
                        html = html + "  vAxis: {title: 'ratio (%)', scaleType: 'log', viewWindowMode: 'pretty'}, ";
                        html = html + "  dataOpacity: 0.3, axisTitlesPosition: 'out', crosshair: { trigger: 'both' }, ";
                        html = html + "  legend: 'none', chartArea: {left: 40, right: 20, top: 10, bottom: 50, width: '100%', height: '100%'}, colors:['black', 'grey']};";

                    html = html + " var chart = new google.visualization.ScatterChart(document.getElementById('chart_div'));";
                    html = html + " chart.draw(data, options);";

                    html = html + "}";
                    html = html + "</script>";

                    html = html + "<div class='table-holder'>";
                    html = html + "<div id='chart_div' style='width: 900; height: 500;'></div>";
                    html = html + "</div>";
                }
            }
        }
        catch(Exception NullPointerException){}




        //Table Generation

        try{
            if(sort.isEmpty()){
            //Do nothing
            }
            else{

                //Displaying the title of the chart


                html = html + "<div class='flex-container' style='width:100%;margin:auto; padding-bottom: 50px;'>";
                    html = html + "<h2>";
                    html = html + "Ratio of Homeless in each Local Government Area during 2018. <br>";

                    html += "Showing";

                    if(gender.equals("all")){
                        html += " all";
                    }
                    else{
                        html += " all " + gender + "s";
                    }

                    if(Integer.parseInt(ageTo) - Integer.parseInt(ageFrom) != 70){
                        if(ageTo.equals("70")){
                            html += " from the age " + ageFrom + " and above";
                        }
                        else{
                        html += " aged between " + ageFrom + " and " + ageTo;
                        }
                    }
                    
                    html += " experiencing Homelessness.";

                    if(Integer.parseInt(maxAge) - Integer.parseInt(minAge) < 99){
                        html = html + "Filtering Median ages between   " + minAge + " to " + maxAge + "   years old.<br>";
                    }
                    if(Integer.parseInt(maxIncome) - Integer.parseInt(minIncome) < 9999){
                        html = html + "Filtering Median income between   $" + minIncome + " to $" + maxIncome + "   per week.<br>";
                    }
                    if(Integer.parseInt(maxRent) - Integer.parseInt(minRent) < 9999){
                        html = html + "Filtering Median rent between   $" + minRent + " to $" + maxRent + "   per week.<br>";
                    }
                    if(Integer.parseInt(maxMortgage) - Integer.parseInt(minMortgage) < 9999){
                        html = html + "Filtering Median Mortgage between   $" + minMortgage + " to $" + maxMortgage + "   per month. <br>";
                    }

                    html = html + "</h2>";
                html = html + "</div>";
                html = html + "<div class='flex-container' style='width:100%;margin:auto; padding-bottom: 50px;'>";
                    if(search.length() > 0){
                        html = html + "<h2> Searching for: \"" + search + "\"</h2>";
                    }
                    
                    if(showing.equals("top10")){
                        html = html + "<h2> Showing the top 10 results </h2>";
                    }
                    else{
                        html = html + "<h2> Showing All results </h2>";
                    }
                html = html + "</div>";
                
                ArrayList<fiveTotalData> data = connection.page5Totals(sort, order, gender, ageFrom, ageTo, search, showing, minIncome, maxIncome, minRent, maxRent, minMortgage, maxMortgage, minAge, maxAge);

                html = html + "<div class='table-holder'>";
                html = html +   "<table>";
                html = html +      "<tr>";
                html = html +       "<th>Lga Name</th>";
                html = html +       "<th>Ratio</th>";
                html = html +       "<th>Homeless</th>";
                html = html +       "<th>Population</th>";
                html = html +       "<th>Median: Age</th>";
                html = html +       "<th>Mortgage</th>";
                html = html +       "<th>Rent</th>";
                html = html +       "<th>Income</th>";
                html = html +      "</tr>";


                for(fiveTotalData datum: data){
                    html = html + "<tr>";
                    html = html +   "<td>" + datum.getName() + "</td>";
                    html = html +   "<td>" + datum.getRatio() + "%</td>";
                    html = html +   "<td>" + datum.getTotal() + "</td>";
                    html = html +   "<td>" + datum.getPopulation() + "</td>";
                    html = html +   "<td>" + datum.getAge() + "</td>";
                    html = html +   "<td>" + datum.getMortgage() + "</td>";
                    html = html +   "<td>" + datum.getRent() + "</td>";
                    html = html +   "<td>" + datum.getIncome() + "</td>";
                    html = html + "</tr>";
                    count += 1;
                }
            }
        }
        catch(Exception NullPointerException){
            //When the user hasn't entered a filter, show this description
            html = html + "<h2>Press Submit to search</h2>";
        }

        html = html +   "</table>";
        html = html + " </div>";
        html = html + "</div>";


        //Show error if there is no result
        if(count == 0){
            html += "<h2> No results found. </h2>";
        }


        //Add the footer
        html = htmlBuilder.addFooter(html);
        //Finish the page
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
        }
    }
