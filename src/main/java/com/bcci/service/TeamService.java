package com.bcci.service;

import java.util.List;

import com.bcci.entity.Team;

public interface TeamService {

	public Team saveTeam(Team team);
	public List<Team> getAllTeams();
	public Team getTeamById(Long id);
	public void deleteTeam(Long id);
       
	
}
