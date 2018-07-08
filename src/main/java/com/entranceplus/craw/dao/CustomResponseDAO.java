package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.CustomResponse;

public interface CustomResponseDAO {
    public CustomResponse createCustomResponse(String message, boolean success, int status);
}
