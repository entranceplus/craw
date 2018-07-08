package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.Subreddit;
import com.entranceplus.craw.dto.SubredditLinks;
import com.entranceplus.craw.dto.SubredditMetadata;

import java.util.List;

public class SubredditMetadataDAOimpl implements SubredditMetadataDAO {
    @Override
    public SubredditMetadata setMetadata(String key, List<Subreddit> subredditMetadataList) {
        SubredditMetadata subredditMetadata = new SubredditMetadata();
        subredditMetadata.setKey(key);
        subredditMetadata.setMetadata(subredditMetadataList);
        return subredditMetadata;
    }
}
