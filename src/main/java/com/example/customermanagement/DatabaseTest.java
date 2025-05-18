package com.example.customermanagement;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DatabaseTest implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        //  Creating a new Customer


        //  Fetching all Customers
        List<Customer> customers = customerService.getAllCustomers();

        //  Print each Customer's name
        System.out.println("---- Customer List ----");
        customers.forEach(c -> System.out.println(c.getName()));
        System.out.println("-----------------------");
    }
}
