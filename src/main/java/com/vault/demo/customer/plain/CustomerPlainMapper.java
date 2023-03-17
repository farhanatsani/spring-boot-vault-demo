package com.vault.demo.customer.plain;

public class CustomerPlainMapper {
    public static CustomerPlain toCustomer(CustomerPlainDTO customerPlainDTO) {
        return CustomerPlain.builder()
                .name(customerPlainDTO.getName())
                .phoneNo(customerPlainDTO.getPhoneNo())
                .nik(customerPlainDTO.getNik())
                .address(customerPlainDTO.getAddress())
                .build();
    }
    public static CustomerPlainDTO toCustomerDTO(CustomerPlain customerPlain) {
        return CustomerPlainDTO.builder()
                .id(customerPlain.getId())
                .name(customerPlain.getName())
                .phoneNo(customerPlain.getPhoneNo())
                .nik(customerPlain.getNik())
                .address(customerPlain.getAddress())
                .build();
    }
}
