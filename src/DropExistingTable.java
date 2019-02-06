import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropExistingTable {
    public static void main(String[] args){
        try {
            Connection conn= DriverManager.getConnection("jdbc:sqlite:/Users/reelyka.laheb/IdeaProjects/TestDB/fortunes.db");
            Statement stmn=conn.createStatement();
            stmn.executeUpdate("drop table fortunes;");

        }catch (SQLException e){System.out.println("DB fup "+ e.getMessage());
        }
    }
}
