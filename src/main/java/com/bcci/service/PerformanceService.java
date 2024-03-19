package com.bcci.service;

import java.util.List;

import com.bcci.entity.Performance;

public interface PerformanceService {

	public List<Performance> getAllPerformances();

	public Performance getPerformanceById(Long id);

	public Performance savePerformance(Performance performance);

	public void deletePerformance(Long id);

}
