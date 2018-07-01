package com.ep.LinkExtractor.dao;

import com.ep.LinkExtractor.dto.LinkDTO;

public interface LinkDAO {

    public LinkDTO createLink(String sublink, String keyword);
}
