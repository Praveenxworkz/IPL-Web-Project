package com.bcci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcci.entity.Player;
import com.bcci.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	public Player getPlayerById(Long id) {
		return playerRepository.findById(id).orElse(null);
	}

	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}

	public void deletePlayer(Long id) {
		playerRepository.deleteById(id);
	}

}
