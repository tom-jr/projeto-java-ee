package com.tom.projetojavaee.custom;

import java.util.List;

import com.tom.projetojavaee.domain.League;
import com.tom.projetojavaee.domain.Player;

public interface PlayerRepositoryCustom {

    List<Player> findAllPlayers();

    List<Player> findAllPlayersWithName(String name);

    List<Player> findAllPlayersWithNameAndPosition(String name, String position);

    List<Player> findAllPlayersBelongTeam();

    List<Player> findAllPlayersByTeamCity(String city);

    List<Player> findAllByTeamsLeague(League league);

    List<Player> findAllBy(String sport);

}
