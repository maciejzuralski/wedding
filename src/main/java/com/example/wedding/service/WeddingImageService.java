package com.example.wedding.service;

import com.example.wedding.model.Wedding;
import com.example.wedding.model.WeddingImage;
import com.example.wedding.repository.WeddingImageRepository;
import com.example.wedding.repository.WeddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class WeddingImageService {

    private final String uploadDir = "/Users/maciejzuralski/Desktop/website/uploads/";

    private final WeddingImageRepository weddingImageRepository;

    private final WeddingRepository weddingRepository;

    public WeddingImageService(WeddingImageRepository weddingImageRepository, WeddingRepository weddingRepository) {
        this.weddingImageRepository = weddingImageRepository;
        this.weddingRepository = weddingRepository;
    }

    public Wedding addWeddingImage(Long weddingId, MultipartFile file) throws IOException {
        Wedding wedding = weddingRepository.findById(weddingId)
                .orElseThrow(() -> new RuntimeException("Wedding not found"));

        // Generate unique filename to avoid overwriting
        String originalFileName = file.getOriginalFilename();
        String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;

        // Save the file to the upload directory
        Path filePath = Paths.get(this.uploadDir, uniqueFileName); // uploadDir should be properly set
        Files.write(filePath, file.getBytes());

        // Store the relative URL or image path to access via the web
        String relativePath = "/uploads/" + uniqueFileName;

        // Create and associate a new WeddingImage
        WeddingImage weddingImage = new WeddingImage();
        weddingImage.setImagePath(relativePath);  // Store the web-accessible relative path
        weddingImage.setWedding(wedding);

        wedding.addWeddingImage(weddingImage);

        weddingRepository.save(wedding);

        return wedding;
    }

}
