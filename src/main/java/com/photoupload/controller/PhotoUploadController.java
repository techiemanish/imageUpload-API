package com.photoupload.controller;

import com.photoupload.service.ImageUploadImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class PhotoUploadController {
    @Autowired
    private ImageUploadImpl imageUpload;

    @PostMapping("/api/upload")
    public ResponseEntity<Map> photoUpload(@RequestParam("image") MultipartFile file){
        Map data = this.imageUpload.uploadImage(file);
        if(null != data){
            Map response = new LinkedHashMap();
            response.put("status","success");
            response.put("image_url", data.get("secure_url"));
            response.put("format", data.get("format"));
            response.put("height",data.get("height"));
            response.put("width",data.get("width"));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else {
            Map error = new HashMap();
            error.put("status","error");
            error.put("message","Image upload fail!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
