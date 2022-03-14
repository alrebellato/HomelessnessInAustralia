package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.helperClasses.AgeData;
import app.helperClasses.AgeSortFOUR;
import app.helperClasses.GenderData;
import app.helperClasses.GenderSortFOUR;
import app.helperClasses.Pair;
import app.helperClasses.fiveAgeData;
import app.helperClasses.fiveGenderData;
import app.helperClasses.fiveTotalData;
import app.helperClasses.fourlgaAgeData;
import app.helperClasses.fourlgaGenderData;
import app.helperClasses.fourlgaTotalData;
import app.helperClasses.fourstateAgeData;
import app.helperClasses.fourstateGenderData;
import app.helperClasses.fourstateTotalData;
import app.helperClasses.twoGrowth;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 * 
 * This is an example JDBC Connection that has a single query for the Movies Database
 * This is similar to the project workshop JDBC examples.
 *
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 */
public class JDBCConnection {

    // Name of database file (contained in database folder)
    private static final String DATABASE = "jdbc:sqlite:database/HomelessnessAR.db";

    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    public float page2Female(){
        // Setup the variable for the JDBC connection
        Connection connection = null;

        float result = 0.0F;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = ""

            + "SELECT round(cast(female AS float)/cast(total AS float) *100, 1) AS result"
            + " FROM"
            + " (SELECT sum(count) AS 'female'"
            + " FROM datum"
            + " WHERE year = 2018"
            + " AND gender = 'female'"
            + " GROUP BY gender) "
            + " JOIN"
            + " (SELECT sum(count) AS 'total'"
            + " FROM datum"
            + " WHERE year = 2018);";


            ResultSet results = statement.executeQuery(query);

            result = results.getFloat("result");

            // Close the statement because we are done with it
            statement.close();




        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    public float page2Children(){
        // Setup the variable for the JDBC connection
        Connection connection = null;

        float result = 0.0F;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = ""

            + "SELECT round(cast(child AS float)/cast(total AS float) *100, 1) AS result"
            + " FROM"
            + " (SELECT sum(count) AS 'child'"
            + " FROM datum"
            + " WHERE year = 2018"
            + " AND age_bracket = 0"
            + " GROUP BY gender) "
            + " JOIN"
            + " (SELECT sum(count) AS 'total'"
            + " FROM datum"
            + " WHERE year = 2018);";


            ResultSet results = statement.executeQuery(query);

            result = results.getFloat("result");

            // Close the statement because we are done with it
            statement.close();




        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    public ArrayList<twoGrowth> page2States(){
        // Setup the variable for the JDBC connection
        Connection connection = null;

        ArrayList<twoGrowth> result = new ArrayList<twoGrowth>();

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT state_fullname, growth FROM (SELECT a.state, six, eight, round((eight - six)/cast(eight AS float(7,2))*100, 2) as 'growth' FROM (SELECT state, sum(count) AS 'six' FROM datum d JOIN lga l ON d.lga_code = l.lga_code WHERE year = 2016 GROUP BY state ) a JOIN (SELECT state, sum(count) AS 'eight' FROM datum d JOIN lga l ON d.lga_code = l.lga_code WHERE year = 2018 GROUP BY state ) b ON a.state = b.state) JOIN state_names ON state = state_names.state_abr ORDER BY growth DESC LIMIT 5;";



            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                String name = results.getString("state_fullname");
                float growth = results.getFloat("growth");

                result.add(new twoGrowth(name, growth));
            }
            
            // Close the statement because we are done with it
            statement.close();




        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    public ArrayList<Pair> page3Totals(String filter, String sort, String area, String year, String search, String showing) {
        ArrayList<Pair> result = new ArrayList<Pair>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            
            query = "SELECT " + area + ", SUM(count) FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = " + year + " AND condition = 'homeless' AND d.count > 0";
            query += " AND " + area + " LIKE '%" + search + "%'";
            query +=  "GROUP BY " + area;

            if(sort.equals("alphabetical")){
                query += " ORDER BY " + area + " ASC";
            }
            else{
                query += " ORDER BY sum(count) " + sort;
            }  
            
            if(showing.equals("top10")){
                query += " LIMIT 10";
            }

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString(area);
                int total_count = results.getInt("SUM(count)");

                result.add(new Pair(name, total_count));
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    public ArrayList<GenderData> page3Gender(String filter, String sort, String area, String year, String search, String showing) {
        ArrayList<GenderData> result = new ArrayList<GenderData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
  
            String query = "" 
                +"SELECT " + area + ", (male + female) AS 'Total Homeless', male, female "
                +"FROM "
                +"("
                +"SELECT " + area + ", sum(count) AS 'male' "
                +"FROM lga l JOIN datum d " 
                +"ON l.lga_code = d.lga_code " 
                +"WHERE condition = 'homeless' AND d.year = 2018 AND gender = 'male' AND d.count > 0 "
                +"GROUP BY gender, l." + area
                +")"
                +" NATURAL JOIN "
                +"("
                +"SELECT " + area + ", sum(count) AS 'female' "
                +"FROM lga l JOIN datum d "
                +"ON l.lga_code = d.lga_code "
                +"WHERE condition = 'homeless' AND d.year = 2018 AND gender = 'female' AND d.count > 0 "
                +"GROUP BY gender, l." + area
                +")"
                +" WHERE " + area + " LIKE '%" + search + "%'";


                if(sort.equals("alphabetical")){
                    query += " ORDER BY " + area + " ASC";
                }
                else{
                    query += " ORDER BY (male + female) " + sort;
                }
                
                if(showing.equals("top10")){
                    query += " LIMIT 10";
                }


            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString(area);
                int total = results.getInt("Total Homeless");
                int male = results.getInt("male");
                int female = results.getInt("female");

                //As the data is stored sequentially we skip a row.


                result.add(new GenderData(name, total, male, female));
            }


            // Close the statement because we are done with it
            statement.close();
        } 
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } 
        finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    public ArrayList<AgeData> page3Age(String filter, String sort, String area, String year, String search, String showing){
        ArrayList<AgeData> result = new ArrayList<AgeData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = 
            "SELECT * FROM"
            + "(SELECT " + area + ", sum(count) AS 'total' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE condition = 'homeless' AND d.year = " + year + " AND d.count > 0 GROUP BY " + area + ") "
            + "NATURAL JOIN"
            + "(SELECT " + area + ", sum(count) AS '0-9' FROM lga l JOIN datum d ON l.lga_code = d.lga_code  WHERE condition = 'homeless' AND d.year = " + year + " AND d.count > 0 AND age_bracket = 0 GROUP BY age_bracket, " + area + ")"
            + "NATURAL JOIN"
            + "(SELECT " + area + ", sum(count) AS '10-19' FROM lga l JOIN datum d ON l.lga_code = d.lga_code  WHERE condition = 'homeless' AND d.year = " + year + " AND d.count > 0 AND age_bracket = 10 GROUP BY age_bracket, " + area + ")"
            + "NATURAL JOIN"
            + "(SELECT " + area + ", sum(count) AS '20-29' FROM lga l JOIN datum d ON l.lga_code = d.lga_code  WHERE condition = 'homeless' AND d.year = " + year + " AND d.count > 0 AND age_bracket = 20 GROUP BY age_bracket, " + area + ")"
            + "NATURAL JOIN"
            + "(SELECT " + area + ", sum(count) AS '30-39' FROM lga l JOIN datum d ON l.lga_code = d.lga_code  WHERE condition = 'homeless' AND d.year = " + year + " AND d.count > 0 AND age_bracket = 30 GROUP BY age_bracket, " + area + ")"
            + "NATURAL JOIN"
            + "(SELECT " + area + ", sum(count) AS '40-49' FROM lga l JOIN datum d ON l.lga_code = d.lga_code  WHERE condition = 'homeless' AND d.year = " + year + " AND d.count > 0 AND age_bracket = 40 GROUP BY age_bracket, " + area + ")"
            + "NATURAL JOIN"
            + "(SELECT " + area + ", sum(count) AS '50-59' FROM lga l JOIN datum d ON l.lga_code = d.lga_code  WHERE condition = 'homeless' AND d.year = " + year + " AND d.count > 0 AND age_bracket = 50 GROUP BY age_bracket, " + area + ")"
            + "NATURAL JOIN"
            + "(SELECT " + area + ", sum(count) AS '60+' FROM lga l JOIN datum d ON l.lga_code = d.lga_code  WHERE condition = 'homeless' AND d.year = " + year + " AND age_bracket = 60 GROUP BY age_bracket, " + area + ")";
            query += " WHERE " + area + " LIKE '%" + search + "%'"; 
            if(sort.equals("alphabetical")){
                query += " ORDER BY " + area + " ASC";
            }
            else{
                query += " ORDER BY total " + sort;
            }  
            
            if(showing.equals("top10")){
                query += " LIMIT 10";
            }

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString(area);

                int total = results.getInt("total");

                int zero = results.getInt("0-9");

                int ten = results.getInt("10-19");

                int twenty = results.getInt("20-29");

                int thirty = results.getInt("30-39");

                int forty = results.getInt("40-49");

                int fifty = results.getInt("50-59");

                int sixty = results.getInt("60+");

                result.add(new AgeData(name, total, zero, ten, twenty, thirty, forty, fifty, sixty));
            }


            // Close the statement because we are done with it
            statement.close();
        } 
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } 
        finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

