package com.example.philharmonic.violinservice.controllers;

import com.example.philharmonic.violinservice.models.Tutti;
import com.example.philharmonic.violinservice.repositories.TuttiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/tuttis")
    public ResponseEntity<Tutti> createTutti(@RequestBody Tutti tutti){
        tuttiRepository.save(tutti);
        return new ResponseEntity<>(tutti, HttpStatus.CREATED);
    }
    @PatchMapping(value = "/tuttis/{id}")
    public ResponseEntity<Tutti> setTutti(@RequestBody Tutti tutti, @PathVariable Long id){
        tuttiRepository.save(tutti);
        return new ResponseEntity<>(tutti, HttpStatus.CREATED);
    }
//    @GetMapping(value = "/tuttis/violins/named/{name}")
//    public List<Tutti> findByViolinsFirstName(@PathVariable String name){
//        return tuttiRepository.findByViolinsFirstName(name);
//    }

//    same as above, using @RequestParam
    @GetMapping(value = "/tuttis/violins")
    public ResponseEntity<List<Tutti>> findTuttisThatHaveViolinsNamedQueryString(
            @RequestParam(name="named") String name){
        return new ResponseEntity<>(tuttiRepository.findByViolinsFirstName(name), HttpStatus.OK);
    }



}
