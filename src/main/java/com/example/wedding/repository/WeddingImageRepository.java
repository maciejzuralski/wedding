package com.example.wedding.repository;

import com.example.wedding.model.WeddingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingImageRepository
        extends JpaRepository<WeddingImage, Long> {

}
