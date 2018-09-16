package com.entranceplus.craw.crawler;

import com.entranceplus.craw.Constants;
import com.entranceplus.craw.dao.CrawlerRepository;
import com.entranceplus.craw.dao.SubredditLinksDAOImpl;
import com.entranceplus.craw.dao.SubredditMetadataDAOimpl;
import com.entranceplus.craw.dto.CustomResponse;
import com.entranceplus.craw.dto.SubredditLinks;
import com.entranceplus.craw.dto.SubredditMetadata;
import com.entranceplus.craw.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.*;

public class Reddit extends CrawlerRepository implements Crawler {
    private HttpClientUtil httpClientUtil;
    private Gson gson;

    public Reddit() {
        gson = new Gson();
        httpClientUtil = new HttpClientUtil();
    }

    @Override
    public SubredditLinks getLinksFromReddit(String subreddit) {
        CustomResponse customResponse;
        SubredditLinks subredditLinks;
        String response;
        subredditLinks = getSubredditLinksDAO().createSubredditModel("",new ArrayList<String>());
        try {
            String url = Constants.REDDIT_ROOT_API+Constants.SUBREDDIT_PREFIX+"/"+subreddit+Constants.JSON_EXT;
            response = httpClientUtil.GET(url);
            String[] urlSplit = url.split("/");
            customResponse = gson.fromJson(response, CustomResponse.class);
            if (customResponse.getSuccess()) {
                subredditLinks =
                        gson.fromJson(this.parseJSON(customResponse.getMessage(), urlSplit[4].split("\\.")[0]),
                                                    SubredditLinks.class);
                return subredditLinks;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return subredditLinks;
    }

    @Override
    public SubredditMetadata getSubreddits() {
        CustomResponse customResponse;
        SubredditMetadata subredditMetadata;
        String response;
        subredditMetadata = getSubredditMetadataDAOimpl().setMetadata("",new ArrayList<>());
        try {
            String url = Constants.REDDIT_ROOT_API+Constants.SUBBREDDIT_KEYWORD+Constants.JSON_EXT;
            response = httpClientUtil.GET(url);
            String[] urlSplit = url.split("/");
            customResponse = gson.fromJson(response, CustomResponse.class);
            if (customResponse.getSuccess()) {

                subredditMetadata = gson.fromJson(this.parseJSON(customResponse.getMessage(),
                        (urlSplit[3]).split("\\.")[0]), SubredditMetadata.class);

                return subredditMetadata;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return subredditMetadata;
    }

    @Override
    public String getContent(String url) {
        return null;
    }

    @Override
    public String getHTML(String url) {
        return null;
    }

    @Override
    public String parseJSON(String json, String keyword) {
        ObjectMapper mapper = new ObjectMapper();
        Gson gson = new GsonBuilder().create();
        try {
            JsonNode jsonObject = mapper.readValue(json, JsonNode.class);
            if(!keyword.equals(Constants.SUBBREDDIT_KEYWORD)) {
                Map<String, Object> keywordURLMapping = new HashMap<>();
                keywordURLMapping.put("subreddit", keyword);
                keywordURLMapping.put("links", this.extractSubredditName(jsonObject.findValuesAsText("url")));
                return gson.toJson(keywordURLMapping);
            } else {
                Map<String, Object> mapKeywordsubredditFollowers = new HashMap<>();
                List<Map<String,String>> subbredditFollList = new ArrayList<>();
                List<String> subreddits = this.extractSubredditName(jsonObject.findValuesAsText("url"));
                List<String> followers = jsonObject.findValuesAsText("subscribers");
                List<String> title = jsonObject.findValuesAsText("title");
                List<String> thumbnails = jsonObject.findValuesAsText("icon_img");
                Iterator<String> titleIt = title.iterator();
                Iterator<String> thumbnailsIt = thumbnails.iterator();
                Iterator<String> subredditIt = subreddits.iterator();
                Iterator<String> followersIt = followers.iterator();
                while(subredditIt.hasNext() && followersIt.hasNext() &&
                      titleIt.hasNext() && thumbnailsIt.hasNext()) {
                    Map<String, String> mapsubredditFollowers = new HashMap<>();
                    mapsubredditFollowers.put("subreddit", (String)subredditIt.next());
                    mapsubredditFollowers.put("followers", (String)followersIt.next());
                    mapsubredditFollowers.put("title", (String)titleIt.next());
                    mapsubredditFollowers.put("thumbnail", (String)thumbnailsIt.next());
                    subbredditFollList.add(mapsubredditFollowers);
                }
                mapKeywordsubredditFollowers.put("key", keyword);
                mapKeywordsubredditFollowers.put("metadata", subbredditFollList);
                return gson.toJson(mapKeywordsubredditFollowers);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> extractSubredditName(List<String> subreddits) {
        List<String> strippedPrefixList = new ArrayList<>();
        for (String subreddit: subreddits) {
            strippedPrefixList.add(subreddit.split("/")[2]);
        }
        return strippedPrefixList;
    }
}
