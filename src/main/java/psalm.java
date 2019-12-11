import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.sql.SQLException;

public class psalm {

    public static String[] downloadPsalms(int psalm) throws IOException {
        Elements authorElements = null;
        Document doc = Jsoup.connect("https://www.dendanskesalmebogonline.dk/salme/" + psalm).get();
        Element verse1 = doc.select("div.salme-vers-tekst").first();
        authorElements = doc.select("div.salme-forfatter");
        Element songTitle = doc.select("div.salme-navn").first();
        Element verseNumber = doc.select("div.salme-vers-nr").last();
        Element authorElement = null;
        String verse1Text = null;
        String title = songTitle.wholeText();
        String author = null;
        String numberOfVerses = null;
        if(verse1 != null) {
            authorElement = authorElements.get(1);
            author = authorElement.text();
            verse1Text = verse1.wholeText();
            System.out.println(verse1Text);
            verse1Text = cleanText(verse1Text, title);
            System.out.println(verse1Text);
            numberOfVerses = verseNumber.wholeText();
        }

        String[] info = {"", "", "",""};
                info[0] = title;
                info[1] = author;
                info[2] = verse1Text;
                info[3] = numberOfVerses;
        return info;
    }
    public void psalmToDatabase() throws IOException, SQLException, ClassNotFoundException {
        SQLiteTest db = new SQLiteTest();
        for(int i = 10; i < 11 /*791*/; i++){
            db.addPsalm(i, downloadPsalms(i));
        }
    }
    public static String cleanText(String text, String title){
        String output = "";
        output = text.substring(text.indexOf(title));
        return output;
    }
}
