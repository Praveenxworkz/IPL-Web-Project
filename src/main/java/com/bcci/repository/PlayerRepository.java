package com.bcci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcci.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}
