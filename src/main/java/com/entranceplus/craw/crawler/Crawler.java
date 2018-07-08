package com.entranceplus.craw.crawler;

import com.entranceplus.craw.dto.SubredditLinks;
import com.entranceplus.craw.dto.SubredditMetadata;

/**
 *Crawler interface which contains methods for parsing of a
 * website...As of now it supports reddit
 */

public interface Crawler {
    /**
     * Get the top links from a subreddit
     * @param subreddit - The subreddit of the form Ex. soccer
     * @return SubredditLinks
     * invoke getSubreddit() to get subreddit and getLinks() to get list
     * links
     */
    public SubredditLinks getLinksFromReddit(String subreddit);
    public String getContent(String url);
    public String getHTML(String url);

    /**
     * Get the subreddits with corresponding followers and subreddit
     * @return SubredditMetadata - Invoke getKey() to retrieve the key
     * and getMetadata() to get List of Subreddit.
     */
    public SubredditMetadata getSubreddits();
    public String parseJSON(String json, String keyword);
}
