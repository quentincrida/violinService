package com.example.philharmonic.violinservice.repositories;

import com.example.philharmonic.violinservice.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

}
