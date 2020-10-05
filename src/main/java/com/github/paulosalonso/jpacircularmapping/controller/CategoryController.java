package com.github.paulosalonso.jpacircularmapping.controller;

import com.github.paulosalonso.jpacircularmapping.controller.dto.CategoryDTO;
import com.github.paulosalonso.jpacircularmapping.domain.Category;
import com.github.paulosalonso.jpacircularmapping.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CategoryDTO> list() {
        List<Category> categories = repository.listRootCategoriesWithFirstLevelOfSubCategories();
        return mapToDto(categories, true);
    }

    @GetMapping("/{id}")
    public Category find(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private List<CategoryDTO> mapToDto(List<Category> categories, boolean addSubCategories) {
        List<CategoryDTO> result = new ArrayList<>();

        for (Category category : categories) {
            CategoryDTO dto =  new CategoryDTO();
            dto.setId(category.getId());
            dto.setDescription(category.getDescription());

            if (addSubCategories) {
                dto.setSubCategorias(mapToDto(category.getSubCategories(), false));
            }

            result.add(dto);
        }

        return result;
    }
}
