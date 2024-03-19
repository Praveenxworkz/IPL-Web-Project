package com.bcci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcci.entity.Innings;
import com.bcci.repository.InningsRepository;

@Service
public class InningsServiceImpl implements InningsService {

	@Autowired
	private InningsRepository inningsRepository;

	public List<Innings> getAllInnings() {
		return inningsRepository.findAll();
	}

	public Innings getInningsById(Long id) {
		return inningsRepository.findById(id).orElse(null);
	}

	public Innings saveInnings(Innings innings) {
		return inningsRepository.save(innings);
	}

	public void deleteInnings(Long id) {
		inningsRepository.deleteById(id);
	}

}
