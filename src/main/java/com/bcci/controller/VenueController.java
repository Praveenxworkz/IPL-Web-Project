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

import com.bcci.entity.Venue;
import com.bcci.service.VenueService;

@RestController
@RequestMapping("/venues")
public class VenueController {

	@Autowired
	private VenueService venueService;

	@GetMapping
	public ResponseEntity<List<Venue>> getAllVenues() {
		List<Venue> venues = venueService.getAllVenues();
		return new ResponseEntity<>(venues, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
		Venue venue = venueService.getVenueById(id);
		return new ResponseEntity<>(venue, venue != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
		Venue savedVenue = venueService.saveVenue(venue);
		return new ResponseEntity<>(savedVenue, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
		venue.setId(id);
		Venue updatedVenue = venueService.saveVenue(venue);
		return new ResponseEntity<>(updatedVenue, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
		venueService.deleteVenue(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
