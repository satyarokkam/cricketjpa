package com.example.player.repository;
import java.util.*;
import com.example.player.model.*;

public interface PlayerRepository{
    ArrayList<Player>getPlayersList();

    Player addPlayer(Player player);

    Player getPlayer(int playerId);

    Player updatePlayer(int playerId,Player player);

    void deletePlayer(int playerId);

}