package com.tom.projetojavaee.services;

import java.util.List;

import com.tom.projetojavaee.domain.Player;
import com.tom.projetojavaee.domain.Team;
import com.tom.projetojavaee.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> listTeamsBySports() {
        return this.teamRepository.findAllBySports();
    }
}
