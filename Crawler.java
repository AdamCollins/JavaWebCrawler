package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import static com.company.Main.createCrawler;

public class Crawler
{
    private static URL url;
    private static BufferedReader in;
    static ArrayList<String> anchorsFound;
    Crawler(String site) throws Exception
    {
        this.url = new URL(site);
        anchorsFound = new ArrayList<String>();
    }

    public static void findAnchors() throws Exception
    {
        in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        String address = "";

        while ((inputLine = in.readLine()) != null)
        {
            for (int i = 0; i < inputLine.length() - 13; i++)
            {
                if ("<a href=\"http".equals(inputLine.substring(i, i + 13)))
                {
                    address = inputLine.substring(i + 9);
                    address = address.substring(0, address.indexOf("\""));
                    System.out.println(address);
                    anchorsFound.add(address);
                }
                else
                if ("<A HREF=\"http".equals(inputLine.substring(i, i + 13)))
                {
                    address = inputLine.substring(i + 9);
                    address = address.substring(0, address.indexOf("\""));
                    System.out.println(address);
                    anchorsFound.add(address);
                }
            }
        }
        in.close();
        //printAnchorsFound();
        crawlAnchorsFound();
    }

    private static void crawlAnchorsFound() throws Exception {
        for(int i = 0; i<anchorsFound.size(); i++)
        {
            createCrawler(anchorsFound.get(i));
        }
        anchorsFound = new ArrayList<String>();
    }

    private static void printAnchorsFound()
    {
        for(int i = 0; i<anchorsFound.size(); i++)
        {
            String anchor = anchorsFound.get(i);
            System.out.println(anchor);
        }
    }

    public static void findSourceCode() throws Exception
    {
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {
            System.out.println(inputLine);
        }

    }
}
