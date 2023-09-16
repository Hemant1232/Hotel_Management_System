package Hotel_Management;
import java.sql.*;
public class Conn {

    Connection c;
    Statement s;

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:mysql:///Hotel", "root", "Hemant@123");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new Conn();
    }
}


