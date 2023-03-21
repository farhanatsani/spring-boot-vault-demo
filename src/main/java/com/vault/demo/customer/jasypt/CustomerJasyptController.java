package com.vault.demo.customer.jasypt;

import com.vault.demo.customer.plain.CustomerPlainDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/jasypt/customers")
public class CustomerJasyptController {
    private CustomerJasyptService customerJasyptService;
    public CustomerJasyptController(CustomerJasyptService customerJasyptService) {
        this.customerJasyptService = customerJasyptService;
    }
    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerJasyptDTO customer) {
        customerJasyptService.saveCustomer(customer);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomer(@PathVariable UUID id) {
        CustomerJasyptDTO customerJasyptDTO = customerJasyptService.findCustomer(id);
        return ResponseEntity.ok(customerJasyptDTO);
    }
}
