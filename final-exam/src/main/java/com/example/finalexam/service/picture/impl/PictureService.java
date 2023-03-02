package com.example.finalexam.service.picture.impl;

import com.example.finalexam.model.Category;
import com.example.finalexam.model.Picture;
import com.example.finalexam.repository.ICategoryRepository;
import com.example.finalexam.repository.IPictureRepository;
import com.example.finalexam.service.picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository pictureRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Page<Picture> findAllByName(String name, Pageable pageable) {
        return this.pictureRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Picture> findAllByNameAndCategoryId(String name, Long id, Pageable pageable) {
        return this.pictureRepository.findAllByNameContainingAndCategory_Id(name, id, pageable);
    }

    @Override
    public boolean save(Picture picture) {
        Category category = this.categoryRepository.findById(picture.getCategory().getId()).orElse(null);
        if (category == null) {
            return false;
        }
        this.pictureRepository.save(picture);
        return true;
    }

    @Override
    public boolean removeById(Long id) {
        Picture picture = this.pictureRepository.findById(id).orElse(null);
        if(picture == null){
            return false;
        }
        this.pictureRepository.delete(picture);
        return true;
    }
}
