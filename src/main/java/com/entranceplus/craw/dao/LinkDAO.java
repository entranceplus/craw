package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.LinkDTO;

public interface LinkDAO {

    public LinkDTO createLink(String sublink, String keyword);
}
