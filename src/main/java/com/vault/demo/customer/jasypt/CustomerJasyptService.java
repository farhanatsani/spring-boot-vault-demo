package com.vault.demo.customer.jasypt;

import com.vault.demo.customer.vault.CustomerVault;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerJasyptService {
    private CustomerJasyptRepository customerJasyptRepository;
    public CustomerJasyptService(CustomerJasyptRepository customerJasyptRepository) {
        this.customerJasyptRepository = customerJasyptRepository;
    }
    public CustomerJasyptDTO saveCustomer(CustomerJasyptDTO customerJasyptDTO) {
        log.info("Save customer");
        log.info("Name {}", customerJasyptDTO.getName());
        log.info("NIK {}", customerJasyptDTO.getNik());
        log.info("Phone No {}", customerJasyptDTO.getPhoneNo());
        log.info("Address {}", customerJasyptDTO.getAddress());
        CustomerJasypt customerJasypt = CustomerJasyptMapper.toCustomer(customerJasyptDTO);
        return CustomerJasyptMapper.toCustomerDTO(customerJasyptRepository.saveAndFlush(customerJasypt));
    }
    public CustomerJasyptDTO findCustomer(UUID id) {
        CustomerJasypt customerJasypt = customerJasyptRepository.findById(id).get();
        CustomerJasyptDTO customerDTO = CustomerJasyptMapper.toCustomerDTO(customerJasypt);
        return customerDTO;
    }
}
