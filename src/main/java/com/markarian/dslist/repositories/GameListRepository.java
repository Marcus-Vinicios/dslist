package com.markarian.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markarian.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
  
}
