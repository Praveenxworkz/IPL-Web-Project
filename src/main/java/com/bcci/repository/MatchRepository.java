package com.bcci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcci.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{

}
