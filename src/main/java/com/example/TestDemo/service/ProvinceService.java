/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TestDemo.service;

import com.example.TestDemo.model.Address;
import com.example.TestDemo.repsitory.ProvinceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEVELOPER
 */
@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepo;
    
    public List<Address> findAll(){
        return provinceRepo.findAll();
    }
}
