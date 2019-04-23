package prasad.springframework.restapimvc.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import prasad.springframework.restapimvc.domain.Category;
import prasad.springframework.restapimvc.domain.Customer;
import prasad.springframework.restapimvc.repositories.CatergoryRepositories;
import prasad.springframework.restapimvc.repositories.CustomerRepositories;

@AllArgsConstructor

@Component
public class BootStrap implements CommandLineRunner {

    private CatergoryRepositories catergoryRepositories;
    private CustomerRepositories customerRepositories;
    @Override
    public void run(String... args) throws Exception {

        Category fruits = Category.builder().name("Fruits").build();
        Category dried = Category.builder().name("Dried").build();
        Category fresh = Category.builder().name("Fresh").build();
        Category exotic = Category.builder().name("exotic").build();
        Category nuts = Category.builder().name("nuts").build();

        Customer Adam = Customer.builder().firstName("Adam").lastName("Charles").build();
        Customer Charles = Customer.builder().firstName("Charles").lastName("singh").build();
        Customer Stephen = Customer.builder().firstName("Stephen").lastName("Thokmas").build();
        Customer Albert = Customer.builder().firstName("Albert").lastName("Stephen").build();
        Customer Thokmas = Customer.builder().firstName("Thokmas").lastName("Charles").build();

        customerRepositories.save(Adam);
        customerRepositories.save(Charles);
        customerRepositories.save(Stephen);
        customerRepositories.save(Albert);
        customerRepositories.save(Thokmas);

        catergoryRepositories.save(fruits);
        catergoryRepositories.save(dried);
        catergoryRepositories.save(fresh);
        catergoryRepositories.save(exotic);
        catergoryRepositories.save(nuts);

        System.out.println("Count of fruits"+catergoryRepositories.count());
        System.out.println("Count of fruits"+customerRepositories.count());
    }
}
