package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.LinkDTO;

public class LinkDAOImpl implements LinkDAO {

    @Override
    public LinkDTO createLink(String sublink, String keyword) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setKeyword(keyword);
        linkDTO.setSublink(sublink);
        return linkDTO;
    }
}
