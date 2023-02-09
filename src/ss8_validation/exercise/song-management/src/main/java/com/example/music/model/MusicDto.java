package com.example.music.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;
    @NotEmpty(message ="Tên bài hát không được để trống")
    @Size(max = 800,message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[\\w|\\s]+$",message = "Tên bài hát không chứa các kí tự đặc biệt.")
    private String name;
    @NotEmpty(message ="Không được để trống")
    @Size(max = 300,message = "Không vượt quá 300 ký tự")
    @Pattern(regexp = "^[\\w|\\s]+$",message = "Tên ca sĩ không chứa các kí tự đặc biệt.")
    private String singer;
    @NotEmpty(message ="Không được để trống")
    @Size(max = 1000,message = "Không vượt quá 1000 ký tự")
    private String category;

    public MusicDto( int id,String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MusicDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        String category = musicDto.getCategory();
        if(!category.matches("^[\\w|,]+$")){
            errors.rejectValue("category","ErrorCategory");
        }
    }
}
