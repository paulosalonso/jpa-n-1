package com.github.paulosalonso.jpacircularmapping.repository;

import com.github.paulosalonso.jpacircularmapping.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("from Category c join fetch c.subCategories where c.parent is null")
    List<Category> listRootCategoriesWithFirstLevelOfSubCategories();
}
