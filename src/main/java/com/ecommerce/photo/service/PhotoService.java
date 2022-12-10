package com.ecommerce.photo.service;

import com.ecommerce.photo.model.Photo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    public String addPhoto(String id, MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(id);
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepo.insert(photo);
        return photo.getId();
    }

    public Photo getPhoto(String id) {

        return photoRepo.findById(id).get();
    }
}
