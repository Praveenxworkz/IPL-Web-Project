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

import com.bcci.entity.Tournament;
import com.bcci.service.TournamentService;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

	@Autowired
	private TournamentService tournamentService;

	@GetMapping
	public ResponseEntity<List<Tournament>> getAllTournaments() {
		List<Tournament> tournaments = tournamentService.getAllTournaments();
		return new ResponseEntity<>(tournaments, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
		Tournament tournament = tournamentService.getTournamentById(id);
		return new ResponseEntity<>(tournament, tournament != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
		Tournament savedTournament = tournamentService.saveTournament(tournament);
		return new ResponseEntity<>(savedTournament, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tournament> updateTournament(@PathVariable Long id, @RequestBody Tournament tournament) {
		tournament.setId(id);
		Tournament updatedTournament = tournamentService.saveTournament(tournament);
		return new ResponseEntity<>(updatedTournament, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
		tournamentService.deleteTournament(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
