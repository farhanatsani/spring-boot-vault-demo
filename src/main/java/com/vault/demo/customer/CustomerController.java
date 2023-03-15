package com.vault.demo.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @GetMapping
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("hello");
    }
}
