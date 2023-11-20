package com.markarian.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markarian.dslist.dto.GameDto;
import com.markarian.dslist.dto.GameMinDto;
import com.markarian.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  @Autowired
  private GameService gameService;
  // Injetando/Instanciando um service no controller.

  @GetMapping(value = "/{id}")
  public GameDto findById(@PathVariable Long id) {
    GameDto result = gameService.findById(id);
    return result;
  }

  @GetMapping
  public List<GameMinDto> findAll() {
    List<GameMinDto> result = gameService.findAll();
    return result;
  }
}
