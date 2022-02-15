package com.tom.projetojavaee.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Team {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String name;

    // relations
    @ManyToMany
    @JoinTable(name = "persistence_roster_team_player", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Player> players = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "league_id")
    private League league;

}
