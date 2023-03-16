package com.vault.demo.customer.s2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/s2/customers")
public class S2_CustomerController {
    private S2_CustomerService s2CustomerService;
    public S2_CustomerController(S2_CustomerService s1CustomerService) {
        this.s2CustomerService = s1CustomerService;
    }
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody S2_CustomerDTO customer) {
        s2CustomerService.saveCustomer(customer);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable UUID id) {
        S2_CustomerDTO customerDTO = s2CustomerService.findCustomer(id);
        return ResponseEntity.ok(customerDTO);
    }

}
