package com.tom.projetojavaee.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tom.projetojavaee.custom.PlayerRepositoryCustom;
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

}
