package com.example.wedding.service;

import com.example.wedding.model.Wedding;
import com.example.wedding.model.WeddingImage;
import com.example.wedding.repository.WeddingImageRepository;
import com.example.wedding.repository.WeddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class WeddingImageService {

    private final WeddingImageRepository weddingImageRepository;

    private final WeddingRepository weddingRepository;

    public WeddingImageService(WeddingImageRepository weddingImageRepository, WeddingRepository weddingRepository) {
        this.weddingImageRepository = weddingImageRepository;
        this.weddingRepository = weddingRepository;
    }

    public Wedding addWeddingImage(Long weddingId, MultipartFile file) throws IOException {
        Wedding wedding = weddingRepository.findById(weddingId)
                .orElseThrow(() -> new RuntimeException("Wedding not found"));

        WeddingImage weddingImage = new WeddingImage();
        weddingImage.setImage(file.getBytes());
        weddingImage.setWedding(wedding);

        wedding.addWeddingImage(weddingImage);

//        weddingImageRepository.save(weddingImage);
        weddingRepository.save(wedding);

        return wedding;
    }

}
