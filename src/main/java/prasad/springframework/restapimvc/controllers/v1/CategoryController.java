package prasad.springframework.restapimvc.controllers.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;
import prasad.springframework.restapimvc.api.v1.model.CategoryListDTO;
import prasad.springframework.restapimvc.services.CategoryService;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getallcattegories()
    {
        return new CategoryListDTO(categoryService.getCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName( @PathVariable String name){
        return categoryService.getCategoryByName(name);
    }

}
