package customer_service;

import customer_service.entity.Customer;
import customer_service.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping
    public Customer addCustomer(
            @RequestBody Customer customer){

        return repository.save(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(
            @PathVariable String id){

        return repository.findById(id)
                .orElse(null);
    }
}
