package com.xdpsx.onlineshop.repositories;

import com.xdpsx.onlineshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer>,
        JpaSpecificationExecutor<Category> {
    boolean existsByName(String name);
    boolean existsBySlug(String slug);
    Optional<Category> findBySlug(String slug);

    @Query(value =
            "SELECT COUNT(*) FROM (" +
                "SELECT category_id FROM category_brands WHERE category_id = ?1 " +
            ") AS combined"
            , nativeQuery = true)
    long countCategoriesInOtherTables(Integer categoryId);
}
