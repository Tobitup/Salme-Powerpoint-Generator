import javax.swing.*;
import java.io.IOException;

public class main {
    public String verse1;
<<<<<<< Updated upstream

    public static void main(String[] args) throws IOException {
=======
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, NullPointerException {
>>>>>>> Stashed changes
        gui run = new gui();
        run.initializeGUI();
        powerpoint slide1 = new powerpoint();
        slide1.generateSlide(400);
    }
}