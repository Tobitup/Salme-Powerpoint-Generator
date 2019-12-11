import java.io.IOException;
import java.sql.SQLException;

public class main {
    private static int psalmToDownload = 250;
    public String verse1;
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        //gui run = new gui();
        //run.initializeGUI();
        //SQLiteTest db = new SQLiteTest();
        //db.addPsalm(psalmToDownload, p.downloadPsalms(psalmToDownload, "title"), p.downloadPsalms(psalmToDownload, "author"), p.downloadPsalms(psalmToDownload, "verse1"));
        //psalm p = new psalm();
        //p.psalmToDatabase();
        powerpoint slide1 = new powerpoint();
        slide1.generateSlide(543);
    }
}