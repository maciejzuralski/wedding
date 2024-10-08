package com.example.wedding.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
    private static final String PHOTOS_DIR = "/Users/maciejzuralski/Desktop/website/weding/src/main/java/com/example/weding/photos/";

    private final GalleryService galleryService;

    @Autowired
    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/{weddinId}")
    public String getGallery(@RequestParam("wedding") String weddingId, Model model) {
        // Ścieżka do katalogu ze zdjęciami dla podanego id
        weddingId = '_' + weddingId;
        String weddingPhotosDir = PHOTOS_DIR + weddingId;

        // Lista nazw plików zdjęć
        List<String> photoFilenames = new ArrayList<>();

        File folder = new File(weddingPhotosDir);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isImageFile(file.getName())) {
                        photoFilenames.add(file.getName());
                    }
                }
            }
        }

        // Dodaj listę zdjęć do modelu
        model.addAttribute("photoFilenames", photoFilenames);
        model.addAttribute("weddingId", weddingId);
        model.addAttribute("weddingPhotosDir", weddingPhotosDir);

        // Zwrócenie nazwy widoku (html)
        return "gallery";
    }

    // Metoda sprawdzająca czy plik jest zdjęciem na podstawie rozszerzenia
    private boolean isImageFile(String filename) {
        String lowerCaseFilename = filename.toLowerCase();
        return lowerCaseFilename.endsWith(".jpg") || lowerCaseFilename.endsWith(".jpeg") ||
                lowerCaseFilename.endsWith(".png") || lowerCaseFilename.endsWith(".gif");
    }
}
