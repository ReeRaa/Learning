import java.sql.*;

public class RetrieveTheLastRow {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/reelyka.laheb/IdeaProjects/TestDB/fortunes.db");
            Statement stmn=conn.createStatement();
            ResultSet rs= stmn.executeQuery("select max(id) from fortunes;");

            int m=rs.getInt(1);
            System.out.println(m);

        } catch (SQLException e) {
            System.out.println("DB fup: " + e);
        }

    }
}