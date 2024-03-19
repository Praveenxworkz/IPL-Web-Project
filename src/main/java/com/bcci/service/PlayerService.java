package com.bcci.service;

import java.util.List;

import com.bcci.entity.Player;

public interface PlayerService {

	public List<Player> getAllPlayers();
	public Player getPlayerById(Long id);
	public Player savePlayer(Player player);
	 public void deletePlayer(Long id);
	
}
