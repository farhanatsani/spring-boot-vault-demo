package com.vault.demo.customer.jasypt;

public class CustomerJasyptMapper {
    public static CustomerJasypt toCustomer(CustomerJasyptDTO customerJasyptDTO) {
        return CustomerJasypt.builder()
                .name(customerJasyptDTO.getName())
                .phoneNo(customerJasyptDTO.getPhoneNo())
                .nik(customerJasyptDTO.getNik())
                .address(customerJasyptDTO.getAddress())
                .build();
    }
    public static CustomerJasyptDTO toCustomerDTO(CustomerJasypt customerJasypt) {
        return CustomerJasyptDTO.builder()
                .id(customerJasypt.getId())
                .name(customerJasypt.getName())
                .phoneNo(customerJasypt.getPhoneNo())
                .nik(customerJasypt.getNik())
                .address(customerJasypt.getAddress())
                .build();
    }
}
