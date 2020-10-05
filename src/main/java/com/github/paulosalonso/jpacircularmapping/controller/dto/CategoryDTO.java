package com.github.paulosalonso.jpacircularmapping.controller.dto;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private String description;
    private List<CategoryDTO> subCategorias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CategoryDTO> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<CategoryDTO> subCategorias) {
        this.subCategorias = subCategorias;
    }
}
