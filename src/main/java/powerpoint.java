import org.apache.poi.xslf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class powerpoint {
    public XMLSlideShow ppt2 = new XMLSlideShow();
    XSLFSlideMaster slideMaster = ppt2.getSlideMasters().get(0);
    private XSLFSlideLayout bodyLayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);

    powerpoint() {
    }

    public void generateSlide(int song) throws IOException {
        XMLSlideShow templateShow = new XMLSlideShow(
                new FileInputStream("template.pptx"));
        List<XSLFSlide> Slides = templateShow.getSlides();
        XSLFSlide Slide1 = ppt2.createSlide((XSLFSlideLayout) bodyLayout.importContent(Slides.get(0)));
        XSLFTextShape body = Slide1.getPlaceholder(0);
        //body.setText(psalm.downloadPsalms(song));
        body.clearText();
        XSLFTextParagraph paragraph = body.addNewTextParagraph();
        XSLFTextRun run = paragraph.addNewTextRun();
        run.setText(psalm.downloadPsalms(song));
        run.setFontSize((double) 30);
        FileOutputStream out = new FileOutputStream("powerpoint.pptx");
        ppt2.write(out);
        out.close();
        System.out.println("closed");
    }
}
