import java.sql.*;

public class database {

    public void initializeDatabase() {
        Connection con = null;
        int nice = 0;
        try{
            String host= "jdbc:mysql://localhost:3306/psalmdatabase";
            String uName = "root";
            String uPass = "xxxx";
            con = DriverManager. getConnection(host, uName, uPass);
Statement myStmt = con.createStatement();
String sql  = "Select * from Psalm";
            ResultSet rs = myStmt.executeQuery(sql);
            while(rs.next()){
                nice = rs.getInt("year");
            }
            System.out.println(nice);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void executeUpdateStatement(Connection con) {
        try(Statement stmt = con.createStatement();) {
            String SQL = "INSERT INTO TestTable (Col2, Col3) VALUES ('a', 10)";
            int count = stmt.executeUpdate(SQL);
            System.out.println("ROWS AFFECTED: " + count);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}