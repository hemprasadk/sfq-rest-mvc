package prasad.springframework.restapimvc.services;

import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getCategories();
    CategoryDTO getCategoryByName(String name);
}
