package prasad.springframework.restapimvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prasad.springframework.restapimvc.domain.Category;

public interface CatergoryRepositories extends JpaRepository<Category,Long> {


}
