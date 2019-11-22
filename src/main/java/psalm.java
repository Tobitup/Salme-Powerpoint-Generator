import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class psalm {

    public static void downloadPsalms(int psalm) throws IOException {
        //for(int i = 1; i < psalms; i++){
            Document doc = Jsoup.connect("https://www.dendanskesalmebogonline.dk/salme/" + psalm).get();
            Element verse1 = doc.select("div.salme-vers-tekst").first();
            System.out.println(verse1);
            System.out.println("fuck");
        //}
    }
}
