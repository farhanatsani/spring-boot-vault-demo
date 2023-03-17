package com.vault.demo.customer.vault;

import com.vault.demo.vault.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerVaultService {
    private CustomerVaultRepository customerVaultRepository;
    private VaultService vaultService;
    public CustomerVaultService(CustomerVaultRepository customerVaultRepository, VaultService vaultService) {
        this.customerVaultRepository = customerVaultRepository;
        this.vaultService = vaultService;
    }
    public CustomerVaultDTO saveCustomer(CustomerVaultDTO customerVaultDTO) {
        log.info("Save customer");
        log.info("Name {}", customerVaultDTO.getName());
        log.info("NIK {}", customerVaultDTO.getNik());
        log.info("Phone No {}", customerVaultDTO.getPhoneNo());
        log.info("Address {}", customerVaultDTO.getAddress());
        CustomerVault s1CustomerVault = CustomerVaultMapper.toCustomer(customerVaultDTO, vaultService);
        return CustomerVaultMapper.toCustomerDTO(customerVaultRepository.saveAndFlush(s1CustomerVault), vaultService);
    }
    public CustomerVaultDTO findCustomer(UUID id) {
        CustomerVault customerVault = customerVaultRepository.findById(id).get();
        CustomerVaultDTO s1Customer = CustomerVaultMapper.toCustomerDTO(customerVault, vaultService);
        return s1Customer;
    }
}
