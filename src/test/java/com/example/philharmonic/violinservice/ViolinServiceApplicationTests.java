package com.example.philharmonic.violinservice;

import com.example.philharmonic.violinservice.models.Symphony;
import com.example.philharmonic.violinservice.models.Tutti;
import com.example.philharmonic.violinservice.models.Violin;
import com.example.philharmonic.violinservice.repositories.SymphonyRepository;
import com.example.philharmonic.violinservice.repositories.TuttiRepository;
import com.example.philharmonic.violinservice.repositories.ViolinRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class ViolinServiceApplicationTests {
    @Autowired
    TuttiRepository tuttiRepository;

    @Autowired
    ViolinRepository violinRepository;

    @Autowired
    SymphonyRepository symphonyRepository;

    @Test
    public void contextLoads(){}

    @Test
    public void createViolinAndTutti(){
        Tutti tutti = new Tutti("Firsts");
       // tutti.setId(1L);
        tuttiRepository.save(tutti);

        Violin violinist = new Violin("Johnny", "Walker", 25, tutti);
       // tutti.setId(1L);
        violinRepository.save(violinist);
    }

    @Test
    public void addViolinsToSymphonies(){
        Tutti tutti = new Tutti("Firsts");
        tuttiRepository.save(tutti);
        Violin leader = new Violin("Jurgs", "Schwietering", 28, tutti);
        violinRepository.save(leader);
        Symphony symphony = new Symphony("Beethoven", 131);
        symphonyRepository.save(symphony);

        Tutti tutti2 = new Tutti("Seconds");
        tuttiRepository.save(tutti2);
        Violin violin2 = new Violin("Wendy", "Schwietering", 6, tutti2);
        violinRepository.save(violin2);
        Symphony symphony2 = new Symphony("Mozart", 14);
        symphonyRepository.save(symphony2);


        Tutti tutti3 = new Tutti("Firsts");
        tuttiRepository.save(tutti3);
        Violin violin3 = new Violin("Simos", "Aering", 30, tutti3);
        violinRepository.save(violin3);
        Symphony symphony3 = new Symphony("Shostakovich", 150);
        symphonyRepository.save(symphony3);



        symphony.addViolin(leader);
        symphony.addViolin(violin2);
        symphony.addViolin(violin3);
    }
    @Test
    public void canFindViolinsOver43(){
        List<Violin> found = violinRepository.findViolinsByAgeGreaterThan(43);
        assertEquals(3, found.size());
    }
    @Test
    public void findSymphoniesByComposer(){
        List<Symphony> found = symphonyRepository.findSymphoniesByComposer("Beethoven");
        assertEquals("Beethoven", found.get(0).getComposer());
    }
    @Test
    public void findViolinsInSymphonyId(){
        List<Violin> foundViolins = violinRepository.findBySymphoniesId(5L);
        assertEquals(2, foundViolins.size());
        assertEquals("Martens", foundViolins.get(1).getLastName());
        assertEquals("Emile", foundViolins.get(0).getFirstName());
    }
    @Test
    public void canFindTuttisWithViolinsFirstName(){
        List<Tutti> foundTuttis = tuttiRepository.findByViolinsFirstName("Este");
        assertEquals("First Violins", foundTuttis.get(0).getName());
    }

//    Find all Symphonies for a given Tutti
    @Test
    public void canFindAllSymphoniesForAGivenTutti(){
       Tutti foundTutti = tuttiRepository.getOne(2L);
        List<Symphony> foundSymphonies = symphonyRepository.findByViolinsTutti(foundTutti);
        assertEquals(3,foundSymphonies.size());

    }
}
