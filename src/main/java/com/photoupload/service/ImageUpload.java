package com.photoupload.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUpload {
    public Map uploadImage(MultipartFile file);
}
