package com.tom.projetojavaee.services;

import java.util.List;
import java.util.Optional;

import com.tom.projetojavaee.domain.League;
import com.tom.projetojavaee.domain.Player;
import com.tom.projetojavaee.repository.LeagueRepository;
import com.tom.projetojavaee.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private LeagueRepository leagueRepository; 

    public List<Player> listPlayers() {
        return playerRepository.findAllPlayers();
    }

    public List<Player> listPlayersWithName(String name) {
        return this.playerRepository.findAllPlayersWithName(name);
    }

    public List<Player> listPlayersWithNameAndPosition(String name, String position) {
        return playerRepository.findAllPlayersWithNameAndPosition(name,position);
    }

    public List<Player> listPlayersBelongTeam() {
        return this.playerRepository.findAllPlayersBelongTeam();
    }

    public List<Player> listPlayerByTeamCity(String city) {
        return playerRepository.findAllPlayersByTeamCity(city);
    }

    public List<Player> listPlayerByTeamLeague(Long league) {
        Optional<League> leagueRepo = this.leagueRepository.findById(league);
        return playerRepository.findAllByTeamsLeague(leagueRepo.get());
    }

    public List<Player> listPlayers(String sport) {
        return this.playerRepository.findAllBy(sport);
    }
}
