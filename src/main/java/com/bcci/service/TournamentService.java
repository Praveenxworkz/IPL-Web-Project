package com.bcci.service;

import java.util.List;

import com.bcci.entity.Tournament;

public interface TournamentService {

	public List<Tournament> getAllTournaments();

	public Tournament getTournamentById(Long id);

	public Tournament saveTournament(Tournament tournament);

	public void deleteTournament(Long id);

}
