package com.bcci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcci.entity.Venue;
import com.bcci.repository.VenueRepository;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueRepository venueRepository;

	public List<Venue> getAllVenues() {
		return venueRepository.findAll();
	}

	public Venue getVenueById(Long id) {
		return venueRepository.findById(id).orElse(null);
	}

	public Venue saveVenue(Venue venue) {
		return venueRepository.save(venue);
	}

	public void deleteVenue(Long id) {
		venueRepository.deleteById(id);
	}

}
