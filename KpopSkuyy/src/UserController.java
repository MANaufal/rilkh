/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Atha
 */
public class UserController {
    Koneksi k = new Koneksi();
    Connection conn = null;
    
    public boolean userAdd(User u) throws SQLException{
        conn = k.getConnection();
        
        String query = "INSERT INTO users(username, password, email) VALUES (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getEmail());
        
        int rowAffected = ps.executeUpdate();
        
        ps.close(); conn.close();
        return rowAffected == 1;
    }
    
    public boolean userDelete(int id) throws SQLException{
        conn = k.getConnection();
        
        String query = "DELETE FROM users WHERE id_user = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        
        int rowAffected = ps.executeUpdate();
        
        if(rowAffected == 1){
            System.out.println("User berhasil dihapus!");
        } else {
            System.out.println("Terjadi kesalahan");
        }
        
        ps.close(); conn.close();
        
        return rowAffected == 1;
    }
    
    public void userShow() throws SQLException{
        conn = k.getConnection();
        
        String query = "SELECT * FROM users";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ResultSet rs = ps.executeQuery();
        
        System.out.println("ID  username    email");
        
        while(rs.next()){
            String id= rs.getString("id_user");
            String username = rs.getString("username");
            String email = rs.getString("email");
            System.out.println(id + "   " + username + "    " + email);
        }
        
        ps.close(); ps.close(); conn.close();
    }
    
    public void login(String username, String password) throws SQLException{
        conn = k.getConnection();
        
        String query = "SELECT * FROM users WHERE username = ? && password = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, username);
        ps.setString(2, password);
        
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            System.out.println("Berhasil login!");
        } else {
            System.out.println("username atau password salah");
        }
        
        ps.close(); ps.close(); conn.close();
    }
}
