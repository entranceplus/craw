package com.entranceplus.craw.ExtractionInterface;

import java.util.ArrayList;

public interface LinkFunc {
    public String getLinksFromReddit(String subreddit);
    public String getContent(String url);
    public String getHTML(String url);
    public String getSubreddits();
    public String parseJSON(String json, String keyword);
}
