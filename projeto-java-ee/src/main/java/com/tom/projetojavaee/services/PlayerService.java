package com.tom.projetojavaee.services;

import java.util.List;

import com.tom.projetojavaee.domain.Player;
import com.tom.projetojavaee.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> listPlayers() {
        return playerRepository.findAllPlayers();
    }

    
}
