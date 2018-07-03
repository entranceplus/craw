package com.ep.LinkExtractor.ExtractionInterface;

import java.util.ArrayList;

public interface LinkFunc {
    public String getLinksFromReddit(String url);
    public String getContent(String url);
    public String getHTML(String url);
    public String getSubreddits(String url);
    public String parseJSON(String json, String keyword);
}
