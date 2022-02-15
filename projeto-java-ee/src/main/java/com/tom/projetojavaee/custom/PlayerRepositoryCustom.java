package com.tom.projetojavaee.custom;

import java.util.List;

import com.tom.projetojavaee.domain.Player;

public interface PlayerRepositoryCustom {
    List<Player> findAllPlayers();
}
