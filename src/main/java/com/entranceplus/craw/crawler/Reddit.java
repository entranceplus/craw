package com.entranceplus.craw.crawler;

import com.entranceplus.craw.Constants;
import com.entranceplus.craw.dao.SubredditLinksDAOImpl;
import com.entranceplus.craw.dto.CustomResponseDTO;
import com.entranceplus.craw.dto.SubredditLinksDTO;
import com.entranceplus.craw.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.*;

public class Reddit extends SubredditLinksDAOImpl implements Crawler {
    private HttpClientUtil httpClientUtil;
    private Gson gson;

    public Reddit() {
        gson = new Gson();
        httpClientUtil = new HttpClientUtil();
    }

    @Override
    public SubredditLinksDTO getLinksFromReddit(String subreddit) {
        CustomResponseDTO customResponseDTO;
        SubredditLinksDTO subredditLinksDTO;
        String response;
        subredditLinksDTO = createSubredditModel("",new ArrayList<String>());
        try {
            String url = Constants.REDDIT_ROOT_API+Constants.SUBREDDIT_PREFIX+"/"+subreddit+Constants.JSON_EXT;
            response = httpClientUtil.GET(url);
            String[] urlSplit = url.split("/");
            customResponseDTO = gson.fromJson(response, CustomResponseDTO.class);
            if (customResponseDTO.getSuccess()) {
                subredditLinksDTO = gson.fromJson(this.parseJSON(customResponseDTO.getMessage(), urlSplit[4]),
                                                    SubredditLinksDTO.class);
                return subredditLinksDTO;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return subredditLinksDTO;
    }

    @Override
    public String getSubreddits() {
        CustomResponseDTO customResponseDTO;
        String response;
        try {
            String url = Constants.REDDIT_ROOT_API+Constants.SUBBREDDIT_KEYWORD+Constants.JSON_EXT;
            response = httpClientUtil.GET(url);
            String[] urlSplit = url.split("/");
            customResponseDTO = gson.fromJson(response, CustomResponseDTO.class);
            if (customResponseDTO.getSuccess()) {

                return this.parseJSON(customResponseDTO.getMessage(), urlSplit[3]);

            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return response;
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
            if(!keyword.equals("reddits.json")) {
                Map<String, Object> keywordURLMapping = new HashMap<>();
                keywordURLMapping.put("subreddit", keyword);
                keywordURLMapping.put("links", jsonObject.findValuesAsText("url"));
                return gson.toJson(keywordURLMapping);
            } else {
                Map<String, List<Map<String, String>>> mapKeywordsubredditFollowers = new HashMap<>();
                List<Map<String,String>> subbredditFollList = new ArrayList<>();
                List<String> subreddits = jsonObject.findValuesAsText("url");
                List<String> followers = jsonObject.findValuesAsText("subscribers");
                Iterator<String> subredditIt = subreddits.iterator();
                Iterator<String> followersIt = followers.iterator();
                while(subredditIt.hasNext() && followersIt.hasNext()) {
                    Map<String, String> mapsubredditFollowers = new HashMap<>();
                    mapsubredditFollowers.put("subreddit", (String)subredditIt.next());
                    mapsubredditFollowers.put("followers", (String)followersIt.next());
                    subbredditFollList.add(mapsubredditFollowers);
                }
                mapKeywordsubredditFollowers.put(keyword, subbredditFollList);
                return gson.toJson(mapKeywordsubredditFollowers);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
