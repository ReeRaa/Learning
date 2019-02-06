import java.sql.*;
import java.util.Random;

public class FillInDB {
    static String name;
    static int fortuneNumber;
    Random rand = new Random();
    static int counter=0;

    String nameArray[] = {"Mia", "Tjorven", "Bob", "Lisa"};


    public int getFortuneNumber() {
        fortuneNumber = rand.nextInt(3) + 1;
        return fortuneNumber;
    }

    public void setName(int fortuneNumber) {
        this.name = nameArray[fortuneNumber];
    }

    public String getName() {
        return name;
    }

    public static void main(String args[]) {
        for (int d = 1; d < 5; d++) {
            try {
                FillInDB db = new FillInDB();
                fortuneNumber = db.getFortuneNumber();

                db.setName(fortuneNumber);
                name = db.getName();
                int id = 1;

                String url = "jdbc:sqlite:/Users/reelyka.laheb/IdeaProjects/TestDB/fortunes.db";
                String uname = "reelyka";
                String pass = "password";
                Connection conn = (Connection) DriverManager.getConnection(url, uname, pass);
                Statement stm = conn.createStatement();
                conn.setAutoCommit(true);
                Statement statement = conn.createStatement();

                //find max index value
                DatabaseMetaData dbmd=conn.getMetaData();
                ResultSet tables=dbmd.getTables(null,null,"fortunes",null);
                if (tables.next()) {
                    ResultSet rst = statement.executeQuery(" select max(id) from fortunes ;");
                    counter = rst.getInt(1) + 1;
                }
                        else{
                        counter = 1;
                    }

                    //other
                statement.execute("CREATE TABLE if not exists fortunes (id integer,person text,fortune integer)");
                stm.executeUpdate("insert into fortunes (id,person,fortune) values('" + counter + "','" + name + "','" + fortuneNumber + "') ");
                statement.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("DB is fup " + e);
            }


        }
    }
}