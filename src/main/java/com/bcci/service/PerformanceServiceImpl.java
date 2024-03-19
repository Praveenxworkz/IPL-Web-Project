package com.bcci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcci.entity.Performance;
import com.bcci.repository.PerformanceRepository;

@Service
public class PerformanceServiceImpl implements PerformanceService {

	@Autowired
	private PerformanceRepository performanceRepository;

	public List<Performance> getAllPerformances() {
		return performanceRepository.findAll();
	}

	public Performance getPerformanceById(Long id) {
		return performanceRepository.findById(id).orElse(null);
	}

	public Performance savePerformance(Performance performance) {
		return performanceRepository.save(performance);
	}

	public void deletePerformance(Long id) {
		performanceRepository.deleteById(id);
	}

}
