package com.example.philharmonic.violinservice.controllers;

import com.example.philharmonic.violinservice.models.Tutti;
import com.example.philharmonic.violinservice.repositories.TuttiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TuttiController {
    @Autowired
    TuttiRepository tuttiRepository;

    @GetMapping(value ="/tuttis")
    public List<Tutti> getAllTuttis(){return tuttiRepository.findAll();}

    @GetMapping(value = "tuttis/{id}")
    public Optional<Tutti> getTutti(@PathVariable Long id){ return tuttiRepository.findById(id);}
}
