import java.sql.*;

public class SQLiteTest {
    private static Connection con = null;
    private static boolean hasData = false;
    public void addPsalm(int number, String[] info) throws ClassNotFoundException, SQLException {
        if(con == null) {
            getConnection();
        }
        PreparedStatement prep = con.prepareStatement("insert into psalm values(?,?,?,?,?);");
        prep.setInt(1, number);
        prep.setString(2, info[0]);
        prep.setString(3, info[1]);
        prep.setString(4, info[2]);
        prep.setString(5, info[3]);


        prep.execute();

    }
    private void getConnection() throws ClassNotFoundException, SQLException {
        con = DriverManager.getConnection("jdbc:sqlite:PsalmDatabase.sqlite");
    }
}
