package com.example.philharmonic.violinservice;

import com.example.philharmonic.violinservice.models.Section;
import com.example.philharmonic.violinservice.models.Violin;
import com.example.philharmonic.violinservice.repositories.SectionRepository;
import com.example.philharmonic.violinservice.repositories.ViolinRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class ViolinServiceApplicationTests {
    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    ViolinRepository violinRepository;

    @Test
    public void contextLoads(){}

    @Test
    public void createViolinAndSection(){
        Section section = new Section("Firsts");
        sectionRepository.save(section);

        Violin violinist = new Violin("Johnny", "Walker", 25, section);
        violinRepository.save(violinist);
    }
}
