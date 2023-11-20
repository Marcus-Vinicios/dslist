//Componente GameService -> responsavel por tratar os dados da API.
package com.markarian.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markarian.dslist.dto.GameDto;
import com.markarian.dslist.dto.GameMinDto;
import com.markarian.dslist.entities.Game;
import com.markarian.dslist.repositories.GameRepository;

@Service
public class GameService {

  @Autowired // -> Através dessa notação o Spring resolve as dependências nescessárias.
  private GameRepository gameRepository;
  // Injetando/Instanciando o GameRepository no GameService.
  // GameRepository -> componente do sistema.

  /*
   * Para compor o sistema em vários componentes, é preciso injetar os componentes
   * uns nos outros, realizando uma integração entre os componentes do sistema.
   */

  public class GameNotFound extends RuntimeException {
    public GameNotFound(String message) {
      super(message);
    }
  }

  @Transactional(readOnly = true)
  public GameDto findById(Long id) {
    Game result = gameRepository.findById(id).get();
    if (result != null) {
      return new GameDto(result);
    } else {
      throw new GameNotFound("Jogo não encontrado para o ID: " + id);
    }
  }

  // Através das chaves "<>" é possivel tipar algo.
  @Transactional(readOnly = true)
  public List<GameMinDto> findAll() {
    // Realizando uma consulta no banco de dados e trazendo os dados.
    List<Game> result = gameRepository.findAll();
    return result.stream().map(data -> new GameMinDto(data)).toList();
    // Retorna uma nova lista com os dados processados, mostrando somente o que foi
    // definido no GameMinDto.
  }
}
