package com.vault.demo.jasypt.vault;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/s1/customers")
public class CustomerController {
    private CustomerService s1CustomerService;
    public CustomerController(CustomerService s1CustomerService) {
        this.s1CustomerService = s1CustomerService;
    }
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customer) {
        s1CustomerService.saveCustomer(customer);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable UUID id) {
        CustomerDTO customerDTO = s1CustomerService.findCustomer(id);
        return ResponseEntity.ok(customerDTO);
    }

}
