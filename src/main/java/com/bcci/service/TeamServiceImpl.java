package com.bcci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcci.entity.Team;
import com.bcci.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{

	
	
	    
	    @Autowired
	    private TeamRepository teamRepository;

	    public List<Team> getAllTeams() {
	        return teamRepository.findAll();
	    }

	    public Team getTeamById(Long id) {
	        return teamRepository.findById(id).orElse(null);
	    }

	    public Team saveTeam(Team team) {
	        return teamRepository.save(team);
	    }

	    public void deleteTeam(Long id) {
	        teamRepository.deleteById(id);
	    }
	

	
}
