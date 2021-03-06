package com.viclim.soup.application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SoupBrewApplication {
    public static void main(String...args) throws IOException {
        Document doc = Jsoup.connect("https://finviz.com/").get();
        String title = doc.title();
        System.out.println(title);

        Elements newsHeadlines = doc.select("a.nn-tab-link");
        newsHeadlines.forEach(newsHeadline->{
            System.out.println("Headline : " + newsHeadline.text());
        });

    }
}


/**
 * Steps to take
 * [1] What stocks are you looking into ?
 * [2] How many Shares
 * [3] At what price ?
 * [4] Choose which market to get the share ?
 * [5] What type of order ?
 * [6] Buy / Sell ?
 */

/**
 * Services
 * [1] StockScreener
 * [2] MyBucketShare
 *      --> Store the mapping of shares picked by StockScreener
 *      --> Map\\<Ticker,StockObj\\>
 * [3] PriceChartAnalysis
 *      --> Will tell the system when to enter trade order
 * [4] TradeOrder (Interface)
 *      --> TradeOrder.givenFund(100,IGCurr.SGD,AAPL);
 *          --> tradeOrderObj;
 *      --> TradeOrder.executeOrder(IGOrder.BUY); // Can also be IGOrder.SELL
 *      --> TradeOrder.setTakeProfit();// Default is 10%
 */