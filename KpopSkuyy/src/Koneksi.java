import com.mysql.cj.jdbc.MysqlDataSource;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Atha
 */
public class Koneksi {
    private final MysqlDataSource dataSource = new MysqlDataSource();
    private final String DB_URL = "jdbc:mysql://localhost/testpbo";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "";
        
    public Connection getConnection() throws SQLException{
            dataSource.setUrl(DB_URL);
            dataSource.setUser(DB_USERNAME);
            dataSource.setPassword(DB_PASSWORD);
            Connection conn = dataSource.getConnection();
            
            return conn;
    }
}
