import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class psalm {

    public static String downloadPsalms(int psalm) throws IOException {
        Document doc = Jsoup.connect("https://www.dendanskesalmebogonline.dk/salme/" + psalm).get();
        Element verse1 = doc.select("div.salme-vers-tekst").first();
        Elements authorElements = doc.select("div.salme-forfatter");
        Element authorElement = authorElements.get(1);
        String verse1Text = verse1.wholeText();
        String author = authorElement.wholeText();
        String info = (author + verse1Text);
        return info;
    }
}
