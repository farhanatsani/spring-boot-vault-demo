package com.vault.demo.customer.s2;

import com.vault.demo.customer.Customer;

public class S2_CustomerMapper {
    public static Customer toCustomer(S2_CustomerDTO s2CustomerDTO) {
        return Customer.builder()
                .name(s2CustomerDTO.getName())
                .phoneNo(s2CustomerDTO.getEncryptedPhoneNo())
                .nik(s2CustomerDTO.getEncryptedNik())
                .address(s2CustomerDTO.getAddress())
                .build();
    }
    public static S2_CustomerDTO toCustomerDTO(Customer customer) {
        return S2_CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .encryptedPhoneNo(customer.getPhoneNo())
                .encryptedNik(customer.getNik())
                .address(customer.getAddress())
                .build();
    }
}
