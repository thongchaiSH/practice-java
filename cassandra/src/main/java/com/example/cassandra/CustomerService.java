package com.example.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> retrieveCustomers() {
        return (List<Customer>) repository.findAll();
    }

    public Optional<Customer> retrieveCustomers(UUID id) {
        return repository.findById(id);
    }

    public List<Customer> retrieveCustomersByName(String name) {
        return repository.findByFirstName(name);
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> updateCustomer(UUID id, Customer customer) {
        Optional<Customer> customerOpt = repository.findById(id);
        if(!customerOpt.isPresent()) {
            return customerOpt;
        }
        customer.setId(id);
        return Optional.of(repository.save(customer));
    }

    public boolean deleteCustomer(UUID id) {
        try {
            repository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
