package com.example.philharmonic.violinservice.controllers;

import com.example.philharmonic.violinservice.models.Violin;
import com.example.philharmonic.violinservice.repositories.ViolinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

public class ViolinController {
    @Autowired
    ViolinRepository violinRepository;

    @GetMapping(value = "/violins")
    public List<Violin> getAllViolins(){
        return violinRepository.findAll();
    }

    @GetMapping(value = "/violins/{id}")
    public Optional<Violin> getViolin(@PathVariable Long id){
            return violinRepository.findById(id);
        }
    }