// ============= PAGE 4 STATE AGE =============
    public ArrayList<fourstateAgeData> page4Age(String state){
        ArrayList<fourstateAgeData> result = new ArrayList<fourstateAgeData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);



            String query = "SELECT ab.bracket, sum(count) FROM datum d JOIN lga l ON d.lga_code = l.lga_code JOIN age_brackets ab ON d.age_bracket = ab.lowerBound WHERE l.state LIKE '%" + state + "' AND d.condition = 'at_risk'  AND year = 2018 GROUP BY d.age_bracket ORDER BY bracket ASC LIMIT 28";
           

            // String query = "SELECT age_bracket, SUM(count)" +
            // "FROM datum d NATURAL JOIN lga l" +
            // "WHERE l.state = '" + state + "'" +
            // "AND condition = 'at_risk'" +
            // "AND year = '2018'" +
            // "GROUP BY age_bracket";

            // String query = "SELECT bracket, subquery.sum FROM age_brackets ab JOIN (SELECT age_bracket, SUM(count) as sum FROM datum d NATURAL JOIN lga l WHERE l.state = '"+state+"' AND condition = 'at_risk' AND year = '2018' GROUP BY age_bracket) subquery ON ab.lowerBound = subquery.age_bracket";

            System.out.println("Q FOR STATE AGE: " + query);
   
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String bracket = results.getString("bracket");
                int bracketData = results.getInt("sum(count)");

                result.add(new fourstateAgeData(bracket, bracketData));
            }


            // Close the statement because we are done with it
            statement.close();
        } 
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } 
        finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    // ============= PAGE 4 STATE TOTAL POPULATION =============
    public ArrayList<fourstateTotalData> page4TotalDatas(String state){
        ArrayList<fourstateTotalData> result = new ArrayList<fourstateTotalData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);



            String query = "SELECT sum(count) FROM datum d JOIN lga l ON d.lga_code = l.lga_code WHERE l.state = '" + state + "'  AND d.year = 2018 GROUP BY l.state LIMIT 28";
            
            System.out.println("Q FOR STATE TOTALS: " + query);
   
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int totalStatePop = results.getInt("sum(count)");
                result.add(new fourstateTotalData(totalStatePop));
            }


            // Close the statement because we are done with it
            statement.close();
        } 
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } 
        finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

     // ============= PAGE 4 STATE GENDER =============
     public ArrayList<fourstateGenderData> page4GenderDatas(String state){
        ArrayList<fourstateGenderData> result = new ArrayList<fourstateGenderData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);



            String query = "SELECT gender, sum(count) FROM datum d JOIN lga l ON d.lga_code = l.lga_code WHERE l.state = '" + state + "'  AND d.year = 2018 GROUP BY  d.gender LIMIT 28";
            
            System.out.println("Q FOR STATE GENDER: " + query);
   
            ResultSet results = statement.executeQuery(query);

            // While statement has been cut as table is only 2 rows
                // Female should always be first
                int  female = results.getInt("sum(count)");
                // Male data in second row so go to that
                results.next();
                results.next();
                int male = results.getInt("sum(count)");
                // Ship it off to the class
                result.add(new fourstateGenderData(female, male));
            


            // Close the statement because we are done with it
            statement.close();
        } 
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } 
        finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }


    // ============= PAGE 4 LGA AGE =============
    public ArrayList<fourlgaAgeData> page4AgeLGA(String lga){
        ArrayList<fourlgaAgeData> result = new ArrayList<fourlgaAgeData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);



            String query = "SELECT ab.bracket, sum(count) FROM datum d JOIN lga l ON d.lga_code = l.lga_code JOIN age_brackets ab ON d.age_bracket = ab.lowerBound WHERE l.lga_name LIKE '%" + lga + "' AND d.condition = 'at_risk'  AND year = 2018 GROUP BY d.age_bracket ORDER BY bracket ASC LIMIT 28";

            System.out.println("Q FOR lga AGE: " + query);
   
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String bracket = results.getString("bracket");
                int bracketData = results.getInt("sum(count)");

                result.add(new fourlgaAgeData(bracket, bracketData));
            }


            // Close the statement because we are done with it
            statement.close();
        } 
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } 
        finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    // ============= PAGE 4 LGA TOTAL POPULATION =============
    public ArrayList<fourlgaTotalData> page4TotalDatasLGA(String lga){
        ArrayList<fourlgaTotalData> result = new ArrayList<fourlgaTotalData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);



            String query = "SELECT sum(count) FROM datum d JOIN lga l ON d.lga_code = l.lga_code WHERE l.lga_name = '" + lga + "'  AND d.year = 2018 GROUP BY l.lga_name LIMIT 28";
            
            System.out.println("Q FOR lga TOTALS: " + query);
   
            ResultSet results = statement.executeQuery(query);

                int totallgaPop = results.getInt("sum(count)");

                result.add(new fourlgaTotalData(totallgaPop));
            


            // Close the statement because we are done with it
            statement.close();
        } 
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } 
        finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

     // ============= PAGE 4 LGA GENDER =============
     public ArrayList<fourlgaGenderData> page4GenderDatasLGA(String lga){
        ArrayList<fourlgaGenderData> result = new ArrayList<fourlgaGenderData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);



            String query = "SELECT gender, sum(count) FROM datum d JOIN lga l ON d.lga_code = l.lga_code WHERE l.lga_name = '" + lga + "'  AND d.year = 2018 GROUP BY  d.gender LIMIT 28";
            
            System.out.println("Q FOR LGA GENDER: " + query);
   
            ResultSet results = statement.executeQuery(query);

            // While statement has been cut as table is only 2 rows
            // Ignore the gender in the SELECT
                // Female should always be first as SQL sorts alphabetically
                int  female = results.getInt("sum(count)");
                // System.out.println("this is " + female);
                // Male data in second row so go to that
                results.next();
                results.next();
                int male = results.getInt("sum(count)");
                // System.out.println("this is " + male);
                // Ship it off to the class
                result.add(new fourlgaGenderData(female, male));


            // Close the statement because we are done with it
            statement.close();
        } 
        catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } 
        finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    // ============= PAGE 4 POPULATION SORT =============
    public ArrayList<Pair> page4Totals(String filter, String sort, String area, String year) {
        ArrayList<Pair> result = new ArrayList<Pair>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            
            query = "SELECT " + area + ", SUM(count) FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = " + year + " AND condition = 'homeless' GROUP BY " 
            + area + " ORDER BY SUM(count) " + sort + " LIMIT 28";

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String name = results.getString(area);
                int total_count = results.getInt("SUM(count)");

                result.add(new Pair(name, total_count));
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }
    // ============= PAGE 4 GENDER SORT =============

    public ArrayList<GenderSortFOUR> page4GenderSort(String area, String gender, String sort) {
        ArrayList<GenderSortFOUR> result = new ArrayList<GenderSortFOUR>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            
            query = "SELECT " + area + ", SUM(count) FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND condition = 'at_risk' AND gender = '" + gender + "'  GROUP BY  "+ area +" ORDER BY SUM(count)" + sort + " LIMIT 28";
      
            System.out.println("KQUERY: " + query);

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String areaName = results.getString(area);
                int total_count = results.getInt("SUM(count)");

                result.add(new GenderSortFOUR(areaName, total_count));
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    // ============= PAGE 4 AGE SORT =============

    public ArrayList<AgeSortFOUR> page4AgeSort(String area, String age, String sort) {
        ArrayList<AgeSortFOUR> result = new ArrayList<AgeSortFOUR>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            
            query = "SELECT "+ area +", SUM(count)  FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND condition = 'at_risk'   AND age_bracket = "+ age +" GROUP BY  "+ area +" ORDER BY SUM(count)" + sort + " LIMIT 28";
            
            System.out.println("Final Query" + query);

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String areaNameAS = results.getString(area);
                int total_countAS = results.getInt("SUM(count)");

                result.add(new AgeSortFOUR(areaNameAS, total_countAS));
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    // PAGE 6 1ST BOX (Homeless and At Risk) [Total Population is stored below]

    public ArrayList<firstBOX> page6FIRSTBOX(String firstgender, String lganame, String ageFIRST) {
        ArrayList<firstBOX> result = new ArrayList<firstBOX>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            
            query = "SELECT count - LAG(count, 1, 0) OVER ( PARTITION BY condition ORDER BY year ) AS total_difference "
            + "FROM lga l JOIN datum d ON l.lga_code = d.lga_code " 
            + "WHERE gender = '"+ firstgender +"' AND  lga_name = '"+ lganame +"' AND age_bracket = "+ ageFIRST
            + " GROUP BY year, condition "
            + "ORDER BY year DESC"
            + " LIMIT 2";
            
            System.out.println("PGAGE 6 FIRST BOX Query: " + query);

            ResultSet results = statement.executeQuery(query);

            
                int at_risk = results.getInt("total_difference");
                results.next();
                results.next();
                int homeless = results.getInt("total_difference");

                result.add(new firstBOX(at_risk, homeless));
            

            // Close the statement because we are done with it
            statement.close();
        
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    // PAGE 6 1ST BOX (Total Population) [stored seperately for easy readabilty and maintenace]
    public ArrayList<firstBOXPOP> page6FIRSTBOXPOP(String lganame) {
        ArrayList<firstBOXPOP> result = new ArrayList<firstBOXPOP>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            
            query = "SELECT lga_name, gender, age_bracket, year, condition, SUM(count) "
            + "FROM lga l JOIN datum d ON l.lga_code = d.lga_code " 
            + "WHERE lga_name = '"+ lganame +"'"
            + " GROUP BY year "
            + "ORDER BY year DESC";
            
            // System.out.println("PAGE 6 FIRST BOX total pop Query: " + query);

            ResultSet results = statement.executeQuery(query);

            
                int currentPop = results.getInt("SUM(count)");
                results.next();
                results.next();
                int previousPop = results.getInt("SUM(count)");

                result.add(new firstBOXPOP(currentPop, previousPop));
            

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    // PAGE 6 2ND BOX FOR EVERYTHING EXCEPT FOR NAMES
    public ArrayList<sixSecondBox> page6SecondBox(String secondgender, String collectiveAreaSECOND, String ageSECOND
    , String secondTotPop, String secondCIH, String secondCIAR, String secondRatio, String secondSort) {
        ArrayList<sixSecondBox> result = new ArrayList<sixSecondBox>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            String queryGender = "";
            String areaSelect = "";
            String areaWhere = "";
            String ageWhere = "";
            String sortQuery = "";
            String finalWhere = "";
            String finalWhereTotPop = "";
            String finalWhereCIH = "";
            String finalWhereCIAR = "";
            String finalWhereRatio = "";

            try {
                // Use java to satisfy conditions
                // PRIMARY FILTERS
                // gender
                if (secondgender.equals("all")) {
                    queryGender = "";
                }
                else if (secondgender.equals("male")){
                    queryGender = " AND gender = 'male' ";
                }
                else{
                    queryGender = " AND gender = 'female' ";
                }
                // area
                if (collectiveAreaSECOND.equals("all")){
                    areaSelect = "state";
                    areaWhere = "";
                }
                else{
                    areaSelect = "lga_name";
                    areaWhere = " AND state = '" + collectiveAreaSECOND + "' ";
                }
                // age groups
                if (ageSECOND.equals("all")) {
                    ageWhere = "";
                }
                else{
                    ageWhere = " AND age_bracket = " + ageSECOND;
                }
                // sort by overall population
                if (secondSort != null){
                    sortQuery = " " + secondSort;
                }
                // ADDITIONAL FILTERS
                Boolean firstFilterAbsent = false;
                Boolean secondFilterAbsent = false;
                Boolean thirdFilterAbsent = false;
                Boolean fourthFilterAbsent = false;

                Boolean firstFilterPresent = false;
                Boolean secondFilterPresent = false;
                Boolean thirdFilterPresent = false;
                Boolean fourthFilterPresent = false;
    
                // if statement to see if any additional filters exist
                if (secondTotPop.equals("0") && secondCIH.equals("0") && secondCIAR.equals("0") && secondRatio.equals("0")){
                    finalWhere = "";
                }
                // if additional filters exists
                else {
                    finalWhere = " WHERE ";
                    
                    // % change in Population
                    if (secondTotPop.equals("0")){
                        finalWhereTotPop = "";
                        firstFilterAbsent = true;
                    }
                    else if (secondTotPop.equals("1")){
                        finalWhereTotPop = " difference > 0 ";
                        firstFilterPresent = true;
                    }
                    else{
                        finalWhereTotPop = " difference < 0 ";
                        firstFilterPresent = true;
                    }
    
                    // % change in homeless
                    if (firstFilterAbsent = true && firstFilterPresent != true){
                        if (secondCIH.equals("0")){
                            finalWhereCIH = "";
                            secondFilterAbsent = true;
                        }
                        else if (secondCIH.equals("1")){
                            finalWhereCIH = " hdifference > 0 ";
                            secondFilterPresent = true;

                        }
                        else{
                            finalWhereCIH = " hdifference < 0 ";
                            secondFilterPresent = true;
                        }
                    }
                    else{
                        if (secondCIH.equals("0")){
                            finalWhereCIH = "";
                        }
                        else if (secondCIH.equals("1")){
                            finalWhereCIH = " AND hdifference > 0 ";
                            secondFilterPresent = true;
                        }
                        else{
                            finalWhereCIH = " AND hdifference < 0 ";
                            secondFilterPresent = true;
                        }
                    }
    
                    // % change in at risk
                    if ((firstFilterAbsent = true) && (secondFilterAbsent = true) && (firstFilterPresent != true) && (secondFilterPresent != true)){
                        if (secondCIAR.equals("0")){
                            finalWhereCIAR = "";
                            thirdFilterAbsent = true;
                        }
                        else if (secondCIAR.equals("1")){
                            finalWhereCIAR = " ardifference > 0 ";
                            thirdFilterPresent = true;
                        }
                        else{
                            finalWhereCIAR = " ardifference < 0 ";
                            thirdFilterPresent = true;
                        }
                    }
                    else{
                        if (secondCIAR.equals("0")){
                            finalWhereCIAR = "";
                        }
                        else if (secondCIAR.equals("1")){
                            finalWhereCIAR = " AND ardifference > 0 ";
                            thirdFilterPresent = true;
                        }
                        else{
                            finalWhereCIAR = " AND ardifference < 0 ";
                            thirdFilterPresent = true;
                        }
                    }
    
                     // % change in ratiodiffrence
                     if ((firstFilterAbsent = true)  && (secondFilterAbsent = true) && (thirdFilterAbsent = true) && (firstFilterPresent != true) && (secondFilterPresent != true) && (thirdFilterPresent != true)){
                        if (secondRatio.equals("0")){
                            finalWhereRatio = "";
                        }
                        else if (secondRatio.equals("1")){
                            finalWhereRatio = " ratiodifference > 0 ";
                        }
                        else{
                            finalWhereRatio = " ratiodifference < 0 ";
                        }
                    }
                    else{
                        if (secondRatio.equals("0")){
                            finalWhereRatio = "";
                        }
                        else if (secondRatio.equals("1")){
                            finalWhereRatio = " AND ratiodifference > 0 ";
                        }
                        else{
                            finalWhereRatio = " AND ratiodifference < 0 ";
                        }
                    }
                }
            } 
            catch (Exception nullpointerException) {
            }
            

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            
            query = ""
            + " SELECT " + areaSelect + ", (current - previous) AS difference,"
            + "  (hcurrent - hprevious) AS hdifference, (arcurrent - arprevious) AS ardifference, "
            + "  ((RATIOhcurrent + RATIOarcurrent) - (RATIOhprevious + RATIOarprevious)) AS ratiodifference,"
            + ""
            + "  (((CAST ((AVG(current) - AVG(previous)) AS FLOAT(7,2))) / (AVG(current) + AVG(previous))) * 100) AS percentChangeT,"
            + "  ((CAST ((AVG(hcurrent) - AVG(hprevious)) / (AVG(hcurrent) + AVG(hprevious)) AS FLOAT(7,2))) * 100) AS percentChangeH,"
            + "  ((CAST ((AVG(arcurrent) - AVG(arprevious)) / (AVG(arcurrent) + AVG(arprevious)) AS FLOAT(7,2))) * 100) AS percentChangeAR,"
            + "  (CAST ((AVG(hcurrent) + AVG(hprevious)) AS FLOAT(7,2)) / CAST ((AVG(hcurrent) + AVG(hprevious) + AVG(arcurrent) + AVG(arprevious)) AS FLOAT(7,2)) * 100) AS ratioHomeless"
            
            + " FROM"
            + " ("
            + " SELECT " + areaSelect + ", sum(population) AS 'previous' "
            + " FROM"
            + " lga l JOIN pop_stats p ON l.lga_code = p.lga_code"
            + " WHERE year = 2016"
            + " GROUP BY " + areaSelect
            + " ) "
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(population) AS 'current' "
            + " FROM"
            + " lga l  JOIN pop_stats p ON l.lga_code = p.lga_code"
            + " WHERE year = 2018"
            + " GROUP BY " + areaSelect
            + " ) "
            + ""
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'hcurrent' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2018 AND condition = 'homeless'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'hprevious' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2016 AND condition = 'homeless'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'arcurrent' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2018 AND condition = 'at_risk'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'arprevious' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2016 AND condition = 'at_risk'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'RATIOarcurrent' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2018 AND condition = 'at_risk'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'RATIOarprevious' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2016 AND condition = 'at_risk'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'RATIOhcurrent' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2018 AND condition = 'homeless'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'RATIOhprevious' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2016 AND condition = 'homeless'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + finalWhere + finalWhereTotPop + finalWhereCIH + finalWhereCIAR + finalWhereRatio
            + " GROUP BY " + areaSelect
            + " ORDER BY (current) " + sortQuery;
            
            // Diagnoses
            // System.out.println("Final Query" + query);

            ResultSet results = statement.executeQuery(query);

            // initialise variables oustide loop
            Double citp = 0.0;
            Double citpCount = 0.0;

            Double cih = 0.0;

            Double ciar = 0.0;

            Double rh = 0.0;

            while (results.next()) {
                // iterate through the rows adding each value in the row up to the main variable up top
                try {
                    // ======================================================= change in total pop (find average in java)      
                    citp += results.getDouble("percentChangeT");
                    // count number of rows for average
                    citpCount++;
                    // ======================================================= change in Homeless (find average in java)
                    cih += results.getDouble("percentChangeH");
                    // ======================================================= change in at risk (find average in java)
                    ciar += results.getDouble("percentChangeAR");
                    // ======================================================= ratio of Homeless (calculate in HTML)                
                    rh += results.getDouble("ratioHomeless");                
                } 
                catch (Exception nullpointerException) {
                }
    
                result.add(new sixSecondBox(citpCount, citp, cih, ciar, rh));
            }
            

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    // SECOND QUERY FOR NAMES
    public ArrayList<sixSecondBoxNAMES> page6SecondBoxNAMES(String secondgender, String collectiveAreaSECOND, String ageSECOND
    , String secondTotPop, String secondCIH, String secondCIAR, String secondRatio, String secondSort) {
        ArrayList<sixSecondBoxNAMES> result = new ArrayList<sixSecondBoxNAMES>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            String queryGender = "";
            String areaSelect = "";
            String areaWhere = "";
            String ageWhere = "";
            String sortQuery = "";
            String finalWhere = "";
            String finalWhereTotPop = "";
            String finalWhereCIH = "";
            String finalWhereCIAR = "";
            String finalWhereRatio = "";

            try {
                // Use java to satisfy conditions
                // PRIMARY FILTERS
                // gender
                if (secondgender.equals("all")) {
                    queryGender = "";
                }
                else if (secondgender.equals("male")){
                    queryGender = " AND gender = 'male' ";
                }
                else{
                    queryGender = " AND gender = 'female' ";
                }
                // area
                if (collectiveAreaSECOND.equals("all")){
                    areaSelect = "state";
                    areaWhere = "";
                }
                else{
                    areaSelect = "lga_name";
                    areaWhere = " AND state = '" + collectiveAreaSECOND + "' ";
                }
                // age groups
                if (ageSECOND.equals("all")) {
                    ageWhere = "";
                }
                else{
                    ageWhere = " AND age_bracket = " + ageSECOND;
                }
                // sort by overall population
                if (secondSort != null){
                    sortQuery = " " + secondSort;
                }
                // ADDITIONAL FILTERS
                Boolean firstFilterAbsent = false;
                Boolean secondFilterAbsent = false;
                Boolean thirdFilterAbsent = false;
                Boolean fourthFilterAbsent = false;

                Boolean firstFilterPresent = false;
                Boolean secondFilterPresent = false;
                Boolean thirdFilterPresent = false;
                Boolean fourthFilterPresent = false;
    
                // if statement to see if any additional filters exist
                if (secondTotPop.equals("0") && secondCIH.equals("0") && secondCIAR.equals("0") && secondRatio.equals("0")){
                    finalWhere = "";
                }
                // if additional filters exists
                else {
                    finalWhere = " WHERE ";
                    
                    // % change in Population
                    if (secondTotPop.equals("0")){
                        finalWhereTotPop = "";
                        firstFilterAbsent = true;
                    }
                    else if (secondTotPop.equals("1")){
                        finalWhereTotPop = " difference > 0 ";
                        firstFilterPresent = true;
                    }
                    else{
                        finalWhereTotPop = " difference < 0 ";
                        firstFilterPresent = true;
                    }
    
                    // % change in homeless
                    if (firstFilterAbsent = true && firstFilterPresent != true){
                        if (secondCIH.equals("0")){
                            finalWhereCIH = "";
                            secondFilterAbsent = true;
                        }
                        else if (secondCIH.equals("1")){
                            finalWhereCIH = " hdifference > 0 ";
                            secondFilterPresent = true;

                        }
                        else{
                            finalWhereCIH = " hdifference < 0 ";
                            secondFilterPresent = true;
                        }
                    }
                    else{
                        if (secondCIH.equals("0")){
                            finalWhereCIH = "";
                        }
                        else if (secondCIH.equals("1")){
                            finalWhereCIH = " AND hdifference > 0 ";
                            secondFilterPresent = true;
                        }
                        else{
                            finalWhereCIH = " AND hdifference < 0 ";
                            secondFilterPresent = true;
                        }
                    }
    
                    // % change in at risk
                    if ((firstFilterAbsent = true) && (secondFilterAbsent = true) && (firstFilterPresent != true) && (secondFilterPresent != true)){
                        if (secondCIAR.equals("0")){
                            finalWhereCIAR = "";
                            thirdFilterAbsent = true;
                        }
                        else if (secondCIAR.equals("1")){
                            finalWhereCIAR = " ardifference > 0 ";
                            thirdFilterPresent = true;
                        }
                        else{
                            finalWhereCIAR = " ardifference < 0 ";
                            thirdFilterPresent = true;
                        }
                    }
                    else{
                        if (secondCIAR.equals("0")){
                            finalWhereCIAR = "";
                        }
                        else if (secondCIAR.equals("1")){
                            finalWhereCIAR = " AND ardifference > 0 ";
                            thirdFilterPresent = true;
                        }
                        else{
                            finalWhereCIAR = " AND ardifference < 0 ";
                            thirdFilterPresent = true;
                        }
                    }
    
                     // % change in ratiodiffrence
                     if ((firstFilterAbsent = true)  && (secondFilterAbsent = true) && (thirdFilterAbsent = true) && (firstFilterPresent != true) && (secondFilterPresent != true) && (thirdFilterPresent != true)){
                        if (secondRatio.equals("0")){
                            finalWhereRatio = "";
                        }
                        else if (secondRatio.equals("1")){
                            finalWhereRatio = " ratiodifference > 0 ";
                        }
                        else{
                            finalWhereRatio = " ratiodifference < 0 ";
                        }
                    }
                    else{
                        if (secondRatio.equals("0")){
                            finalWhereRatio = "";
                        }
                        else if (secondRatio.equals("1")){
                            finalWhereRatio = " AND ratiodifference > 0 ";
                        }
                        else{
                            finalWhereRatio = " AND ratiodifference < 0 ";
                        }
                    }
                }
            } 
            catch (Exception nullpointerException) {
            }
            

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";
            
            query = ""
            + " SELECT " + areaSelect + ", (current - previous) AS difference,"
            + "  (hcurrent - hprevious) AS hdifference, (arcurrent - arprevious) AS ardifference, "
            + "  ((RATIOhcurrent + RATIOarcurrent) - (RATIOhprevious + RATIOarprevious)) AS ratiodifference,"
            + ""
            + "  (((CAST ((AVG(current) - AVG(previous)) AS FLOAT(7,2))) / (AVG(current) + AVG(previous))) * 100) AS percentChangeT,"
            + "  ((CAST ((AVG(hcurrent) - AVG(hprevious)) / (AVG(hcurrent) + AVG(hprevious)) AS FLOAT(7,2))) * 100) AS percentChangeH,"
            + "  ((CAST ((AVG(arcurrent) - AVG(arprevious)) / (AVG(arcurrent) + AVG(arprevious)) AS FLOAT(7,2))) * 100) AS percentChangeAR,"
            + "  (CAST ((AVG(hcurrent) + AVG(hprevious)) AS FLOAT(7,2)) / CAST ((AVG(hcurrent) + AVG(hprevious) + AVG(arcurrent) + AVG(arprevious)) AS FLOAT(7,2)) * 100) AS ratioHomeless"
            
            + " FROM"
            + " ("
            + " SELECT " + areaSelect + ", sum(population) AS 'previous' "
            + " FROM"
            + " lga l JOIN pop_stats p ON l.lga_code = p.lga_code"
            + " WHERE year = 2016"
            + " GROUP BY " + areaSelect
            + " ) "
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(population) AS 'current' "
            + " FROM"
            + " lga l  JOIN pop_stats p ON l.lga_code = p.lga_code"
            + " WHERE year = 2018"
            + " GROUP BY " + areaSelect
            + " ) "
            + ""
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'hcurrent' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2018 AND condition = 'homeless'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'hprevious' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2016 AND condition = 'homeless'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'arcurrent' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2018 AND condition = 'at_risk'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'arprevious' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2016 AND condition = 'at_risk'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'RATIOarcurrent' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2018 AND condition = 'at_risk'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'RATIOarprevious' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2016 AND condition = 'at_risk'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'RATIOhcurrent' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2018 AND condition = 'homeless'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + " NATURAL JOIN"
            + " ("
            + " SELECT " + areaSelect + ", sum(count) AS 'RATIOhprevious' "
            + " FROM"
            + " datum d JOIN lga l ON d.lga_code = l.lga_code"
            + " WHERE year = 2016 AND condition = 'homeless'" + queryGender + areaWhere + ageWhere
            + " GROUP BY " + areaSelect
            + " )"
            + finalWhere + finalWhereTotPop + finalWhereCIH + finalWhereCIAR + finalWhereRatio
            + " GROUP BY " + areaSelect
            + " ORDER BY (current) " + sortQuery;
            
            // Diagnoses
            // System.out.println("Final Query" + query);

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                // iterate through the rows adding each value in the row up to the main variable up top
                try {
                    //  ======================================================= area name
                    String areaNameSecond = results.getString(areaSelect);
                    result.add(new sixSecondBoxNAMES(areaNameSecond));
                } 
                catch (Exception nullpointerException) {
                }
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }
    





    //======================================= Page 5 methods ====================================================

    public ArrayList<fiveGenderData> page5Gender(String sort, String order, String search, String showing,
            String minIncome, String maxIncome, String minRent, String maxRent, String minMortgage, String maxMortgage,
            String minAge, String maxAge) {
            
        ArrayList<fiveGenderData> result = new ArrayList<fiveGenderData>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "";

            query += "SELECT lga_name, round(cast(total AS float(7,2)) / cast(population AS float(7,2)), 4)*100 AS ratio, total, round(cast(male AS float(7,2)) / cast(population AS float(7,2)), 4) AS male_ratio, male, round(cast(female AS float(7,2)) / cast(population AS float(7,2)), 4) AS female_ratio, female, population, age, mortgage, rent, income";
            query += " FROM";
            query += " ((SELECT l.lga_code, lga_name, sum(count) AS 'total', median_age as 'age', median_mortgage_repay_monthly as 'mortgage', median_rent_weekly as 'rent', median_household_weekly_income as 'income' ";
            query += " FROM lga l JOIN datum d ";
            query += " ON l.lga_code = d.lga_code";
            query += " WHERE d.year = 2018 AND condition = 'homeless'";
            query += " GROUP BY l.lga_code)";
            query += " NATURAL JOIN";
            query += " (SELECT m.lga_code, male, female FROM";
            query += " (SELECT lm.lga_code, sum(count) as 'male'";
            query += " FROM lga lm JOIN datum dm";
            query += " ON lm.lga_code = dm.lga_code";
            query += " WHERE dm.year = 2018 AND condition = 'homeless'";
            query += " AND gender = 'male'";
            query += " GROUP BY lm.lga_code) m";
            query += " JOIN";
            query += " (SELECT lf.lga_code, sum(count) as 'female'";
            query += " FROM lga lf JOIN datum df";
            query += " ON lf.lga_code = df.lga_code";
            query += " WHERE df.year = 2018 AND condition = 'homeless'";
            query += " AND gender = 'female'";
            query += " GROUP BY lf.lga_code) f";
            query += " ON m.lga_code = f.lga_code)";
            query += " ) hd";
            query += " JOIN";
            query += " pop_stats p";
            query += " ON hd.lga_code = p.lga_code";
            query += " WHERE lga_name LIKE '%" + search + "%' AND total > 0";
            query += " AND p.year = 2018";
            query += " AND age BETWEEN "+ minAge + " AND " + maxAge;
            query += " AND mortgage BETWEEN "+ minMortgage + " AND " + maxMortgage;
            query += " AND rent BETWEEN "+ minRent + " AND " + maxRent;
            query += " AND income BETWEEN "+ minIncome + " AND " + maxIncome;
            
            if(sort.equals("alphabetical")){
                query += " ORDER BY lga_name " + order;
            }
            else{
                query += " ORDER BY " + sort + " " + order;
            }  
            
            if(showing.equals("top10")){
                query += " LIMIT 10";
            }


            ResultSet results = statement.executeQuery(query);

            while (results.next()) {

                String name = results.getString("lga_name");
                float ratio = results.getFloat("ratio");
                int total = results.getInt("total");
                float male_ratio = results.getFloat("male_ratio");
                int male = results.getInt("male");
                float female_ratio = results.getFloat("female_ratio");
                int female = results.getInt("female");
                int population = results.getInt("population");
                int age = results.getInt("age");
                int mortgage = results.getInt("mortgage");
                int rent = results.getInt("rent");
                int income = results.getInt("income");

                result.add(new fiveGenderData(name, ratio, total, male_ratio, male, female_ratio, female, population, age, mortgage, rent, income));
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    public ArrayList<fiveAgeData> page5Age(String sort, String order, String search, String showing,
            String minIncome, String maxIncome, String minRent, String maxRent, String minMortgage, String maxMortgage,
            String minAge, String maxAge) {
        
                ArrayList<fiveAgeData> result = new ArrayList<fiveAgeData>();

                // Setup the variable for the JDBC connection
                Connection connection = null;
        
                try {
                    // Connect to JDBC data base
                    connection = DriverManager.getConnection(DATABASE);
        
                    // Prepare a new SQL Query & Set a timeout
                    Statement statement = connection.createStatement();
                    statement.setQueryTimeout(30);
        
                    // The Query
                    String query = "";
                    query += " SELECT lga_name, round(cast(total AS float(7,2)) / cast(population AS float(7,2)), 4)*100 AS ratio, total, population, age, mortgage, rent, income,";
                    query += " round(cast(zero AS float(7,2)) / cast(population AS float(7,2)), 4)*100 as 'zero',";
                    query += " round(cast(ten  AS float(7,2)) / cast(population AS float(7,2)), 4)*100 as 'ten',";
                    query += " round(cast(twen AS float(7,2)) / cast(population AS float(7,2)), 4)*100 as 'twen',";
                    query += " round(cast(thir AS float(7,2)) / cast(population AS float(7,2)), 4)*100 as 'thir',";
                    query += " round(cast(fort AS float(7,2)) / cast(population AS float(7,2)), 4)*100 as 'fort',";
                    query += " round(cast(fift AS float(7,2)) / cast(population AS float(7,2)), 4)*100 as 'fift',";
                    query += " round(cast(sixt AS float(7,2)) / cast(population AS float(7,2)), 4)*100 as 'sixt'";
                    query += " FROM ";
                    query += " ((SELECT l.lga_code, lga_name, sum(count) AS 'total', median_age as 'age', median_mortgage_repay_monthly as 'mortgage', median_rent_weekly as 'rent', median_household_weekly_income as 'income' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND condition = 'homeless' GROUP BY l.lga_code)";
                    query += " NATURAL JOIN";
                    query += " (SELECT l.lga_code, sum(count) AS 'zero' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND age_bracket = 0 AND condition = 'homeless' GROUP BY l.lga_code)";
                    query += " NATURAL JOIN";
                    query += " (SELECT l.lga_code, sum(count) AS 'ten' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND age_bracket = 10 AND condition = 'homeless' GROUP BY l.lga_code)";
                    query += " NATURAL JOIN";
                    query += " (SELECT l.lga_code, sum(count) AS 'twen' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND age_bracket = 20 AND condition = 'homeless' GROUP BY l.lga_code)";
                    query += " NATURAL JOIN";
                    query += " (SELECT l.lga_code, sum(count) AS 'thir' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND age_bracket = 30 AND condition = 'homeless' GROUP BY l.lga_code)";
                    query += " NATURAL JOIN";
                    query += " (SELECT l.lga_code, sum(count) AS 'fort' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND age_bracket = 40 AND condition = 'homeless' GROUP BY l.lga_code)";
                    query += " NATURAL JOIN";
                    query += " (SELECT l.lga_code, sum(count) AS 'fift' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND age_bracket = 50 AND condition = 'homeless' GROUP BY l.lga_code)";
                    query += " NATURAL JOIN";
                    query += " (SELECT l.lga_code, sum(count) AS 'sixt' FROM lga l JOIN datum d ON l.lga_code = d.lga_code WHERE d.year = 2018 AND age_bracket = 60 AND condition = 'homeless' GROUP BY l.lga_code)) hd";
                    query += " JOIN";
                    query += " pop_stats p";
                    query += " ON hd.lga_code = p.lga_code";
                    query += " WHERE lga_name LIKE '%" + search + "%' AND total > 0";
                    query += " AND p.year = 2018";
                    query += " AND age BETWEEN "+ minAge + " AND " + maxAge;
                    query += " AND mortgage BETWEEN "+ minMortgage + " AND " + maxMortgage;
                    query += " AND rent BETWEEN "+ minRent + " AND " + maxRent;
                    query += " AND income BETWEEN "+ minIncome + " AND " + maxIncome;              
                    if(sort.equals("alphabetical")){
                        query += " ORDER BY lga_name " + order;
                    }
                    else{
                        query += " ORDER BY " + sort + " " + order;
                    }  
                    
                    if(showing.equals("top10")){
                        query += " LIMIT 10";
                    }

        
                    ResultSet results = statement.executeQuery(query);
        
                    while (results.next()){
        
                        String name = results.getString("lga_name");
                        float ratio = results.getFloat("ratio");
                        int total = results.getInt("total");
                        int population = results.getInt("population");
                        int age = results.getInt("age");
                        int mortgage = results.getInt("mortgage");
                        int rent = results.getInt("rent");
                        int income = results.getInt("income");
                        float zero = results.getFloat("zero");
                        float ten = results.getFloat("ten");
                        float twenty = results.getFloat("twen");
                        float thirty = results.getFloat("thir");
                        float forty = results.getFloat("fort");
                        float fifty = results.getFloat("fift");
                        float sixty = results.getFloat("sixt");
                        result.add(new fiveAgeData(name, ratio, total, population, age, mortgage, rent, income, zero, ten, twenty, thirty, forty, fifty, sixty));
                    }
        
                    // Close the statement because we are done with it
                    statement.close();
                } catch (SQLException e) {
                    // If there is an error, lets just pring the error
                    System.err.println(e.getMessage());
                } finally {
                    // Safety code to cleanup
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        // connection close failed.
                        System.err.println(e.getMessage());
                    }
                }
                return result;
            }

    public ArrayList<fiveTotalData> page5Totals(String sort, String order, String gender, String ageFrom, String ageTo, String search, String showing,
            String minIncome, String maxIncome, String minRent, String maxRent, String minMortgage, String maxMortgage,
            String minAge, String maxAge) {
        
                ArrayList<fiveTotalData> result = new ArrayList<fiveTotalData>();

                // Setup the variable for the JDBC connection
                Connection connection = null;
        
                try {
                    // Connect to JDBC data base
                    connection = DriverManager.getConnection(DATABASE);
        
                    // Prepare a new SQL Query & Set a timeout
                    Statement statement = connection.createStatement();
                    statement.setQueryTimeout(30);
        
                    // The Query
                    String query = "";

                    query += " SELECT lga_name, round(cast(total AS float(7,2)) / cast(population AS float(7,2)), 4)*100 AS ratio, total, population, age, mortgage, rent, income";
                    query += " FROM ";
                    query += " (SELECT l.lga_code, lga_name, state, age_bracket, sum(count) AS 'total', median_age as 'age', median_mortgage_repay_monthly as 'mortgage', median_rent_weekly as 'rent', median_household_weekly_income as 'income' ";
                    query += " FROM lga l JOIN datum d ";
                    query += " ON l.lga_code = d.lga_code";
                    query += " WHERE d.year = 2018 AND condition = 'homeless' AND d.count > 0";
                    query += " AND age_bracket BETWEEN " + ageFrom + " AND " + ageTo;
                    if(gender.equals("all")){}else{ query += " AND gender = '" + gender + "'";}
                    query += " GROUP BY l.lga_name";
                    query += " ) hd";
                    query += " JOIN";
                    query += " pop_stats p";
                    query += " ON hd.lga_code = p.lga_code";
                    query += " WHERE lga_name LIKE '%" + search + "%'";
                    query += " AND p.year = 2018";
                    query += " AND age BETWEEN "+ minAge + " AND " + maxAge;
                    query += " AND mortgage BETWEEN "+ minMortgage + " AND " + maxMortgage;
                    query += " AND rent BETWEEN "+ minRent + " AND " + maxRent;
                    query += " AND income BETWEEN "+ minIncome + " AND " + maxIncome;
                    
                    if(sort.equals("alphabetical")){
                        query += " ORDER BY lga_name " + order;
                    }
                    else{
                        query += " ORDER BY " + sort + " " + order;
                    }  
                    
                    if(showing.equals("top10")){
                        query += " LIMIT 10";
                    }

        
                    ResultSet results = statement.executeQuery(query);
        
                    while (results.next()) {
        
                        String name = results.getString("lga_name");
                        float ratio = results.getFloat("ratio");
                        int total = results.getInt("total");
                        int population = results.getInt("population");
                        int age = results.getInt("age");
                        int mortgage = results.getInt("mortgage");
                        int rent = results.getInt("rent");
                        int income = results.getInt("income");

                        result.add(new fiveTotalData(name, ratio, total, population, age, mortgage, rent, income));
                    }
        
                    // Close the statement because we are done with it
                    statement.close();
                } catch (SQLException e) {
                    // If there is an error, lets just pring the error
                    System.err.println(e.getMessage());
                } finally {
                    // Safety code to cleanup
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        // connection close failed.
                        System.err.println(e.getMessage());
                    }
                }
                return result;
    }
}
