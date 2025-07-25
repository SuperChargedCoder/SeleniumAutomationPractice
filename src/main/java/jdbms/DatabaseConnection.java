package jdbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    // Database credentials
    static String dbUrl = "jdbc:mysql://localhost:3306/trip"; // jdbc:mysql://host:port/database
    static String username = "root";
    static String password = ""; //Enter valid password

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load MySQL JDBC driver (optional for JDBC 4.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Database connected successfully!");

            // Create a statement
            Statement stmt = connection.createStatement();

            // Example query
            String query = "SELECT * FROM trip.travelers"; //SELECT * FROM trip.travelers where name = 'Shubham'
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            while (rs.next()) {
                System.out.println("Traveler Name: " + rs.getString("Name"));
                System.out.println("Availability: " + rs.getString("Availability"));
            }

            // Close the result set and statement
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Database connection closed.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

