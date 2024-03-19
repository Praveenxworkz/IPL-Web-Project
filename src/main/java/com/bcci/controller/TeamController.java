package com.bcci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcci.entity.Team;
import com.bcci.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping
	public ResponseEntity<List<Team>> getAllTeams() {
		List<Team> teams = teamService.getAllTeams();
		return new ResponseEntity<>(teams, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
		Team team = teamService.getTeamById(id);
		return new ResponseEntity<>(team, team != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Team> createTeam(@RequestBody Team team) {
		Team savedTeam = teamService.saveTeam(team);
		return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team team) {
		team.setId(id);
		Team updatedTeam = teamService.saveTeam(team);
		return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
		teamService.deleteTeam(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
