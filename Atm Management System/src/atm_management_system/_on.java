package atm_management_system;
import java.sql.*;
public class Con{

   public Connection conn;
   public Statement s;

    public Con(){
        try{
                                         //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

                                        //step2 create  the connection object
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");

                                        //step3 create the statement object
            s=conn.createStatement();

                                       //step4 execute query
            System.out.println("database connected");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}




































