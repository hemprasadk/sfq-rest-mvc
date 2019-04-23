package prasad.springframework.restapimvc.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import prasad.springframework.restapimvc.api.v1.mapper.CategoryMapper;
import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;
import prasad.springframework.restapimvc.controllers.v1.CategoryController;
import prasad.springframework.restapimvc.domain.Category;
import prasad.springframework.restapimvc.repositories.CatergoryRepositories;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    CategoryService categoryService;

    @Mock
    CatergoryRepositories categoryRepository;
    @InjectMocks
    CategoryController categoryController;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() throws Exception {

        //given
        Category fruits = Category.builder().name("Fruits").build();
        Category dried = Category.builder().name("Dried").build();
        Category fresh = Category.builder().name("Fresh").build();
        Category exotic = Category.builder().name("exotic").build();
        Category nuts = Category.builder().name("nuts").build();


        List<Category> categories = Arrays.asList(fruits,dried, fresh);

        when(categoryRepository.findAll()).thenReturn(categories);

        //when
        List<CategoryDTO> categoryDTOS = categoryService.getCategories();

        //then
        assertEquals(3, categoryDTOS.size());

    }

    @Test
    public void getCategoryByName() throws Exception {

        //given
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        //when
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

        //then
        assertEquals(ID, categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());

    }

}