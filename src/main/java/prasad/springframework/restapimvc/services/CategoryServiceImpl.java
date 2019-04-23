package prasad.springframework.restapimvc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import prasad.springframework.restapimvc.api.v1.mapper.CategoryMapper;
import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;
import prasad.springframework.restapimvc.repositories.CatergoryRepositories;

import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    public CategoryServiceImpl(CategoryMapper categoryMapper, CatergoryRepositories catergoryRepositories) {
        this.categoryMapper = categoryMapper;
        this.catergoryRepositories = catergoryRepositories;
    }

    private final CategoryMapper categoryMapper;
    private final CatergoryRepositories catergoryRepositories;

    @Override
    public List<CategoryDTO> getCategories() {

        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        catergoryRepositories.findAll().forEach(category -> System.out.println(category.getName()));
        catergoryRepositories.findAll().forEach(category ->  categoryDTOList.add( categoryMapper.categoryToCategoryDTO(category)));
        return categoryDTOList;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {

       return categoryMapper.categoryToCategoryDTO(catergoryRepositories.findByName(name));
    }
}

