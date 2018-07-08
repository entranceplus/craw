package com.entranceplus.craw.dao;

import com.entranceplus.craw.dto.CustomResponseDTO;

public interface CustomResponseDAO {
    public CustomResponseDTO createCustomResponse(String message, boolean success, int status);
}
