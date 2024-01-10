import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mu{
    public static void main(String[] args) {
        // Replace with your database details
        String url = "jdbc:mysql://localhost:3306/db1";
        String username = "root";
        String password = "mahi";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establishing a connection
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            
            // Replace "SELECT * FROM your emp" with your actual SQL query
            resultSet = statement.executeQuery("SELECT * FROM emp");
            
            // Processing the result
            while (resultSet.next()) {
                int id = resultSet.getInt("eno"); // replace "eno" with the name of your column
                String name = resultSet.getString("ename"); // replace "ename" with the name of your column
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        } finally {
            // Close resources in reverse order
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
