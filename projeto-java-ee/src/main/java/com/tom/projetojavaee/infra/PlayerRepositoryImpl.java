package com.tom.projetojavaee.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.tom.projetojavaee.custom.PlayerRepositoryCustom;
import com.tom.projetojavaee.domain.League;
import com.tom.projetojavaee.domain.Player;

import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepositoryImpl implements PlayerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    // @Override
    // public List<Player> findAllPlayers() {
    // // TODO Auto-generated method stub
    // String jpql = "SELECT p FROM Player p";

    // return this.entityManager.createQuery(jpql, Player.class)
    // .getResultList();
    // }

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

    // implementation by Criteira API
    // @Override
    // public List<Player> findAllPlayers() {
    // // TODO Auto-generated method stub
    // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    // CriteriaQuery<Player> criteria = builder.createQuery(Player.class);
    // Root<Player> rootPlayer = criteria.from(Player.class);

    // criteria.select(rootPlayer);

    // TypedQuery<Player> query = entityManager.createQuery(criteria);
    // List<Player> list = query.getResultList();

    // return list;
    // }

    // implementação criteria utilizando metamodel

    @Override
    public List<Player> findAllPlayers() {
        // TODO Auto-generated method stub

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Player> criteria = builder.createQuery(Player.class);

        Metamodel model = entityManager.getMetamodel();

        EntityType<Player> Player_ = model.entity(Player.class);

        Root<Player> root = criteria.from(Player_);

        criteria.select(root);
        TypedQuery<Player> query = entityManager.createQuery(criteria);

        List<Player> list = query.getResultList();
        return list;
    }
}
