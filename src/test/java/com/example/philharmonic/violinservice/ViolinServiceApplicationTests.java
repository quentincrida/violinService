package com.example.philharmonic.violinservice;

import com.example.philharmonic.violinservice.models.Tutti;
import com.example.philharmonic.violinservice.models.Violin;
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

    @Test
    public void contextLoads(){}

    @Test
    public void createViolinAndTutti(){
        Tutti tutti = new Tutti("Firsts");
        tutti.setId(1L);
        tuttiRepository.save(tutti);

        Violin violinist = new Violin("Johnny", "Walker", 25, tutti);
        tutti.setId(1L);
        violinRepository.save(violinist);
    }
}
