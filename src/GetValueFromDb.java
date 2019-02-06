import java.sql.*;
import java.util.Random;

public class GetValueFromDb {
    public static void main(String[] args) {
        try {
            Random ran=new Random();
            int r=ran.nextInt(3)+1;
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/reelyka.laheb/IdeaProjects/TestDB/fortunes.db");
            conn.setAutoCommit(true);
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("select person from fortunes where id="+r+";");
            String name1 = rs.getString(1);
            System.out.println(name1);

            //find max index value
            ResultSet rst= stmn.executeQuery("select max(id) from fortunes;");
            int m=rs.getInt(1);
            System.out.println(m);

        } catch (SQLException e) {
            System.out.println("DB fup " + e.getMessage());

        }
    }
}