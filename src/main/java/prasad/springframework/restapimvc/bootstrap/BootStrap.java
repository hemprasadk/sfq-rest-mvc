package prasad.springframework.restapimvc.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import prasad.springframework.restapimvc.domain.Category;
import prasad.springframework.restapimvc.repositories.CatergoryRepositories;

@AllArgsConstructor

@Component
public class BootStrap implements CommandLineRunner {

    private CatergoryRepositories catergoryRepositories;
    @Override
    public void run(String... args) throws Exception {

        Category fruits = Category.builder().name("Fruits").build();
        Category dried = Category.builder().name("Dried").build();
        Category fresh = Category.builder().name("Fresh").build();
        Category exotic = Category.builder().name("exotic").build();
        Category nuts = Category.builder().name("nuts").build();

        catergoryRepositories.save(fruits);
        catergoryRepositories.save(dried);
        catergoryRepositories.save(fresh);
        catergoryRepositories.save(exotic);
        catergoryRepositories.save(nuts);

        System.out.println("Count of fruits"+catergoryRepositories.count());
    }
}
