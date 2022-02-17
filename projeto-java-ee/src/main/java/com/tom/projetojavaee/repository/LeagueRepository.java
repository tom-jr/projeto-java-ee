package com.tom.projetojavaee.repository;

import com.tom.projetojavaee.domain.League;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {
    
}
