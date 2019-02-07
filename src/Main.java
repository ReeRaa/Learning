import java.sql.*;

public class Main {
    public static final String DB_NAME="testjava.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:/Users/reelyka.laheb/IdeaProjects/TestDB/" + DB_NAME;
    public static final String TABLE_CONTACTS="contacts" ;
    public static final String COLUMN_NAME="person";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_EMAIL="email";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE if exists "+ TABLE_CONTACTS);
            statement.execute("CREATE TABLE if not exists " + TABLE_CONTACTS+
                    " ("+
                    COLUMN_NAME +" text,"+
                    COLUMN_PHONE + " integer,"+
                    COLUMN_EMAIL +" text"+
                    ")");

           statement.execute("INSERT INTO " +TABLE_CONTACTS+
                    "("+
                    COLUMN_NAME +","+
                    COLUMN_PHONE+","+
                    COLUMN_EMAIL+ ")"+
                    "VALUES ('Tim',123456,'tim@gmia.ee')");
            statement.execute("INSERT INTO " +TABLE_CONTACTS+
                    "("+COLUMN_NAME +","+
                    COLUMN_PHONE+","+
                    COLUMN_EMAIL+")"+
                    "VALUES ('Joe',5676544,'joe@gmia.ee')"
            );
            statement.execute("INSERT INTO " +TABLE_CONTACTS+
                    "("+COLUMN_NAME +","+
                    COLUMN_PHONE+","+
                    COLUMN_EMAIL+")"+
                    "VALUES ('Jane',9999999999,'jane@gmia.ee')"
                                );

            statement.execute("UPDATE " +TABLE_CONTACTS+" SET "+
                    COLUMN_PHONE +" =121212121111 "+
                    " WHERE "+ COLUMN_NAME+"" +
                    " ='Jane'");

            statement.execute("Delete from "+TABLE_CONTACTS+
                    " WHERE "+COLUMN_NAME+" ='Joe'");

            ResultSet results=statement.executeQuery("Select * from "+TABLE_CONTACTS);
            while (results.next()){
                System.out.println(results.getString(COLUMN_NAME)+" "+
                        results.getInt(COLUMN_PHONE)+" "+
                        results.getString(COLUMN_EMAIL));
            }

            //close all connections
            results.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong with DB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement,String name,int phone,String email){

    }
}




