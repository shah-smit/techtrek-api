package com.techtrek.customerservice.customer_resource;

import com.techtrek.customerservice.customer.Customer;
import com.techtrek.customerservice.customer.CustomerProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private CustomerProfileService customerProfileService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerProfileService.getCustomer();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable String customerId) {
        return customerProfileService.getCustomer(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) {
        customerProfileService.addCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        customerProfileService.updateCustomer(customerId, customer);
    }
}
