package com.jotech.mssc_brewery.web.mappers;

import com.jotech.mssc_brewery.domain.Customer;
import com.jotech.mssc_brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto  customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
