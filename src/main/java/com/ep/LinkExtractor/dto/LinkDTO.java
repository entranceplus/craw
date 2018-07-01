package com.ep.LinkExtractor.dto;

public class LinkDTO {
    public String getSublink() {
        return sublink;
    }

    public void setSublink(String sublink) {
        this.sublink = sublink;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return sublink+keyword;
    }

    private String sublink;
    private String keyword;


}
