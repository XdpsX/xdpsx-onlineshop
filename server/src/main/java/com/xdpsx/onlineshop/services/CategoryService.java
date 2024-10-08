package com.xdpsx.onlineshop.services;

import com.xdpsx.onlineshop.dtos.category.CategoryRequest;
import com.xdpsx.onlineshop.dtos.category.CategoryResponse;
import com.xdpsx.onlineshop.dtos.common.PageParams;
import com.xdpsx.onlineshop.dtos.common.PageResponse;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<CategoryResponse> listAllCategories();
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategory(Integer id, CategoryRequest request);
    void deleteCategory(Integer id);
    PageResponse<CategoryResponse> listCategoriesByPage(PageParams params);
    Map<String, Boolean> checkExistsCat(String name, String slug);
    CategoryResponse getCategoryBySlug(String categorySlug);
}
