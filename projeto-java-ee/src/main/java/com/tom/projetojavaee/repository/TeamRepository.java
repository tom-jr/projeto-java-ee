package com.tom.projetojavaee.repository;

import java.util.List;

import com.tom.projetojavaee.custom.TeamRepositoryCustom;
import com.tom.projetojavaee.domain.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long>, TeamRepositoryCustom {

    List<Team> findAllBySports();

}
