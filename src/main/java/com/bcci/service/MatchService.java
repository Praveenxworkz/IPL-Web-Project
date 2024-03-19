package com.bcci.service;

import java.util.List;

import com.bcci.entity.Match;

public interface MatchService {

	public List<Match> getAllMatches();

	public Match getMatchById(Long id);

	public Match saveMatch(Match match);

	public void deleteMatch(Long id);

}
