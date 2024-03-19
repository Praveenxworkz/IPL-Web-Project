package com.bcci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcci.entity.Innings;

@Repository
public interface InningsRepository extends JpaRepository<Innings, Long>{

}
