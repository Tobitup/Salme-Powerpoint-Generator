import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class main {
    private static int psalmToDownload = 250;
    public String verse1;
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, NullPointerException {
        gui run = new gui();
        run.initializeGUI();
        psalm p = new psalm();
    }
}