package com.vault.demo.jasypt.vault;

import com.vault.demo.jasypt.Customer;
import com.vault.demo.jasypt.CustomerRepository;
import com.vault.demo.vault.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private VaultService vaultService;
    public CustomerService(CustomerRepository customerRepository, VaultService vaultService) {
        this.customerRepository = customerRepository;
        this.vaultService = vaultService;
    }
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("Save customer");
        log.info("Name {}", customerDTO.getName());
        log.info("NIK {}", customerDTO.getNik());
        log.info("Phone No {}", customerDTO.getPhoneNo());
        log.info("Address {}", customerDTO.getAddress());
        Customer s1Customer = CustomerMapper.toCustomer(customerDTO, vaultService);
        return CustomerMapper.toCustomerDTO(customerRepository.saveAndFlush(s1Customer), vaultService);
    }
    public CustomerDTO findCustomer(UUID id) {
        Customer customer = customerRepository.findById(id).get();
        CustomerDTO s1Customer = CustomerMapper.toCustomerDTO(customer, vaultService);
        return s1Customer;
    }
}
