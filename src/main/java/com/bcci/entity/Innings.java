package com.bcci.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "innings")
public class Innings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "match_id")
	private Match match;

	@ManyToOne
	@JoinColumn(name = "batting_team_id")
	private Team battingTeam;

	@ManyToOne
	@JoinColumn(name = "bowling_team_id")
	private Team bowlingTeam;

	@Column(name = "total_runs")
	private int totalRuns;

	@Column(name = "total_wickets")
	private int totalWickets;

	private int extras;
	private String result;

}
