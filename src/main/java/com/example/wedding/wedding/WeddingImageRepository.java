package com.example.wedding.wedding;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingImageRepository
        extends JpaRepository<WeddingImage, Long> {

}
