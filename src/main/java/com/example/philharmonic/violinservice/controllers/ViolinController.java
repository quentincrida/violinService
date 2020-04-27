package com.example.philharmonic.violinservice.controllers;

import com.example.philharmonic.violinservice.models.Violin;
import com.example.philharmonic.violinservice.repositories.ViolinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value= "violins/first_name")
    public void getViolinsByName(String firstName){ this.violinRepository.findAll();}

    @PostMapping(value = "/violins")
    public ResponseEntity<Violin> postViolin(@RequestBody Violin violin){
        violinRepository.save(violin);
        return new ResponseEntity<>(violin, HttpStatus.CREATED);
    }
   }


