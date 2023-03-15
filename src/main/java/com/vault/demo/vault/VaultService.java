package com.vault.demo.vault;

import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.core.VaultTransitOperations;
import org.springframework.vault.support.Hmac;
import org.springframework.vault.support.Plaintext;
import org.springframework.vault.support.VaultHmacRequest;
import org.springframework.vault.support.VaultTransitKeyCreationRequest;

@Service
public class VaultService {
    private static final String KEY_TYPE = "aes256-gcm96";
    private static final String KEY_NAME_ENCRYPT_STRING = "key_ktp";
    private VaultTransitOperations vaultTransit;
    public VaultService(VaultOperations vaultOperations) {
        vaultTransit = vaultOperations.opsForTransit();
//        vaultTransit.createKey(KEY_NAME_ENCRYPT_STRING,
//                VaultTransitKeyCreationRequest.ofKeyType(KEY_TYPE));
    }
    public String encrypt(String plainText) {
        return vaultTransit.encrypt(KEY_NAME_ENCRYPT_STRING, plainText);
    }
    public String decrypt(String cipherText) {
        return vaultTransit.decrypt(KEY_NAME_ENCRYPT_STRING, cipherText);
    }
}
