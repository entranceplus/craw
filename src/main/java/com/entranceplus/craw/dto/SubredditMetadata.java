package com.entranceplus.craw.dto;

import java.util.List;

public class SubredditMetadata {
    private String key;
    private List<Subreddit> metadata;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Subreddit> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Subreddit> metadata) {
        this.metadata = metadata;
    }
}
