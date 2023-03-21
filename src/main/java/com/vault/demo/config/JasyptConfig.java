package com.vault.demo.config;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.hibernate5.encryptor.HibernatePBEEncryptorRegistry;
import org.jasypt.iv.RandomIvGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
    public JasyptConfig() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(4);
        encryptor.setPassword("MY-PASSPASSPASS123");
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        encryptor.setIvGenerator(new RandomIvGenerator());
        encryptor.setKeyObtentionIterations(1500);

        HibernatePBEEncryptorRegistry registry = HibernatePBEEncryptorRegistry.getInstance();
        registry.registerPBEStringEncryptor("myStringEncryptor", encryptor);
    }
}
