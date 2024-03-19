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
@Table(name = "performance")
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	@ManyToOne
	@JoinColumn(name = "match_id")
	private Match match;

	@Column(name = "runs_scored")
	private int runsScored;

	@Column(name = "wickets_taken")
	private int wicketsTaken;

	@Column(name = "catches_taken")
	private int catchesTaken;

	@Column(name = "innings_played")
	private int inningsPlayed;

	@Column(name = "batting_position")
	private int battingPosition;

	@Column(name = "bowling_style")
	private String bowlingStyle;

}
