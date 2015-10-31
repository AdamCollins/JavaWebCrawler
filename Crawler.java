package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Crawler {
    static URL url;
    static BufferedReader in;
    Crawler(String site) throws Exception
    {

       this.url =  new URL("https://www.reddit.com/");
    }

    public static void findAnchors() throws Exception {
        in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        String address = "";

        while ((inputLine = in.readLine()) != null) {
            for (int i = 0; i < inputLine.length() - 13; i++) {
                if ("<a href=\"http".equals(inputLine.substring(i, i + 13))) {
                    address = inputLine.substring(i + 9);
                    address = address.substring(0, address.indexOf("\""));
                    System.out.println(address);
                } else if ("<A HREF=\"http".equals(inputLine.substring(i, i + 13))) {
                    address = inputLine.substring(i + 9);
                    address = address.substring(0, address.indexOf("\""));
                    System.out.println(address);
                }
            }
        }
        in.close();
    }

    public static void findSourceCode() throws Exception {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }

    }
}
