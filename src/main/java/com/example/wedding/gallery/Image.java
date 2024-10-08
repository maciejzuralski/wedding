package com.example.wedding.gallery;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long weddingId;

    private String name;

    @Lob
    @Column(name = "image", columnDefinition = "BYTEA")
    private byte[] image;  // Store image binary data as byte array

}
