package com.ep.LinkExtractor.dao;

import com.ep.LinkExtractor.dto.CustomResponseDTO;

public interface CustomResponseDAO {
    public CustomResponseDTO createCustomResponse(String message, boolean success, int status);
}
