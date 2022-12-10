package com.ecommerce.photo.controller;

import com.ecommerce.photo.service.PhotoService;
import com.ecommerce.photo.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class PhotoController {
    @Autowired
    private PhotoService photoServ;

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("productId") String productId, @RequestParam("image") MultipartFile image )
            throws IOException {
        String id = this.photoServ.addPhoto(productId, image);
        return id;
//        return "API disabled";
    }

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        Photo photo = photoServ.getPhoto(id);
        String image = Base64.getEncoder().encodeToString(photo.getImage().getData());
        return image;
    }
}
