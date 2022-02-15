package com.tom.projetojavaee.controller;

import java.util.List;

import com.tom.projetojavaee.domain.Player;
import com.tom.projetojavaee.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "teste")
public class TesteController {
    
@Autowired
private PlayerService playerService;

//   teste/list-players
    @GetMapping(value = "/list-players")
    public List<Player> listPlayers(){
        
        return playerService.listPlayers();
    }
}
