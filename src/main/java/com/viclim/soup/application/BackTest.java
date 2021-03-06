package com.viclim.soup.application;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTest {
    public static void main(String...args) throws IOException {
        // URL Provider with appended Instrument Ticker
        String baseURL = "https://finance.yahoo.com/quote/";
        String historicalEndPoint = "/history?ltr=1";
        String sTicker = "D05.SI";
        StringBuffer sb = new StringBuffer();
        sb.append(baseURL);
        sb.append(sTicker);
        sb.append(historicalEndPoint);

        Document doc = Jsoup.connect(sb.toString().trim()).get();

        // PageObject
        Elements tableHeader = doc.select("table[data-test='historical-prices'] > thead > tr > th");
        Elements tableData = doc.select("table[data-test='historical-prices'] > tbody > tr");
        String selectorDataRow = "table[data-test='historical-prices'] > tbody > tr:nth-child(?row) > td:nth-child(?col)";
        String selectorHeaderRow = "table[data-test='historical-prices'] > thead > tr > th:nth-child(?)";

        JSONObject jsonObjectParent = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        int headerLength = tableHeader.size();
        int dataLength = tableData.size();


        jsonObjectParent.put("TickerName",sTicker);
        for(int j=1; j<dataLength; j++){
            for(int i=1; i<=headerLength; i++){
                String sData = doc.select(selectorDataRow.replace("?row", Integer.toString(j)).replace("?col", Integer.toString(i))).text();
                String sHeader = doc.select(selectorHeaderRow.replace("?", Integer.toString(i))).text();
                jsonObject.put(sHeader, sData);
            }
            jsonArray.put(jsonObject);
        }
        jsonObjectParent.put("History",jsonArray);

        System.out.println(jsonObjectParent.toString(4));

    }
}