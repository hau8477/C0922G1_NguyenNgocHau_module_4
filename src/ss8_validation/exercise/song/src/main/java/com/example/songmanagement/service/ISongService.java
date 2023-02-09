package com.example.songmanagement.service;

import com.example.songmanagement.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    Optional<Song> findById(Long id);

    void save(Song song);

    void update(Song song);
}
