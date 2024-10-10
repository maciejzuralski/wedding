package com.example.wedding.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "weddings")
public class Wedding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "wedding", cascade = CascadeType.ALL)
    private List<WeddingImage> weddingImageList;

    public void addWeddingImage(WeddingImage weddingImage) {
        weddingImageList.add(weddingImage);
    }

    public List<byte[]> getRawImagesList() {
        List<byte[]> rawImagesList = new ArrayList<>();
        for (WeddingImage weddingImage : weddingImageList) {
            rawImagesList.add(weddingImage.getImage());
        }
        return rawImagesList;
    }
}
