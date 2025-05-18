package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BulkCustomerUploadService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> uploadCustomers(MultipartFile file) {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            customers = br.lines().skip(1).map(line -> {
                String[] data = line.split(",");
                Customer customer = new Customer();
                customer.setName(data[0]);
                customer.setDateOfBirth(java.time.LocalDate.parse(data[1]));
                customer.setNicNumber(data[2]);
                customer.setMobileNumbers(List.of(data[3].split(";")));
                // Optional: You can also parse addresses and family members here if they are part of the CSV
                return customer;
            }).collect(Collectors.toList());

            customerRepository.saveAll(customers);

        } catch (Exception e) {
            throw new RuntimeException("Failed to upload customers: " + e.getMessage());
        }
        return customers;
    }
}
