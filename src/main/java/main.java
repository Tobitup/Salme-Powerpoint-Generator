import java.io.IOException;
import java.sql.SQLException;

public class main {
    public String verse1;
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        //gui run = new gui();
        //run.initializeGUI();
        SQLiteTest db = new SQLiteTest();
        db.displayUsers();
        db.addUser(11, "john", "dick");
        //database db = new database();
        //db.initializeDatabase();
        powerpoint slide1 = new powerpoint();
        slide1.generateSlide(400);
    }
}