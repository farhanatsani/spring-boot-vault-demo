package com.vault.demo.jasypt.vault;

import com.vault.demo.jasypt.Customer;
import com.vault.demo.vault.VaultService;

public class CustomerMapper {
    public static Customer toCustomer(CustomerDTO customerDTO, VaultService vaultService) {
        return Customer.builder()
                .name(customerDTO.getName())
                .phoneNo(vaultService.encrypt(customerDTO.getPhoneNo()))
                .nik(vaultService.encrypt(customerDTO.getNik()))
                .address(customerDTO.getAddress())
                .build();
    }
    public static CustomerDTO toCustomerDTO(Customer customer, VaultService vaultService) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNo(vaultService.decrypt(customer.getPhoneNo()))
                .nik(vaultService.decrypt(customer.getNik()))
                .address(customer.getAddress())
                .build();
    }
}
