import java.io.IOException;
import java.sql.SQLException;

public class main {
    private static int psalmToDownload = 250;
    public String verse1;
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        gui run = new gui();
        run.initializeGUI();
        psalm p = new psalm();
    }
}