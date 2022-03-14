package app;

import java.util.ArrayList;

import app.helperClasses.AgeData;
import app.helperClasses.GenderData;
import app.helperClasses.Pair;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class Page3 implements Handler {

    // URL of this page relative to http://localhost:7000/
    public static final String URL = "/page3.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>By Area</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='page3.css'/>";
        html = html + "<link rel='stylesheet' type='text/css' href='common.css'/>";
        //CSS Internal

        // Add the body
        html = html + "<body>";

        //Add the top navbar
        html = htmlBuilder.addNavbar(html);


html = html + "<div class='background'>";
html = html + "<h1 style='text-align: center; padding-bottom: 10px;'>Homeless by Area</h1> ";



//Filter options

html = html + "<form action='/page3.html' method='post'>";
    html = html + "<div class='flex-container' style='width:70%;margin:auto; padding-bottom: 50px;'>";

    html = html + "<div class='category'>";
    html = html + " <p>Filter by:</p>";
    html = html + " <select name='filter' id='filter'>";
    html = html + "    <option value='total'>Total Homeless</option>";
    html = html + "    <option value='age_bracket'>Age Brackets</option>";
    html = html + "    <option value='gender'>Gender</option>";
    html = html + " </select>";
    html = html + "</div>";

    html = html + "<div class='category'>";
    html = html + " <p>Sort by:</p>";
    html = html + " <select name='order' id='order'>";
    html = html + "    <option value='DESC'>Descending</option>";
    html = html + "    <option value='ASC'>Ascending</option>";
    html = html + "    <option value='alphabetical'>Alphabetical</option>";
    html = html + " </select>";
    html = html + "</div>";

    html = html + "<div class='category'>";
    html = html + " <p>Area Type:</p>";
    html = html + " <select name='area' id='area'>";
    html = html + "    <option value='lga_name'>Local Government Area</option>";
    html = html + "    <option value='state'>State</option>";
    html = html + " </select>";
    html = html + "</div>";

    html = html + "<div class='category'>";
    html = html + " <p>Year:</p>";
    html = html + " <select name='year' id='year'>";
    html = html + "    <option value='2016'>2016</option>";
    html = html + "    <option value='2018'>2018</option>";
    html = html + " </select>";
    html = html + "</div>";

    html = html + "<div class='category'>";
    html = html + " <p>Showing Results For:</p>";
    html = html + " <select name='results' id='results'>";
    html = html + "    <option value='all'>All</option>";
    html = html + "    <option value='top10'>Top 10</option>";
    html = html + " </select>";
    html = html + "</div>";

    html = html + "<div class='category'>";
    html = html + "<p>Search: </p>";
    html = html + "<input type='text' id='userSearch' name='userSearch' style='max-width:150px'>";
    html = html + "<button type='submit' class='btn btn-primary'>Submit</button>";
    html = html + "</div>";

    html = html + "</div>";

html = html + "</form>";

String filter = context.formParam("filter");
String sort_by = context.formParam("order");
String area_type = context.formParam("area");
String year = context.formParam("year");
String showing = context.formParam("results");
String userSearch = context.formParam("userSearch");


    //Displaying the title of the chart

if(filter != null){
    html = html + "<h2>";
    if(filter.equals("total")){
         html = html + "Total number of Homeless ";
    }
    else if(filter.equals("age_bracket")){
         html = html + "Homeless by age ";
    }
    else if(filter.equals("gender")){ 
        html = html + "Homeless by gender ";
    }
    if(area_type.equals("lga_name")){
        html = html + "in each Local Government Area";
    }
    else if(area_type.equals("state")){
        html = html + "in each State";
    }

    html = html + " during " + year;
    html = html + "</h2>";

    if(showing.equals("match") || showing.equals("partial")){
        html = html + "<h2> Searching for: \"" + userSearch + "\"</h2>";
    }
    else if(showing.equals("top10")){
        html = html + "<h2> Showing the top 10 results </h2>";
    }
    else{
        html = html + "<h2> Showing All results </h2>";
    }

}





//Processing the user inputs

int count = 0;
JDBCConnection connection = new JDBCConnection();


if(filter == null || area_type == null){
    
    html = html + "<h2>Use the above filters and searchbox to find data about the homeless of Australia.<br>You can search for local areas using the searchbar, and filter for exact or partial matches.<br> You can also search for the states of Australia, by searching VIC, NSW, WA, QLD, SA, ACT, NT, TAS.<br></h2>";
}
else{

    html = html + "<div class='table-holder'>";
    html = html +   "<table>";

    if(filter.equals("total")){
        html = html + "<tr>";
        html = html +   "<th>" + area_type + "</th>";
        html = html +   "<th>Total Homeless</th>";
        html = html + "</tr>";

        ArrayList<Pair> data = connection.page3Totals(filter, sort_by, area_type, year, userSearch, showing);

        for(Pair datum: data){
            html = html + "<tr>";
            html = html + "<td>" + datum.getName() + "</td>";
            html = html + "<td>" + datum.getCount() + "</td>";
            html = html + "</tr>";
            count += 1;
        }
    }
    else if(filter.equals("gender")){

        html = html + "<tr>";
        html = html +   "<th>" + area_type + "</th>";
        html = html +   "<th>Total Homeless</th>";
        html = html +   "<th>Female</th>";
        html = html +   "<th>Male</th>";
        html = html + "</tr>";

        ArrayList<GenderData> data = connection.page3Gender(filter, sort_by, area_type, year, userSearch, showing);

        for(GenderData datum: data){
            html = html + "<tr>";
            html = html + "<td>" + datum.getName() + "</td>";
            html = html + "<td>" + datum.getTotal() + "</td>";
            html = html + "<td>" + datum.getFemale() + "</td>";
            html = html + "<td>" + datum.getMale() + "</td>";
            html = html + "</tr>";
            count += 1;
        }
    }
    else{

        html = html + "<tr>";
        html = html +   "<th>" + area_type + "</th>";
        html = html +   "<th>Total Homeless</th>";
        html = html +   "<th>Ages: 0-9</th>";
        html = html +   "<th>10-19</th>";
        html = html +   "<th>20-29</th>";
        html = html +   "<th>30-39</th>";
        html = html +   "<th>40-49</th>";
        html = html +   "<th>50-59</th>";
        html = html +   "<th>60+</th>";
        html = html + "</tr>";


        ArrayList<AgeData> data = connection.page3Age(filter, sort_by, area_type, year, userSearch, showing);

        for(AgeData datum: data){
            html = html + "<tr>";
            html = html + "<td>" + datum.getName() + "</td>";
            html = html + "<td> " + datum.getTotal() + " </td>";
            html = html + "<td>  " + datum.getZero() + "  </td>";
            html = html + "<td>  " + datum.getTen() + "  </td>";
            html = html + "<td>  " + datum.getTwen() + "  </td>";
            html = html + "<td>  " + datum.getThir() + "  </td>";
            html = html + "<td>  " + datum.getFort() + "  </td>";
            html = html + "<td>  " + datum.getFift() + "  </td>";
            html = html + "<td>  " + datum.getSixt() + "  </td>";
            html = html + "</tr>";

            count += 1;
        }
    }
    html = html +   "</table>";
    html = html + "</div>";

    if(count == 0){
        html += "<h2> No results found. </h2>";
    }
}



    html = html + "</div>";
    //Add the footer
    html = htmlBuilder.addFooter(html);


    // Finish the HTML webpage
    html = html + "</body>" + "</html>";


    // DO NOT MODIFY THIS
    // Makes Javalin render the webpage
    context.html(html);
}

}
