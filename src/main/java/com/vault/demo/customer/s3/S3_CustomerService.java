package com.vault.demo.customer.s3;

import com.vault.demo.customer.Customer;
import com.vault.demo.customer.CustomerRepository;
import com.vault.demo.customer.s2.S2_CustomerDTO;
import com.vault.demo.customer.s2.S2_CustomerMapper;
import com.vault.demo.vault.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class S3_CustomerService {
    private CustomerRepository customerRepository;
    private VaultService vaultService;
    public S3_CustomerService(CustomerRepository customerRepository, VaultService vaultService) {
        this.customerRepository = customerRepository;
        this.vaultService = vaultService;
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
