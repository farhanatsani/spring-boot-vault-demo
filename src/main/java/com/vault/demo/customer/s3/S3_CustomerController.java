package com.vault.demo.customer.s3;

import com.vault.demo.customer.s1.S1_CustomerService;
import com.vault.demo.customer.s1.S1_CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/s3/customers")
public class S3_CustomerController {
    private S1_CustomerService s1CustomerService;
    public S3_CustomerController(S1_CustomerService s1CustomerService) {
        this.s1CustomerService = s1CustomerService;
    }
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody S1_CustomerDTO customer) {
        s1CustomerService.saveCustomer(customer);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable UUID id) {
        return ResponseEntity.ok(s1CustomerService.findCustomer(id));
    }

}
