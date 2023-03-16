package com.vault.demo.customer.s1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/s1/customers")
public class S1_CustomerController {
    private S1_CustomerService s1CustomerService;
    public S1_CustomerController(S1_CustomerService s1CustomerService) {
        this.s1CustomerService = s1CustomerService;
    }
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody S1_CustomerDTO customer) {
        s1CustomerService.saveCustomer(customer);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable UUID id) {
        S1_CustomerDTO customerDTO = s1CustomerService.findCustomer(id);
        return ResponseEntity.ok(customerDTO);
    }

}
