package com.vault.demo.customer.s1;

import com.vault.demo.customer.Customer;
import com.vault.demo.customer.s1.S1_CustomerDTO;
import com.vault.demo.vault.VaultService;

public class S1_CustomerMapper {
    public static Customer toCustomer(S1_CustomerDTO s1CustomerDTO, VaultService vaultService) {
        return Customer.builder()
                .name(s1CustomerDTO.getName())
                .phoneNo(vaultService.decrypt(s1CustomerDTO.getEncryptedPhoneNo()))
                .nik(vaultService.decrypt(s1CustomerDTO.getEncryptedNik()))
                .address(s1CustomerDTO.getAddress())
                .build();
    }
    public static S1_CustomerDTO toCustomerDTO(Customer customer, VaultService vaultService) {
        return S1_CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .encryptedPhoneNo(vaultService.encrypt(customer.getPhoneNo()))
                .encryptedNik(vaultService.decrypt(customer.getNik()))
                .address(customer.getAddress())
                .build();
    }
}
