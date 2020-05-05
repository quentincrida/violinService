package com.example.philharmonic.violinservice.repositories;

import com.example.philharmonic.violinservice.models.Symphony;
import com.example.philharmonic.violinservice.models.Tutti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SymphonyRepository extends JpaRepository<Symphony, Long> {
    List<Symphony> findSymphoniesByComposer(String composer);

    //Find all Symphonies for a given Tutti
    List<Symphony> findByViolinsTutti(Tutti tutti);

    List<Symphony> findSymphoniesByOpus(int opus);


}
