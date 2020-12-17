package com.exemple.app;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author fmatheus
 */
public class App {

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";

    public static void main(String[] args) throws IOException {
        var app = new App();
        app.init();
    }

    private void init() throws IOException {

        Document doc = Jsoup.connect("https://www.google.com/search?q=JHipster").userAgent(USER_AGENT).get();

        System.out.printf("\nWebsite Title: %s\n\n", doc.title());

        Elements elems = doc.getElementsByClass("UDZeY");
        for (Element r : elems) {
            String description = r.select("div > div > div > div > div").text();
            System.out.println(">> " + description);
        }

        System.out.println("\n\n");

        Elements elements = doc.getElementsByClass("g");
        elements = doc.getElementsByClass("rc");
        for (Element result : elements) {
            String title = result.select("div > a > h3 > span").text();
            String subtitle = result.getElementsByClass("IsZvec").text();
            String url = result.getElementsByClass("TbwUpd").text();
            System.out.println("Title: " + title);
            System.out.println("Subtitle: " + subtitle);
            System.out.println("Link: " + url);
            System.out.println("------------------------------------------------------------------");
        }

    }

}
