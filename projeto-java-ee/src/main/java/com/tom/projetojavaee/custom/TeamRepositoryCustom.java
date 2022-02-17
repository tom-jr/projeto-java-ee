package com.tom.projetojavaee.custom;

import java.util.List;

import com.tom.projetojavaee.domain.Team;

public interface TeamRepositoryCustom {

    List<Team> findAllBySports();
    
}
