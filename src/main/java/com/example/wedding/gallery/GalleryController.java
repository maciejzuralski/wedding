package com.example.wedding.gallery;

import com.example.wedding.wedding.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/gallery")
@Controller
public class GalleryController {

    private final WeddingService weddingService;
    private final WeddingImageService weddingImageService;

    @Autowired
    public GalleryController(WeddingService weddingService, WeddingImageService weddingImageService) {
        this.weddingService = weddingService;
        this.weddingImageService = weddingImageService;
    }

    @PostMapping("/add")
    public String addToGallery(@RequestParam("weddingId") String weddingId, @RequestParam("file") MultipartFile file) throws IOException {
        Wedding wedding = weddingService.getWeddingById(Long.parseLong(weddingId));

        WeddingImage weddingImage = new WeddingImage();

        weddingImage.setImage(file.getBytes());
        weddingImage.setWedding(wedding);

        weddingImageService.addWeddingImage(weddingImage);
        return "gallery";
    }

    @GetMapping("/default")
    public String getGalleryDefault(Model model) {
        Wedding wedding = weddingService.getWeddingById(1234L);

        model.addAttribute("weddingId", 1234L);
        model.addAttribute("weddingPhotos", wedding.getWeddingImageList());

        return "gallery";
    }

    @GetMapping("{weddingId}")
    public String getGallery(@RequestParam("weddingId") String weddingId, Model model) {
        Wedding wedding = weddingService.getWeddingById(Long.parseLong(weddingId));

        model.addAttribute("weddingId", weddingId);
        model.addAttribute("weddingPhotos", wedding.getWeddingImageList());

        return "gallery";
    }

    // Metoda sprawdzająca czy plik jest zdjęciem na podstawie rozszerzenia
    private boolean isImageFile(String filename) {
        String lowerCaseFilename = filename.toLowerCase();
        return lowerCaseFilename.endsWith(".jpg") || lowerCaseFilename.endsWith(".jpeg") ||
                lowerCaseFilename.endsWith(".png") || lowerCaseFilename.endsWith(".gif");
    }
}
