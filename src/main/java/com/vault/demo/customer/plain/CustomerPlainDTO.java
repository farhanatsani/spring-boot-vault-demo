package com.vault.demo.customer.plain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @Builder
public class CustomerPlainDTO {
    private UUID id;
    private String name;
    private String phoneNo;
    private String nik;
    private String address;
}
