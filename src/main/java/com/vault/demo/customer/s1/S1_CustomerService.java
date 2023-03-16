package com.vault.demo.customer.s1;

import com.vault.demo.customer.Customer;
import com.vault.demo.customer.CustomerRepository;
import com.vault.demo.vault.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class S1_CustomerService {
    private CustomerRepository customerRepository;
    private VaultService vaultService;
    public S1_CustomerService(CustomerRepository customerRepository, VaultService vaultService) {
        this.customerRepository = customerRepository;
        this.vaultService = vaultService;
    }
    public S1_CustomerDTO saveCustomer(S1_CustomerDTO customerDTO) {
        log.info("Save customer");
        log.info("Name {}", customerDTO.getName());
        log.info("NIK {}", customerDTO.getEncryptedNik());
        log.info("Phone No {}", customerDTO.getEncryptedPhoneNo());
        log.info("Address {}", customerDTO.getAddress());
        Customer s1Customer = S1_CustomerMapper.toCustomer(customerDTO, vaultService);
        return S1_CustomerMapper.toCustomerDTO(customerRepository.saveAndFlush(s1Customer), vaultService);
    }
    public S1_CustomerDTO findCustomer(UUID id) {
        Customer customer = customerRepository.findById(id).get();
        S1_CustomerDTO s1Customer = S1_CustomerMapper.toCustomerDTO(customer, vaultService);
        return s1Customer;
    }
}
