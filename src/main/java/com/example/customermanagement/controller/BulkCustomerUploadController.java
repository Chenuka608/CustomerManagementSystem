package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.BulkCustomerUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/bulk-upload")
@CrossOrigin(origins = "*")
public class BulkCustomerUploadController {

    @Autowired
    private BulkCustomerUploadService bulkCustomerUploadService;

    // ➡️ Upload bulk customers via Excel
    @PostMapping
    public List<Customer> uploadCustomers(@RequestParam("file") MultipartFile file) {
        return bulkCustomerUploadService.uploadCustomers(file);
    }
}
