package com.ep.LinkExtractor.ExtractionInterface;

import java.util.ArrayList;

public interface LinkFunc {
    public String getLinksFromReddit(String keyword);
    public String getContent(String url);
    public String getHTML(String url);
    public ArrayList<String> getSubreddits(String url);
    public String parse(String json, String keyword);
}
