package com.vault.demo.customer.vault;

import com.vault.demo.vault.VaultService;

public class CustomerVaultMapper {
    public static CustomerVault toCustomer(CustomerVaultDTO customerVaultDTO, VaultService vaultService) {
        return CustomerVault.builder()
                .name(customerVaultDTO.getName())
                .phoneNo(vaultService.encrypt(customerVaultDTO.getPhoneNo()))
                .nik(vaultService.encrypt(customerVaultDTO.getNik()))
                .address(customerVaultDTO.getAddress())
                .build();
    }
    public static CustomerVaultDTO toCustomerDTO(CustomerVault customerVault, VaultService vaultService) {
        return CustomerVaultDTO.builder()
                .id(customerVault.getId())
                .name(customerVault.getName())
                .phoneNo(vaultService.decrypt(customerVault.getPhoneNo()))
                .nik(vaultService.decrypt(customerVault.getNik()))
                .address(customerVault.getAddress())
                .build();
    }
}
