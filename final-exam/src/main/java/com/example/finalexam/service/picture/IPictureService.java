package com.example.finalexam.service.picture;

import com.example.finalexam.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPictureService {
    Page<Picture> findAllByName(String name, Pageable pageable);

    Page<Picture> findAllByNameAndCategoryId(String name, Long id, Pageable pageable);
    boolean save(Picture picture);

    boolean removeById(Long id);
}
