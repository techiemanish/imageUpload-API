package com.photoupload.service;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadImpl implements ImageUpload {
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public Map uploadImage(MultipartFile file) {
        try {
            Map data = this.cloudinary.uploader().upload(file.getBytes(), Map.of());
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Image Upload fails with this exception "+ e);
        }
    }
}
