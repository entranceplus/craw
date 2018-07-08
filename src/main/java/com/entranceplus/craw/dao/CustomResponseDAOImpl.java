package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.CustomResponse;


public class CustomResponseDAOImpl implements CustomResponseDAO {

    @Override
    public CustomResponse createCustomResponse(String message, boolean success, int status) {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setMessage(message);
        customResponse.setStatus(status);
        customResponse.setSuccess(success);
        return customResponse;
    }
}
