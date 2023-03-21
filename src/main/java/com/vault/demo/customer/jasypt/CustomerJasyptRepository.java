package com.vault.demo.customer.jasypt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJasyptRepository extends JpaRepository<CustomerJasypt, UUID> {
}
