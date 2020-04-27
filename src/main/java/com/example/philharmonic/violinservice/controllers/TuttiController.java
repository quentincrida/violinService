package com.example.philharmonic.violinservice.controllers;

import com.example.philharmonic.violinservice.models.Tutti;
import com.example.philharmonic.violinservice.repositories.TuttiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Tutti>> getAllTuttis(){return new ResponseEntity<>( tuttiRepository.findAll(),HttpStatus.OK);}

    @GetMapping(value = "tuttis/{id}")
    public ResponseEntity getTutti(@PathVariable Long id){ return new ResponseEntity(tuttiRepository.findById(id), HttpStatus.OK );}
}
