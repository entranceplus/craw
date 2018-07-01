package com.ep.LinkExtractor.dao;

import com.ep.LinkExtractor.dto.CustomResponseDTO;


public class CustomResponseDAOImpl implements CustomResponseDAO {

    @Override
    public CustomResponseDTO createCustomResponse(String message, boolean success, int status) {
        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
        customResponseDTO.setMessage(message);
        customResponseDTO.setStatus(status);
        customResponseDTO.setSuccess(success);
        return customResponseDTO;
    }
}
