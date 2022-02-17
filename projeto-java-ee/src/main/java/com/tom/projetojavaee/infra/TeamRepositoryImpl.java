package com.tom.projetojavaee.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tom.projetojavaee.custom.TeamRepositoryCustom;
import com.tom.projetojavaee.domain.Team;

import org.springframework.stereotype.Repository;

@Repository
public class TeamRepositoryImpl implements TeamRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Team> findAllBySports() {
        // TODO Auto-generated method stub
        String psql = "SELECT t FROM Team t JOIN t.league l WHERE l.sport = 'Sport_Name_05' OR l.sport = 'Sport_Name_06'";
        return entityManager.createQuery(psql,Team.class)
        .getResultList();
    }

}
