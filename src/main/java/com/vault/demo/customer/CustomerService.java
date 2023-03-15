package com.vault.demo.customer;

import com.vault.demo.vault.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {
    private VaultService vaultService;
    public CustomerService(VaultService vaultService) {
        this.vaultService = vaultService;
    }
    public void registerCustomer(CustomerDTO customer) {
        log.info("Register customer");
        log.info("Name {}", customer.getName());
        log.info("NIK {}", vaultService.decrypt(customer.getNik()));
        log.info("Phone No {}", vaultService.decrypt(customer.getPhoneNo()));
        log.info("Address {}", customer.getAddress());
    }
    public CustomerDTO findCustomer(Long id) {
        CustomerDTO customer = CustomerDTO.builder()
                .id(1L)
                .name("Agus")
                .nik(vaultService.encrypt("3512341978100001"))
                .phoneNo(vaultService.encrypt("0812122300"))
                .address("Jl. Anggrek No. 11")
                .build();
        return customer;
    }
}
