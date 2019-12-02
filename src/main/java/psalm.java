import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class psalm {

    public static String downloadPsalms(int psalm, String chosenCase) throws IOException {
        Document doc = Jsoup.connect("https://www.dendanskesalmebogonline.dk/salme/" + psalm).get();
        Element verse1 = doc.select("div.salme-vers-tekst").first();
        Elements authorElements = doc.select("div.salme-forfatter");
        Element songTitle = doc.select("div.salme-navn").first();
        Element authorElement = authorElements.get(1);
        String verse1Text = verse1.wholeText();
        String title = songTitle.wholeText();
        String author = authorElement.wholeText();
        String info = null;
        switch (chosenCase) {
            case "everything":
                info = (title + author + verse1Text);
                break;
            case "title":
                info = (title);
                break;
            case "author":
                info = (author);
                break;
            case "verse1":
                info = (verse1Text);
                break;
            default:
                break;
        }
        return info;
    }
}
