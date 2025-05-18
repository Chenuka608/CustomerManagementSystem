package com.example.customermanagement.service;

import com.example.customermanagement.model.MasterData;
import com.example.customermanagement.repository.MasterDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDataService {

    @Autowired
    private MasterDataRepository masterDataRepository;

    public List<MasterData> getCities() {
        return masterDataRepository.findByType("City");
    }

    public List<MasterData> getCountries() {
        return masterDataRepository.findByType("Country");
    }
}
