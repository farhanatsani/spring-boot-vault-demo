package com.vault.demo.customer.vault;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerVaultRepository extends JpaRepository<CustomerVault, UUID> {

}
