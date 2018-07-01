package com.ep.LinkExtractor.ExtractionInterface;

import com.ep.LinkExtractor.dao.CustomResponseDAOImpl;
import com.ep.LinkExtractor.dto.CustomResponseDTO;
import com.ep.LinkExtractor.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reddit implements LinkFunc {
    private HttpClientUtil httpClientUtil;
    private CustomResponseDAOImpl customResponseDAOimpl;
    private Gson gson;

    public Reddit() {
        gson = new Gson();
        customResponseDAOimpl = new CustomResponseDAOImpl();
        httpClientUtil = new HttpClientUtil(customResponseDAOimpl);
    }

    @Override
    public String getLinksFromReddit(String url) {
        CustomResponseDTO customResponseDTO;
        String response;
        try {
            response = httpClientUtil.GET(url);
            String[] urlSplit = url.split("/");
            customResponseDTO = gson.fromJson(response, CustomResponseDTO.class);
            if (customResponseDTO.getSuccess()) {
                return this.parse(customResponseDTO.getMessage(), urlSplit[4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    @Override
    public ArrayList<String> getSubreddits(String url) {
        return null;
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
    public String parse(String json, String keyword) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Gson gson = new GsonBuilder().create();
            JsonNode jsonObject = mapper.readValue(json, JsonNode.class);
            Map<String, List<String>> keywordURLMapping = new HashMap<>();
            keywordURLMapping.put(keyword, jsonObject.findValuesAsText("url"));
            return gson.toJson(keywordURLMapping);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
