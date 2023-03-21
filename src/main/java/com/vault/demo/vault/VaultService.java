package com.vault.demo.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultTransitOperations;

@Service
public class VaultService {
    @Value("${vault.transit.key}")
    private String keyName;
    private VaultTransitOperations vaultTransit;
    public VaultService(VaultOperations vaultOperations) {
        vaultTransit = vaultOperations.opsForTransit();
    }
    public String encrypt(String plainText) {
        return vaultTransit.encrypt(keyName, plainText);
    }
    public String decrypt(String cipherText) {
        return vaultTransit.decrypt(keyName, cipherText);
    }
}
