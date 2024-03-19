package com.bcci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcci.entity.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long>{

}
