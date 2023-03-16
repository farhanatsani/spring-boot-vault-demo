package com.vault.demo.customer.s1;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @Builder
public class S1_CustomerDTO {
    private UUID id;
    private String name;
    private String encryptedPhoneNo;
    private String encryptedNik;
    private String address;
}
