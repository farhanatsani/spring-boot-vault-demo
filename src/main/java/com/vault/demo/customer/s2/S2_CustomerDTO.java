package com.vault.demo.customer.s2;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @Builder @JsonInclude(JsonInclude.Include.NON_NULL)
public class S2_CustomerDTO {
    private UUID id;
    private String name;
    private String symmetricKey;
    private String encryptedPhoneNo;
    private String encryptedNik;
    private String address;
}
