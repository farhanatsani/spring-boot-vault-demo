package com.vault.demo.customer.plain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/plain/customers")
public class CustomerPlainController {
    private CustomerPlainService customerPlainService;
    public CustomerPlainController(CustomerPlainService customerPlainService) {
        this.customerPlainService = customerPlainService;
    }
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerPlainDTO customer) {
        customerPlainService.saveCustomer(customer);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable UUID id) {
        CustomerPlainDTO customerPlainDTO = customerPlainService.findCustomer(id);
        return ResponseEntity.ok(customerPlainDTO);
    }

}
