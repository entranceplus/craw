package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.SubredditLinksDTO;

import java.util.List;

public interface SubredditLinksDAO {

    public SubredditLinksDTO createSubredditModel(String subreddit, List<String> subredditLinks);
}
