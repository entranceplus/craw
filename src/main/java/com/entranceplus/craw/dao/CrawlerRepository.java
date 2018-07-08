package com.entranceplus.craw.dao;

public class CrawlerRepository {

    public CustomResponseDAOImpl getCustomResponseDAO() {
        return new CustomResponseDAOImpl();
    }

    public SubredditMetadataDAOimpl getSubredditMetadataDAOimpl() {
        return new SubredditMetadataDAOimpl();
    }

    public SubredditLinksDAOImpl getSubredditLinksDAO() {
        return new SubredditLinksDAOImpl();
    }

}
