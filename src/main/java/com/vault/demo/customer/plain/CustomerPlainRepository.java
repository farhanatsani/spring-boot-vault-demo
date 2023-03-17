package com.vault.demo.customer.plain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerPlainRepository extends JpaRepository<CustomerPlain, UUID> {

}
