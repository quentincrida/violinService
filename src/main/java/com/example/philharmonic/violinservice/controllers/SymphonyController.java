package com.example.philharmonic.violinservice.controllers;

import com.example.philharmonic.violinservice.models.Symphony;
import com.example.philharmonic.violinservice.repositories.SymphonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SymphonyController {
    @Autowired
    SymphonyRepository symphonyRepository;

    @GetMapping(value="/symphonies")
    public List<Symphony> getAllSymphonies(){ return symphonyRepository.findAll();}

    @GetMapping(value = "/symphonies/{id}")
    public Optional<Symphony> getSymphoniesById(@PathVariable Long id) { return symphonyRepository.findById(id);}

}
