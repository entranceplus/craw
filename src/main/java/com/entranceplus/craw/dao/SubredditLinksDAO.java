package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.SubredditLinks;

import java.util.List;

public interface SubredditLinksDAO {

    public SubredditLinks createSubredditModel(String subreddit, List<String> subredditLinks);
}
