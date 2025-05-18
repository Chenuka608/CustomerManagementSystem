package com.example.customermanagement.controller;

import com.example.customermanagement.model.MasterData;
import com.example.customermanagement.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master-data")
@CrossOrigin(origins = "*")
public class MasterDataController {

    @Autowired
    private MasterDataService masterDataService;

    // ➡️ Get all cities
    @GetMapping("/cities")
    public List<MasterData> getCities() {
        return masterDataService.getCities();
    }

    // ➡️ Get all countries
    @GetMapping("/countries")
    public List<MasterData> getCountries() {
        return masterDataService.getCountries();
    }
}
