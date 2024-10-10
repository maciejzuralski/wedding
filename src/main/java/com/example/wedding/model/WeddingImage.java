package com.example.wedding.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class WeddingImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wedding")
    private Wedding wedding;

    @Lob
    @Column
    private byte[] image;  // Store image binary data as byte array

}
