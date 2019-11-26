
import java.io.IOException;
import org.apache.poi.ooxml.*;
import org.apache.poi.*;

public class main {
    public String verse1;
    public static void main(String[] args) throws IOException {
        powerpoint slide1 = new powerpoint();
        slide1.generateSlide(400);
    }
}
