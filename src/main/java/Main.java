import Controller.Controller;
import Model.IntegralInfo;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import java.util.List;

/**
 *
 * @author SantiagoAvila
 */
public class Main {
  
  /**
     * Main method, where the endpoints are defined
     * 
     * @param args
     */
  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/simpsonIntegralXValue", (req, res) -> {
        
        final String FILE_NAME = "dataset.txt";
        List<IntegralInfo> data;
        Controller controller = new Controller();
        data = controller.loadClassInfo(FILE_NAME);
        String dataString = "<p><br><table border=\"1\">";
        dataString += "<tr align=\"center\"><td><b>p</b></td><td><b>dof</b></td><td><b>Expected X<br>Value</b></td><td><b>Actual X<br>Value</b></td></tr>";
        for(IntegralInfo integralCase : data) {
            integralCase = controller.findXValue(integralCase);
            dataString += String.format("<tr><td>%f</td><td>%f</td><td>%f</td><td>%f</td></tr>", integralCase.getExpectedResult(), integralCase.getDegreesOfFreedom(), integralCase.getExpectedUpperLimit(), integralCase.getIntegralUpperLimit());
        }
        
        dataString += "</table><br>";
        return dataString;        
    });

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  }

}
