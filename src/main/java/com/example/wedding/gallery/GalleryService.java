package com.example.wedding.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;

    @Autowired
    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public List<Image> getGallery() {
        return galleryRepository.findAll();
    }

    public List<Image> getGalleryByWeddingId(Long weddingId) {
        return galleryRepository.findByWeddingId(weddingId);
    }
}
