package com.bcci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcci.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
