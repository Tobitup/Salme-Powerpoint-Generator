import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;

public class psalm {

    public static String[] downloadPsalms(int psalm) throws IOException {
        Elements authorElements = null;
        Document doc = Jsoup.connect("https://www.dendanskesalmebogonline.dk/salme/" + psalm).get();
        Element verse1 = doc.select("div.salme-vers-tekst").first();
        authorElements = doc.select("div.salme-forfatter");
        Element songTitle = doc.select("div.salme-navn").first();
        Element authorElement = null;
        String verse1Text = null;
        String title = songTitle.wholeText();
        String author = null;
        if(verse1 != null) {
            authorElement = authorElements.get(1);
            author = authorElement.wholeText();
        }

            if(verse1 != null) {
               verse1Text = verse1.wholeText();
        }
        String[] info = {"", "", ""};
                info[0] = title;
                info[1] = author;
                info[2] = verse1Text;
        return info;
    }
    public void psalmToDatabase() throws IOException, SQLException, ClassNotFoundException {
        SQLiteTest db = new SQLiteTest();
        for(int i = 1; i < 50 /*791*/; i++){
            db.addPsalm(i, downloadPsalms(i));
        }
    }
}
