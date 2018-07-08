package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.SubredditLinks;

import java.util.List;

public class SubredditLinksDAOImpl implements SubredditLinksDAO {

    @Override
    public SubredditLinks createSubredditModel(String subreddit, List<String> subredditLinks) {
       SubredditLinks subredditLinksDTO = new SubredditLinks();
       subredditLinksDTO.setSubreddit(subreddit);
       subredditLinksDTO.setLinks(subredditLinks);

       return subredditLinksDTO;
    }
}
