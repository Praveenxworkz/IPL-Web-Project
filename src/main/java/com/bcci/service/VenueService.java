package com.bcci.service;

import java.util.List;

import com.bcci.entity.Venue;

public interface VenueService {

	public List<Venue> getAllVenues();

	public Venue getVenueById(Long id);

	public Venue saveVenue(Venue venue);

	public void deleteVenue(Long id);

}
