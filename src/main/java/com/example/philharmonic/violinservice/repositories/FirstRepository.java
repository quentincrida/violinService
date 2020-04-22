package com.example.philharmonic.violinservice.repositories;

import com.example.philharmonic.violinservice.models.First;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstRepository extends JpaRepository<First, Long> {

}
