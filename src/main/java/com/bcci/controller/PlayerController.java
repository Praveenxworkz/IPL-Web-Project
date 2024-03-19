package com.bcci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcci.entity.Player;
import com.bcci.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping
	public ResponseEntity<List<Player>> getAllPlayers() {
		List<Player> players = playerService.getAllPlayers();
		return new ResponseEntity<>(players, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
		Player player = playerService.getPlayerById(id);
		return new ResponseEntity<>(player, player != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
		Player savedPlayer = playerService.savePlayer(player);
		return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
		player.setId(id);
		Player updatedPlayer = playerService.savePlayer(player);
		return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
		playerService.deletePlayer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
