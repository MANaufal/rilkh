/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Atha
 */
public class Main {
    
    private static Scanner s = new Scanner(System.in);
    private static UserController uc = new UserController();
    
    public static void main(String[] args) throws SQLException{
        int pilihan = 0;
        int inputId;
        String inputPassword;
        String inputUsername;
        
        do{
            System.out.println("1. tambah User");
            System.out.println("2. Lihat User");
            System.out.println("3. Delete User");
            System.out.println("4. Login");
            System.out.println("5. keluar");
            System.out.print("\nMasukkan pilihan: ");
            pilihan = s.nextInt();
            
            switch(pilihan){
                case 1: 
                    tambahUser();
                    break;
                case 2:
                    uc.userShow();
                    break;
                case 3:
                    System.out.print("Masukkan ID user yang ingin dihapus: ");
                    inputId = s.nextInt();
                    uc.userDelete(inputId);
                    break;
                case 4:
                    System.out.println("Login");
                    inputUsername = s.next();
                    inputPassword = s.next();
                    uc.login(inputUsername, inputPassword);
                    break;
            }
        } while (pilihan != 5);
    }
    
    public static void tambahUser() throws SQLException{
        System.out.println("Masukkan username: ");
        String username = s.next();
        System.out.println("Masukkan email: ");
        String email = s.next();
        System.out.println("Masukkan password: ");
        String password = s.next();
        
        uc.userAdd(new User(username, password, email));
    }
}
