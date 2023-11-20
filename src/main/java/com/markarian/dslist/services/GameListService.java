package com.markarian.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markarian.dslist.dto.GameListDto;
import com.markarian.dslist.entities.GameList;
import com.markarian.dslist.repositories.GameListRepository;

@Service
public class GameListService {

  @Autowired // -> Através dessa notação o Spring resolve as dependências nescessárias.
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public GameListDto findById(Long id) {
    GameList result = gameListRepository.findById(id).get();
    if (result != null) {
      return new GameListDto(result);
    } else {
      return null;
    }
  }

  @Transactional(readOnly = true)
  public List<GameListDto> findAll() {
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(data -> new GameListDto(data)).toList();
  }
}
