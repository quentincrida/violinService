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
//responseEntity allows me to specify status code,
// and getAllViolins will take a payload of type List<Violin>.
    //HttpStatus.OK = code 200
    @GetMapping(value = "/violins")
    public ResponseEntity<List<Violin>> getAllViolins(){
        return new ResponseEntity<>(violinRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/violins/{id}")
    public ResponseEntity getViolin(@PathVariable Long id){
            return new ResponseEntity<>(violinRepository.findById(id), HttpStatus.OK);
        }

    @GetMapping(value= "violins/first_name")
    public void getViolinsByName(String firstName){ this.violinRepository.findAll();}

   @PostMapping(value = "/violins")
    public ResponseEntity<Violin> createViolin (@RequestBody Violin violin){
        violinRepository.save(violin);
        return new ResponseEntity<>(violin, HttpStatus.CREATED);
   }
   }


