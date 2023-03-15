package com.vault.demo.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerDTO customer) {
        customerService.registerCustomer(customer);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomer(id));
    }

}
