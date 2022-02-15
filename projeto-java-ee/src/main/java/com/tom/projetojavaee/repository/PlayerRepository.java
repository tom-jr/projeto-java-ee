package com.tom.projetojavaee.repository;

import java.util.List;

import com.tom.projetojavaee.custom.PlayerRepositoryCustom;
import com.tom.projetojavaee.domain.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long>,PlayerRepositoryCustom{

    List<Player> findAllPlayers();

    List<Player> findAllPlayersWithName(String name);

    List<Player> findAllPlayersWithNameAndPosition(String name, String position);

    List<Player> findAllPlayersBelongTeam();
    
}
