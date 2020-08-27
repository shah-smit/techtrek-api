package com.techtrek.customerservice.customer_resource;

import com.techtrek.customerservice.customer.Customer;
import com.techtrek.customerservice.customer.CustomerProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private CustomerProfileService customerProfileService;

    @GetMapping
    @PreAuthorize("hasAuthority('customer:read:all')")
    public List<Customer> getCustomers() {
        return customerProfileService.getCustomer();
    }

    @GetMapping("/{customerId}")
    @PreAuthorize("hasAuthority('customer:read')")
    public Customer getCustomer(@PathVariable String customerId) {
        return customerProfileService.getCustomer(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('customer:write')")
    public void addCustomer(@RequestBody Customer customer) {
        customerProfileService.addCustomer(customer);
    }

    @PutMapping("/{customerId}")
    @PreAuthorize("hasAuthority('customer:write')")
    public void updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        customerProfileService.updateCustomer(customerId, customer);
    }
}
