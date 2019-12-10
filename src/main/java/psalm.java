import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;

public class psalm {

    public static String[] downloadPsalms(int psalm) throws IOException {
        Document doc = Jsoup.connect("https://www.dendanskesalmebogonline.dk/salme/" + psalm).get();
        Element verse1 = doc.select("div.salme-vers-tekst").first();
        Elements authorElements = doc.select("div.salme-forfatter");
        Element songTitle = doc.select("div.salme-navn").first();
        Element authorElement = null;
        try {
            authorElement = authorElements.get(1);
        } catch (Exception e) {
            System.out.println("fucked at" + psalm);
        }
        String verse1Text = verse1.wholeText();
        String title = songTitle.wholeText();
        String author = null;
        if(authorElement != null) {
            author = authorElement.wholeText();
        }
        String[] info = {"", "", ""};
                info[0] = title;
                info[1] = author;
                info[2] = verse1Text;
        return info;
    }
    public void psalmToDatabase() throws IOException, SQLException, ClassNotFoundException {
        SQLiteTest db = new SQLiteTest();
        for(int i = 1; i < 10 /*791*/; i++){
            db.addPsalm(i, downloadPsalms(i));
        }
    }
}
