package prasad.springframework.restapimvc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import prasad.springframework.restapimvc.api.v1.mapper.CategoryMapper;
import prasad.springframework.restapimvc.api.v1.mapper.CustomerMapper;
import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;
import prasad.springframework.restapimvc.api.v1.model.CustomerDTO;
import prasad.springframework.restapimvc.domain.Customer;
import prasad.springframework.restapimvc.repositories.CatergoryRepositories;
import prasad.springframework.restapimvc.repositories.CustomerRepositories;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerMapper customerMapper;
    private final CustomerRepositories customerRepositories;

    @Override
    public List<CustomerDTO> getcustomer() throws ResourceNotFoundException{

        List<CustomerDTO> categoryDTOList = new ArrayList<>();
            customerRepositories.findAll().forEach(customer -> {
            CustomerDTO customerDTO = customerMapper.customertocustomerDTO(customer);
            customerDTO.setCustomerURL("/api/v1/customer/"+customer.getId());
            categoryDTOList.add(customerDTO);
        });
        return categoryDTOList;
    }

    @Override
    public CustomerDTO getCustomerByLastName(String name) throws ResourceNotFoundException {

       return customerMapper.customertocustomerDTO(customerRepositories.findByLastName(name));
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

        return saveAndReturnDTO(customerMapper.customerDTOtocustomer(customerDTO));
    }

    private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepositories.save(customer);

        CustomerDTO returnDto = customerMapper.customertocustomerDTO(savedCustomer);

        returnDto.setCustomerURL("/api/v1/customer/" + savedCustomer.getId());

        return returnDto;
    }

    @Override
    public CustomerDTO saveCustomerDTO(Long id, CustomerDTO customerDTO) throws ResourceNotFoundException {

        Customer customer = customerMapper.customerDTOtocustomer(customerDTO);
        customer.setId(id);
        return saveAndReturnDTO(customer);

    }

    @Override
    public CustomerDTO patchCustomerDTO(Long id, CustomerDTO customerDTO)  {

        return customerRepositories.findById(id).map(customer -> {

            if(customerDTO.getFirstName() != null){
                customer.setFirstName(customerDTO.getFirstName());
            }

            if(customerDTO.getLastName() != null){
                customer.setLastName(customerDTO.getLastName());
            }

            CustomerDTO returnDto = customerMapper.customertocustomerDTO(customerRepositories.save(customer));

            returnDto.setCustomerURL("/api/v1/customers/" + id);

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new); //todo implement better exception handling;
    }

    @Override
    public void deleteCustoemr(Long id) {
        customerRepositories.deleteById(id);
    }

}


