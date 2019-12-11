import org.apache.poi.xslf.usermodel.*;
import java.awt.*;
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
        psalm p = new psalm();
        String[] info = p.downloadPsalms(song);
        XMLSlideShow templateShow = new XMLSlideShow(
                new FileInputStream("template.pptx"));                                               //Henter powerpointfilen "template" som skal bruges.
        List<XSLFSlide> Slides = templateShow.getSlides();
        XSLFSlide templateSlide = Slides.get(0);
        XSLFSlide Slide1 = ppt2.createSlide().importContent(templateSlide);                                //Laver et nyt slide i den nye powerpoint med samme layout som det importerede slide.
        ppt2.setPageSize(templateShow.getPageSize());
        Slide1.getBackground().setFillColor(templateSlide.getBackground().getFillColor());
        XSLFTextShape body = Slide1.getPlaceholder(0);
        XSLFTextShape bodyTemplate = templateSlide.getPlaceholder(0);
        List<XSLFTextParagraph> paragraphTemplates = bodyTemplate.getTextParagraphs();
        XSLFTextParagraph paragraphTemplate = paragraphTemplates.get(0);
        List<XSLFTextRun> runTemplates = paragraphTemplate.getTextRuns();
        System.out.println(body.getTextAutofit());
        body.clearText();
        XSLFTextParagraph paragraph = body.addNewTextParagraph();                                          //Laver et system sådan at når run.setText() bliver kørt så kommer det ind i tekstfeltet
        XSLFTextRun run = paragraph.addNewTextRun();
        run.setText(info[2]);
        run.setFontSize((double) 40);
        run.setFontColor(Color.WHITE);
        run.setFontFamily(runTemplates.get(0).getFontFamily());
        paragraph.setBullet(false);
        XSLFTextShape title = Slide1.getPlaceholder(1);                                                //Laver et textfelt der hedder body ud fra det første element i det importerede slide
        title.clearText();
        XSLFTextParagraph paragraphTitle = title.addNewTextParagraph();                                          //Laver et system sådan at når run.setText() bliver kørt så kommer det ind i tekstfeltet
        XSLFTextRun runTitle = paragraphTitle.addNewTextRun();
        runTitle.setText("1/" + info[3] + "          " + info[1]);
        runTitle.setFontColor(Color.WHITE);
        runTitle.setFontFamily(runTemplates.get(0).getFontFamily());                                           //Bruger samme font som body, skal ændres hvis de skal kunne være forskellige
        paragraphTitle.setBullet(false);
        FileOutputStream out = new FileOutputStream("powerpoint.pptx");                              //Gør sådan at vi kan outputte vores powerpoint til en fil.
        ppt2.write(out);
        out.close();
        System.out.println("closed");
    }
}
