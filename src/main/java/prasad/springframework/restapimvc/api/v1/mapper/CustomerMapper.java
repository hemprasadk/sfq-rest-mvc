package prasad.springframework.restapimvc.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import prasad.springframework.restapimvc.api.v1.model.CategoryDTO;
import prasad.springframework.restapimvc.api.v1.model.CustomerDTO;
import prasad.springframework.restapimvc.domain.Category;
import prasad.springframework.restapimvc.domain.Customer;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customertocustomerDTO(Customer customer);
    Customer customerDTOtocustomer(CustomerDTO customerDTO);
}
