import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class psalm {

    public static String downloadPsalms(int psalm, int chosenCase) throws IOException {
        Document doc = Jsoup.connect("https://www.dendanskesalmebogonline.dk/salme/" + psalm).get();
        Element verse1 = doc.select("div.salme-vers-tekst").first();
        Elements authorElements = doc.select("div.salme-forfatter");
        Element songTitle = doc.select("div.salme-navn").first();
        Element authorElement = authorElements.get(1);
        String verse1Text = verse1.wholeText();
        String title = songTitle.wholeText();
        String author = authorElement.wholeText();
        String info;
        switch (chosenCase) {
            case 0:
                info = (title + author + verse1Text);
                break;
            case 1:
                info = (title);
                break;
            case 2:
                info = (author);
                break;
            default:
                info = (verse1Text);
                break;
        }
        return info;
    }
}
