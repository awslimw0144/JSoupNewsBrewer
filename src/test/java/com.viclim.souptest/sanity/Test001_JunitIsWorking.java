package com.viclim.souptest.sanity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Basic Sanity Test")
public class Test001_JunitIsWorking {
    @Test
    @DisplayName("Test 001 - Junit Is Working")
    public void test001(){
        assertEquals(0,0);
    }

    @Test
    @DisplayName("Test 002 - JSoup Title Is Working")
    public void test002(){
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        assertEquals("First parse",doc.title());
    }

    @Test
    @DisplayName("Test 003 - JSoup Body Is Working")
    public void test003(){
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p><p>Parsing again</p></body></html>";
        Document doc = Jsoup.parseBodyFragment(html);
        assertEquals("Parsed HTML into a doc.",doc.select("p").get(0).text());
        assertEquals("Parsing again",doc.select("p").get(1).text());
    }

    @Test
    @DisplayName("Test 004 - Jsoup pulling title from FINVIZ")
    public void test004() throws IOException{
        Document doc = Jsoup.connect("https://finviz.com/").get();
        String title = doc.title();
        assertEquals("FINVIZ.com - Stock Screener", title);
    }

}

