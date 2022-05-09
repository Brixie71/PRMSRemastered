package PRMSClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection connectDB() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/prms", "root", "");

            return conn;

        } catch (SQLException ex) {

            System.out.println(" Console Warning : The system was unable to connect to the database!");
            return null;
        }
    }
}
