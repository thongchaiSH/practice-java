package com.example.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CassandraRepository<Customer, UUID> {
    List<Customer> findByFirstName(String firstName);
}
