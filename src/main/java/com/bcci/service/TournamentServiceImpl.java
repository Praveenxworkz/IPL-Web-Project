package com.bcci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcci.entity.Tournament;
import com.bcci.repository.TournamentRepository;

@Service
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	private TournamentRepository tournamentRepository;

	public List<Tournament> getAllTournaments() {
		return tournamentRepository.findAll();
	}

	public Tournament getTournamentById(Long id) {
		return tournamentRepository.findById(id).orElse(null);
	}

	public Tournament saveTournament(Tournament tournament) {
		return tournamentRepository.save(tournament);
	}

	public void deleteTournament(Long id) {
		tournamentRepository.deleteById(id);
	}

}
