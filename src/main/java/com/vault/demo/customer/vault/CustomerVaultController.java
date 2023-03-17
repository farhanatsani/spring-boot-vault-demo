package com.vault.demo.customer.vault;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/vault/customers")
public class CustomerVaultController {
    private CustomerVaultService s1CustomerVaultService;
    public CustomerVaultController(CustomerVaultService s1CustomerVaultService) {
        this.s1CustomerVaultService = s1CustomerVaultService;
    }
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerVaultDTO customer) {
        s1CustomerVaultService.saveCustomer(customer);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable UUID id) {
        CustomerVaultDTO customerVaultDTO = s1CustomerVaultService.findCustomer(id);
        return ResponseEntity.ok(customerVaultDTO);
    }

}
