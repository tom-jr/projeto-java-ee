package com.tom.projetojavaee.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tom.projetojavaee.custom.PlayerRepositoryCustom;
import com.tom.projetojavaee.domain.Player;

import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepositoryImpl implements PlayerRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Player> findAllPlayers() {
        // TODO Auto-generated method stub
        String jpql = "SELECT p FROM Player p";

        return this.entityManager.createQuery(jpql,Player.class)
        .getResultList();
    }
    
}
