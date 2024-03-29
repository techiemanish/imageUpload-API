package com.photoupload.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ImageConfig {
    @Bean
    public Cloudinary cloudinary(){
        Map config = new HashMap();
        config.put("cloud_name","dqg7ul4hg");
        config.put("api_key","461357885184765");
        config.put("api_secret","WgK8r5Q9Wh5APHPMZP_3JNS0OLU");
        config.put("secure", true);
        return new Cloudinary(config);
    }
}
