import java.io.IOException;

public class main {
    public String verse1;

    public static void main(String[] args) throws IOException {
        gui run = new gui();
        run.initializeGUI();
        powerpoint slide1 = new powerpoint();
        slide1.generateSlide(400);
    }
}