package com.example.philharmonic.violinservice.controllers;

import com.example.philharmonic.violinservice.models.Symphony;
import com.example.philharmonic.violinservice.models.Violin;
import com.example.philharmonic.violinservice.repositories.SymphonyRepository;
import com.example.philharmonic.violinservice.repositories.ViolinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SymphonyController {
    @Autowired
    SymphonyRepository symphonyRepository;
    @Autowired
    ViolinRepository violinRepository;

//refactored to accommodate second route
//    @GetMapping(value="/symphonies")
//    public ResponseEntity<List<Symphony>> getAllSymphonies(){ return new ResponseEntity<>(symphonyRepository.findAll(), HttpStatus.OK);}

//already /symphonies route being used, so has to be altered to accommodate two routes: Symphony and by Composer filter
@GetMapping(value = "/symphonies")
public ResponseEntity<List<Symphony>> findSymphoniesByComposerQueryString(
        @RequestParam(name="composer", required = false) String composer) {
    if (composer != null) {
        return new ResponseEntity<>(symphonyRepository.findSymphoniesByComposer(composer), HttpStatus.OK);
    }
    return new ResponseEntity<>(symphonyRepository.findAll(), HttpStatus.OK);
}
    @GetMapping(value = "/symphonies/{id}")
    public ResponseEntity getSymphonies(@PathVariable Long id) { return new ResponseEntity<>(symphonyRepository.findById(id), HttpStatus.OK);}

    @PostMapping(value = "/symphonies")
    public ResponseEntity<Symphony> createSymphony(@RequestBody Symphony symphony){
        symphonyRepository.save(symphony);
        return new ResponseEntity<>(symphony, HttpStatus.CREATED);
    }
    @PatchMapping(value = "/symphonies/{id}")
    public ResponseEntity<Symphony> setSymphony(@RequestBody Symphony symphony, @PathVariable Long id){
        symphonyRepository.save(symphony);
        return new ResponseEntity<>(symphony, HttpStatus.CREATED);
    }
    @GetMapping(value = "/symphonies/opus/{opus}")
    public List<Symphony> getSymphonyByOpusNumber(@PathVariable int opus){
        return symphonyRepository.findSymphoniesByOpus(opus);
    }
//    get violins of specific age in symphonies by Id
//    @GetMapping(value = "/symphonies/{id}/violins/age/{age}")
//    public List<Violin> getViolinsInSymphoniesByAge(@PathVariable Long symphony_id, @PathVariable int age) {
//        return violinRepository.getViolinBySymphonyIdAndAge(symphony_id, age);
//    }
}