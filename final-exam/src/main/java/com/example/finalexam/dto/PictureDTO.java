package com.example.finalexam.dto;

import com.example.finalexam.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PictureDTO {
    private Long id;
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải có trường này")
    private String name;
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải có trường này")
    private String author;
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải có trường này")
    private String date;
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải có trường này")
    private String size;
    @NotNull(message = "Phải có trường này")
    private Category category;

    public PictureDTO() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
