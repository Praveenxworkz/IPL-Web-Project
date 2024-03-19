package com.bcci.service;

import java.util.List;

import com.bcci.entity.Innings;

public interface InningsService {

	public List<Innings> getAllInnings();

	public Innings getInningsById(Long id);

	public Innings saveInnings(Innings innings);

	public void deleteInnings(Long id);

}
