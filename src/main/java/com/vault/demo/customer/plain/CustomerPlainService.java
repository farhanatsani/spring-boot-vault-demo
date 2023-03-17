package com.vault.demo.customer.plain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerPlainService {
    private CustomerPlainRepository customerPlainRepository;
    public CustomerPlainService(CustomerPlainRepository customerPlainRepository) {
        this.customerPlainRepository = customerPlainRepository;
    }
    public CustomerPlainDTO saveCustomer(CustomerPlainDTO customerPlainDTO) {
        log.info("Save customer");
        log.info("Name {}", customerPlainDTO.getName());
        log.info("NIK {}", customerPlainDTO.getNik());
        log.info("Phone No {}", customerPlainDTO.getPhoneNo());
        log.info("Address {}", customerPlainDTO.getAddress());
        CustomerPlain customerPlain = CustomerPlainMapper.toCustomer(customerPlainDTO);
        return CustomerPlainMapper.toCustomerDTO(customerPlainRepository.saveAndFlush(customerPlain));
    }
    public CustomerPlainDTO findCustomer(UUID id) {
        CustomerPlain customerPlain = customerPlainRepository.findById(id).get();
        CustomerPlainDTO customerDTO = CustomerPlainMapper.toCustomerDTO(customerPlain);
        return customerDTO;
    }
}
