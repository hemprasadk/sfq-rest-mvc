package prasad.springframework.restapimvc.controllers.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;
import prasad.springframework.restapimvc.api.v1.model.CategoryListDTO;
import prasad.springframework.restapimvc.api.v1.model.CustomerDTO;
import prasad.springframework.restapimvc.api.v1.model.CustomerListDTO;
import prasad.springframework.restapimvc.services.CategoryService;
import prasad.springframework.restapimvc.services.CustomerService;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomer()
    {
        return new CustomerListDTO(customerService.getcustomer());
    }

    @GetMapping("{lastname}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerByName(@PathVariable String lastname){
        return customerService.getCustomerByLastName(lastname);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){

        System.out.println(customerDTO.getFirstName());
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable Long id,@RequestBody  CustomerDTO customerDTO){

        System.out.println(customerDTO.getFirstName());
        return customerService.saveCustomerDTO(id, customerDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable Long id,@RequestBody  CustomerDTO customerDTO){

        System.out.println(customerDTO.getFirstName());
        return customerService.patchCustomerDTO(id, customerDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustoemr(id);
    }

}
