package com.vault.demo;

import com.vault.demo.vault.VaultService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.vault.support.Hmac;

@SpringBootTest
class SpringBootVaultDemoApplicationTests {

	@Autowired
	private VaultService vaultService;

	@Test
	void contextLoads() {
		String nik = "123456789";
		String encryptedNik = vaultService.encrypt(nik);
		Assertions.assertNotNull(encryptedNik);

		System.out.println("Encrypted : " + encryptedNik);

		String decryptedNik = vaultService.decrypt(encryptedNik);
		System.out.println("Decrypted : " + decryptedNik);
	}

	@Test
	void getHmacTest() {
		Hmac hmac = vaultService.getHmac();
		System.out.println(hmac.getHmac());
	}

}
