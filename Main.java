package com.company;
import java.net.*;
import java.io.*;
public class Main {
    static URL startSite;
    static BufferedReader in;

    public static void main(String[] args) throws Exception {
        Crawler c = new Crawler("https://www.reddit.com/");
        //findSourceCode();
        c.findAnchors();
    }




}