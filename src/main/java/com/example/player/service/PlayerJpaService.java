package com.example.player.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.player.repository.PlayerRepository;
import com.example.player.repository.*;
import com.example.player.model.*;

@Service
public class PlayerJpaService implements PlayerRepository{
    
    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    public ArrayList<Player>getPlayersList(){
        List<Player>players=playerJpaRepository.findAll();

		ArrayList<Player>playerList=new ArrayList<>(players);

		return playerList;

    }

	@Override
	public Player addPlayer(Player player) {
		playerJpaRepository.save(player);
		return player;
	}

	@Override
	public Player getPlayer(int playerId) {
		try{

			Player player=playerJpaRepository.findById(playerId).get();
			return player;

		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Player updatePlayer(int playerId,Player player) {
		
		try{
			Player newPlayer=playerJpaRepository.findById(playerId).get();
			if(player.getplayerName()!=null){
				newPlayer.setplayerName(player.getplayerName());
			}
			if(player.getjerseyNumber()!=0){
				newPlayer.setjerseyNumber(player.getjerseyNumber());
			}
			if(player.getrole()!=null){
				newPlayer.setrole(player.getrole());
			}

			playerJpaRepository.save(newPlayer);
			return newPlayer;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deletePlayer(int playerId) {
		try{
				playerJpaRepository.deleteById(playerId);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}    



}