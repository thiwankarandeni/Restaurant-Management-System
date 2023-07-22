import java.sql.Connection;
import java.sql.DriverManager;

//This class is for creating a connection with database

public class DbCon {
    static Connection con;
    static String url = "jdbc:mysql://localhost/restaurant_database";
    static String uname = "root";
    static String pass = "";


    public static Connection getConnection() throws Exception{
        if(con == null){
            con = DriverManager.getConnection(url,uname, pass);
        }
        return con;
    }

}