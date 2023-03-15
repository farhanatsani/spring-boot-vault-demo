package com.vault.demo.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private String phoneNo;
    private String nik;
    private String address;
}
