package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.Subreddit;
import com.entranceplus.craw.dto.SubredditMetadata;

import java.util.List;

public interface SubredditMetadataDAO  {
    public SubredditMetadata setMetadata(String key, List<Subreddit> subredditList);
}
