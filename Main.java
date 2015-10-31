package com.company;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Main
{

    static ArrayList<Crawler> crawlers;
    public static int x;
    public static void main(String[] args) throws Exception
    {
        crawlers = new ArrayList<Crawler>();
        createCrawler("https://reddit.com/");

        for (int i = 0; i < crawlers.size(); i++) {
             Crawler c =  crawlers.get(i);
            c.findAnchors();
            //c.findSourceCode();
        }
    }

    public static void createCrawler(String url) throws Exception {
        crawlers.add(new Crawler(url));
        System.out.println(url);
        if(Math.random()*100>95) System.out.println(crawlers.size());
    }

}