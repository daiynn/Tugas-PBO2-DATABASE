
package com.mycompany.pbo2tgs1;

/**
 *
 * @author wderi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_test_dbc"; // Ganti 'your_database_name' dengan nama database Anda
    private static final String USER = "freedb_Daiyn_"; // Ganti 'your_username' dengan username database Anda
    private static final String PASSWORD = "8$!cNSa8hHBnh*4"; // Ganti 'your_password' dengan password database Anda

    private static Connection connection;

    static {
        try {
            // Memuat driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Membuat koneksi ke database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to establish database connection.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Failed to close database connection.");
                e.printStackTrace();
            }
        }
    }
}