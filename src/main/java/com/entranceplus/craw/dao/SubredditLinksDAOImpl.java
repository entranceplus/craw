package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.SubredditLinksDTO;

import java.util.List;

public class SubredditLinksDAOImpl implements SubredditLinksDAO {

    @Override
    public SubredditLinksDTO createSubredditModel(String subreddit, List<String> subredditLinks) {
       SubredditLinksDTO subredditLinksDTO = new SubredditLinksDTO();
       subredditLinksDTO.setSubreddit(subreddit);
       subredditLinksDTO.setLinks(subredditLinks);

       return subredditLinksDTO;
    }
}
