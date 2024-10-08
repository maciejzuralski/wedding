package com.example.wedding.wedding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeddingImageService {

    private final WeddingImageRepository weddingImageRepository;

    @Autowired
    public WeddingImageService(WeddingImageRepository weddingImageRepository) {
        this.weddingImageRepository = weddingImageRepository;
    }

    public void addWeddingImage(WeddingImage weddingImage) {
        weddingImageRepository.save(weddingImage);
    }

}
