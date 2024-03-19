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

import com.bcci.entity.Performance;
import com.bcci.service.PerformanceService;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

	@Autowired
	private PerformanceService performanceService;

	@GetMapping
	public ResponseEntity<List<Performance>> getAllPerformances() {
		List<Performance> performances = performanceService.getAllPerformances();
		return new ResponseEntity<>(performances, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Performance> getPerformanceById(@PathVariable Long id) {
		Performance performance = performanceService.getPerformanceById(id);
		return new ResponseEntity<>(performance, performance != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Performance> createPerformance(@RequestBody Performance performance) {
		Performance savedPerformance = performanceService.savePerformance(performance);
		return new ResponseEntity<>(savedPerformance, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Performance> updatePerformance(@PathVariable Long id, @RequestBody Performance performance) {
		performance.setId(id);
		Performance updatedPerformance = performanceService.savePerformance(performance);
		return new ResponseEntity<>(updatedPerformance, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePerformance(@PathVariable Long id) {
		performanceService.deletePerformance(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
