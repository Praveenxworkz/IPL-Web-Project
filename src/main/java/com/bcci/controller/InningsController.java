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

import com.bcci.entity.Innings;
import com.bcci.service.InningsService;

@RestController
@RequestMapping("/innings")
public class InningsController {

	@Autowired
	private InningsService inningsService;

	@GetMapping
	public ResponseEntity<List<Innings>> getAllInnings() {
		List<Innings> innings = inningsService.getAllInnings();
		return new ResponseEntity<>(innings, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Innings> getInningsById(@PathVariable Long id) {
		Innings innings = inningsService.getInningsById(id);
		return new ResponseEntity<>(innings, innings != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Innings> createInnings(@RequestBody Innings innings) {
		Innings savedInnings = inningsService.saveInnings(innings);
		return new ResponseEntity<>(savedInnings, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Innings> updateInnings(@PathVariable Long id, @RequestBody Innings innings) {
		innings.setId(id);
		Innings updatedInnings = inningsService.saveInnings(innings);
		return new ResponseEntity<>(updatedInnings, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInnings(@PathVariable Long id) {
		inningsService.deleteInnings(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
