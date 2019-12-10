import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
    public String verse1;
    public static void main(String[] args) throws IOException {
        //gui run = new gui();
        //run.initializeGUI();
        database db = new database();
        db.initializeDatabase();
        powerpoint slide1 = new powerpoint();
        slide1.generateSlide(400);
    }
}