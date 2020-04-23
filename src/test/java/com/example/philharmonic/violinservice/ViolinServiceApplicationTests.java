package com.example.philharmonic.violinservice;

import com.example.philharmonic.violinservice.models.Symphony;
import com.example.philharmonic.violinservice.models.Tutti;
import com.example.philharmonic.violinservice.models.Violin;
import com.example.philharmonic.violinservice.repositories.SymphonyRepository;
import com.example.philharmonic.violinservice.repositories.TuttiRepository;
import com.example.philharmonic.violinservice.repositories.ViolinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

       symphony.addViolin(leader);
    }
}
