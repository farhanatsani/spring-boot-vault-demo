package com.vault.demo.customer.s2;

import com.vault.demo.customer.Customer;
import com.vault.demo.customer.CustomerRepository;
import com.vault.demo.vault.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class S2_CustomerService {
    private CustomerRepository customerRepository;
    public S2_CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public S2_CustomerDTO saveCustomer(S2_CustomerDTO customerDTO) {
        log.info("Save customer");
        log.info("Name {}", customerDTO.getName());
        log.info("NIK {}", customerDTO.getEncryptedNik());
        log.info("Phone No {}", customerDTO.getEncryptedPhoneNo());
        log.info("Address {}", customerDTO.getAddress());
        Customer customer = S2_CustomerMapper.toCustomer(customerDTO);
        return S2_CustomerMapper.toCustomerDTO(customerRepository.saveAndFlush(customer));
    }
    public S2_CustomerDTO findCustomer(UUID id) {
        Customer customer = customerRepository.findById(id).get();
        S2_CustomerDTO s2Customer = S2_CustomerMapper.toCustomerDTO(customer);
        return s2Customer;
    }
}
