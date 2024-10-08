package com.example.wedding.gallery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalleryRepository extends JpaRepository<Image, Long> {


    List<Image> findByWeddingId(Long weddingId);
}
