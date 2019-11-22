import org.apache.poi.xslf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class powerpoint {
    public XMLSlideShow ppt2 = new XMLSlideShow();
    XSLFSlideMaster defaultMaster = ppt2.getSlideMasters().get(0);
    XSLFSlideLayout layout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);

    int uhh;
    powerpoint(int nice){
        uhh = nice;
        System.out.println("nice");
    }

    public void generateSlide() throws IOException {
XSLFSlide Slide1 = ppt2.createSlide(layout);
        //XSLFTextShape titleShape = Slide1.getPlaceholder(1);
        //XSLFTextShape contentShape = Slide1.getPlaceholder(1);
        FileOutputStream out = new FileOutputStream("powerpoint.pptx");
        ppt2.write(out);
        out.close();
        System.out.println("closed");
    }
}
