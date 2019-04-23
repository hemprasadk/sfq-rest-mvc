package prasad.springframework.restapimvc.services;

import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;
import prasad.springframework.restapimvc.api.v1.model.CustomerDTO;
import prasad.springframework.restapimvc.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getcustomer();
    CustomerDTO getCustomerByLastName(String name);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO saveCustomerDTO (Long id , CustomerDTO customerDTO);
    CustomerDTO patchCustomerDTO (Long id , CustomerDTO customerDTO);
    void deleteCustoemr(Long id);
}
