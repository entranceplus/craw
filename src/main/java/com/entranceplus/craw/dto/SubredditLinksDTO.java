package com.entranceplus.craw.dto;

import java.util.List;

public class SubredditLinksDTO {
    private String subreddit;
    private List<String> links;

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}
