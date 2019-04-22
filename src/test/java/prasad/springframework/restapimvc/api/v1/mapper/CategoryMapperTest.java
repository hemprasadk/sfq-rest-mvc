package prasad.springframework.restapimvc.api.v1.mapper;

import org.junit.Before;
import org.junit.Test;
import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;
import prasad.springframework.restapimvc.domain.Category;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    public static final String NAME = "Joe";
    public static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

@Test
    public void CategorytoCategoryDTO() throws Exception
    {
    Category category = Category.builder().name(NAME).id(1L).build();
    CategoryDTO categoryDTO = categoryMapper.categorytocategoryDTO(category);

    assertEquals(Long.valueOf(ID),categoryDTO.getId());
    assertEquals(NAME,categoryDTO.getName());
    }
}