package com.example.philharmonic.violinservice.repositories;

import com.example.philharmonic.violinservice.models.Violin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViolinRepository extends JpaRepository<Violin, Long> {

    List<Violin> findViolinsByAgeGreaterThan(int age);

    List<Violin> findBySymphoniesId(Long id);

    List<Violin> findViolinsByFirstName(String firstName);


}
