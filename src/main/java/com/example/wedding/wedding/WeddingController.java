package com.example.wedding.wedding;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeddingController {
    private final WeddingService weddingService;

    @Autowired
    public WeddingController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }

    @PostMapping("/createWedding")
    public String createWedding(@RequestParam("weddingName") String weddingName, Model model) {
        Wedding wedding = new Wedding();
        wedding.setTitle(weddingName);

        weddingService.saveWedding(wedding);

        model.addAttribute("weddingId", wedding.getId());
        model.addAttribute("weddingPhotos", wedding.getWeddingImageList());

        return "gallery";
    }
}
