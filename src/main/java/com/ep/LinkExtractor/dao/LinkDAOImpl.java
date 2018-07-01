package com.ep.LinkExtractor.dao;

import com.ep.LinkExtractor.dto.LinkDTO;

public class LinkDAOImpl implements LinkDAO {

    @Override
    public LinkDTO createLink(String sublink, String keyword) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setKeyword(keyword);
        linkDTO.setSublink(sublink);
        return linkDTO;
    }
}
