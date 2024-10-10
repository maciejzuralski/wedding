package com.example.wedding.repository;

import com.example.wedding.model.Wedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingRepository
        extends JpaRepository<Wedding, Long> {

}
