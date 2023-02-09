package com.example.songmanagement.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.regex.Pattern;

public class SongDTO implements Validator {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String artist;

    @NotNull
    private String genre;

    public SongDTO() {
    }

    public SongDTO(Long id, String name, String artist, String genre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SongDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;

        String nameDTO = songDTO.getName();
        String artistDTO = songDTO.getArtist();
        String genreDTO = songDTO.getGenre();

        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "artist", "artist.empty");
        ValidationUtils.rejectIfEmpty(errors, "genre", "genre.empty");

        if (nameDTO.length() > 800) {
            errors.rejectValue("name", "name.length");
        } else if (!Pattern.matches("^[a-zA-Z\\s]{1,800}$", nameDTO)) {
            errors.rejectValue("name", "name.char");
        }

        if (artistDTO.length() > 300) {
            errors.rejectValue("artist", "artist.length");
        } else if (!Pattern.matches("^[a-zA-Z\\s]{1,300}$", artistDTO)) {
            errors.rejectValue("artist", "artist.char");
        }

        if (genreDTO.length() > 1000) {
            errors.rejectValue("genre", "genre.length");
        } else if ((!Pattern.matches("^[^,\\\\W]+((,[^,\\\\W]+)*)?$", genreDTO))) {
            errors.rejectValue("genre", "genre.char");
        }

    }
}
