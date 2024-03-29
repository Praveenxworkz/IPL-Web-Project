package com.bcci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcci.entity.Match;
import com.bcci.repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepository;

	public List<Match> getAllMatches() {
		return matchRepository.findAll();
	}

	public Match getMatchById(Long id) {
		return matchRepository.findById(id).orElse(null);
	}

	public Match saveMatch(Match match) {
		return matchRepository.save(match);
	}

	public void deleteMatch(Long id) {
		matchRepository.deleteById(id);
	}

}
