package com.example.finalexam.repository;

import com.example.finalexam.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPictureRepository extends JpaRepository<Picture, Long> {
    Page<Picture> findAllByNameContaining(String name, Pageable pageable);

    Page<Picture> findAllByNameContainingAndCategory_Id(String name,Long id,Pageable pageable);
}
