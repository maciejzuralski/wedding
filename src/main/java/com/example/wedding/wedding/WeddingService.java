package com.example.wedding.wedding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeddingService {
    private final WeddingRepository weddingRepository;

    @Autowired
    public WeddingService(WeddingRepository weddingRepository) {
        this.weddingRepository = weddingRepository;
    }

    public void saveWedding(Wedding wedding) {
        weddingRepository.save(wedding);
    }

    public void addWedding(Wedding wedding) {
        weddingRepository.save(wedding);
    }

    public Wedding getWeddingById(Long weddingId) {
        return weddingRepository.findById(weddingId)
                .orElseThrow(() -> new RuntimeException("Wedding not found with id " + weddingId));
    }
}
