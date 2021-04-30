import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prova {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/compito","root","");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Docenti");
            // System.out.println("ID\tNome\t\tData Di Nascita");
            while(rs.next()) {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3));
            }
            con.close();
        }
        catch(Exception e)    {
            System.out.println(e);}
    }
}