package com.tom.projetojavaee.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tom.projetojavaee.custom.PlayerRepositoryCustom;
import com.tom.projetojavaee.domain.League;
import com.tom.projetojavaee.domain.Player;

import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepositoryImpl implements PlayerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> findAllPlayers() {
        // TODO Auto-generated method stub
        String jpql = "SELECT p FROM Player p";

        return this.entityManager.createQuery(jpql, Player.class)
                .getResultList();
    }

    @Override
    public List<Player> findAllPlayersWithName(String name) {
        // TODO Auto-generated method stub
        String jpql = "SELECT DISTINCT p FROM Player p WHERE p.name = :name";
        return entityManager.createQuery(jpql, Player.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Player> findAllPlayersWithNameAndPosition(String name, String position) {
        // TODO Auto-generated method stub
        String jpql = "SELECT DISTINCT p FROM Player p WHERE p.name = :name AND p.position = :position";
        return entityManager.createQuery(jpql, Player.class)
                .setParameter("name", name)
                .setParameter("position", position)
                .getResultList();
    }

    @Override
    public List<Player> findAllPlayersBelongTeam() {
        // TODO Auto-generated method stub
        /**
         * Busca os Players com valores p.teams inseridos
         * TODAS as seguintes querys trazem o mesmo result
         */
        String jpql1 = "SELECT DISTINCT p FROM Player p, IN (p.teams) t ";
        String jpql2 = "SELECT DISTINCT p FROM Player p JOIN p.teams t";
        String jpql3 = "SELECT DISTINCT p FROM Player p WHERE p.teams IS NOT EMPTY";
        return this.entityManager.createQuery(jpql3, Player.class)
                .getResultList();
    }

    @Override
    public List<Player> findAllPlayersByTeamCity(String city) {
        // TODO Auto-generated method stub
        String psql = "SELECT DISTINCT p FROM Player p, IN (p.teams) AS t WHERE t.city = :city ";
        return entityManager.createQuery(psql, Player.class)
                .setParameter("city", city)
                .getResultList();
    }

    @Override
    public List<Player> findAllByTeamsLeague(League league) {
        // TODO Auto-generated method stub
        String psql = "SELECT DISTINCT p FROM Player p, IN (p.teams) AS t WHERE t.league = :league";
        return entityManager.createQuery(psql, Player.class)
                .setParameter("league", league)
                .getResultList();
    }

    @Override
    public List<Player> findAllBy(String sport) {
        // TODO Auto-generated method stub
        String jpql = "SELECT DISTINCT p FROM Player p, IN (p.teams) AS t WHERE t.league.sport = :sport";
        return entityManager.createQuery(jpql, Player.class)
                .setParameter("sport", sport)
                .getResultList();
    }
}
