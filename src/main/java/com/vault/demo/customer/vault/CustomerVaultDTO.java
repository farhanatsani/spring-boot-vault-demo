package com.vault.demo.customer.vault;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @Builder
public class CustomerVaultDTO {
    private UUID id;
    private String name;
    private String phoneNo;
    private String nik;
    private String address;
}
