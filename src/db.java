
import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.*;
   
public class db {  
  
    public static void createNewDatabase() {
        String dir = System.getProperty("user.dir");
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            System.out.println(e);
        }
        String url = "jdbc:sqlite:"+dir+"players.db";
   
        try {  
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
                DatabaseMetaData meta = conn.getMetaData();
                Statement stmt  = conn.createStatement();
                String sql = "CREATE TABLE leaderboard (id INTEGER, player_name TEXT, player_status TEXT, PRIMARY KEY(id AUTOINCREMENT) );";
                stmt.executeUpdate(sql);
            }  
   
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }

}  
