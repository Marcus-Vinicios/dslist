package com.markarian.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markarian.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
