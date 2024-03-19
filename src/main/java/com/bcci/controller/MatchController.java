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

import com.bcci.entity.Match;
import com.bcci.service.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchController {

	@Autowired
	private MatchService matchService;

	@GetMapping
	public ResponseEntity<List<Match>> getAllMatches() {
		List<Match> matches = matchService.getAllMatches();
		return new ResponseEntity<>(matches, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
		Match match = matchService.getMatchById(id);
		return new ResponseEntity<>(match, match != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Match> createMatch(@RequestBody Match match) {
		Match savedMatch = matchService.saveMatch(match);
		return new ResponseEntity<>(savedMatch, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
		match.setId(id);
		Match updatedMatch = matchService.saveMatch(match);
		return new ResponseEntity<>(updatedMatch, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
		matchService.deleteMatch(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
