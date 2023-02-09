package com.example.songmanagement.repository;

import com.example.songmanagement.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Long> {
    Page<Song> findAll(Pageable pageable);
}
