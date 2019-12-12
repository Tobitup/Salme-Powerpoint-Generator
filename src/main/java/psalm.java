import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.sql.SQLException;

public class psalm {

    public static String[] downloadPsalms(int psalm) throws IOException {
        //Establishes connection to website and pulls data into SQLite Database
        Elements authorElements = null;
        Document doc = Jsoup.connect("https://www.dendanskesalmebogonline.dk/salme/" + psalm).get();
        Element verse1 = doc.select("div.salme-vers-tekst").first();
        authorElements = doc.select("div.salme-forfatter");
        Element songTitle = doc.select("div.salme-navn").first();
        Element verseNumber = doc.select("div.salme-vers-nr").last();

        Element authorElement = null;
        String verse1Text = null;
        String title;
        title = songTitle.wholeText();
        String author = null;
        String numberOfVerses = "0";

        //Checks if a verse on the website is not null
        if(verse1 != null) {
            authorElement = authorElements.get(1);
            author = authorElement.text();
            verse1Text = verse1.wholeText();
            System.out.println(verse1Text);
            System.out.println(title);
            verse1Text = cleanText(verse1Text, title);
            System.out.println(verse1Text);
            numberOfVerses = verseNumber.wholeText();
        }

        //Array list for title, author, text stored in verses and number of verses
        String[] info = {"", "", "",""};
                info[0] = title;
                info[1] = author;
                info[2] = verse1Text;
                info[3] = numberOfVerses;
        return info;
    }

    public void psalmToDatabase() throws IOException, SQLException, ClassNotFoundException {
        SQLiteTest db = new SQLiteTest();
        for(int i = 1; i < 791; i++){
            db.addPsalm(i, downloadPsalms(i));
        }
    }

    public static String cleanText(String text, String title){
        String output = "";
        String indexString = title.substring(0,4);
        output = text.substring(text.indexOf(indexString));
        return output;
    }
}