package com.tom.projetojavaee.controller;

import java.util.List;

import com.tom.projetojavaee.domain.Player;
import com.tom.projetojavaee.domain.Team;
import com.tom.projetojavaee.services.PlayerService;
import com.tom.projetojavaee.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "teste")
public class TesteController {

    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private TeamService teamService;

    // teste/list-players
    @GetMapping(value = "/list-players")
    public List<Player> listPlayers() {

        return playerService.listPlayers();
    }

    // teste/list-players-name
    @GetMapping(value = "/list-players-name")
    public List<Player> listPlayersWithName(@RequestParam(name = "name") String name){
        
        return playerService.listPlayersWithName(name);
    }

    // teste/list-players-name-position
    @GetMapping(value = "/list-players-name-position")
    public List<Player> listPlayersWithName(@RequestParam(name = "name") String name,@RequestParam(name = "position")String position){
        
        return playerService.listPlayersWithNameAndPosition(name,position);
    }

     // teste/list-players-name-belong-team
     @GetMapping(value = "/list-players-belong-team")
     public List<Player> listPlayersBelongTeam(){
         
         return playerService.listPlayersBelongTeam();
     }

      // teste/list-teams-ssports
      @GetMapping(value = "/list-teams-sports")
      public List<Team> listTeamsBySports(){
          
          return teamService.listTeamsBySports();
      }

       // teste/list-teams-ssports
       @GetMapping(value = "/list-players-sports")
       public List<Player> listPlayerByTeamCity(@RequestParam(name = "city") String city){
           
           return playerService.listPlayerByTeamCity(city);
       }

       // teste/list-teams-ssports
       @GetMapping(value = "/list-players-teams-leagues")
       public List<Player> listPlayerByTeamLeague(@RequestParam(name = "league") Long league){
           
           return playerService.listPlayerByTeamLeague(league);
       }

         // teste/list-players
    @GetMapping(value = "/list-players-custum1")
    public List<Player> listPlayers(String sport) {

        return playerService.listPlayers(sport);
    }

}
