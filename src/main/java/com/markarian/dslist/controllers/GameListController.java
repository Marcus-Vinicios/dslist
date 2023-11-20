package com.markarian.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markarian.dslist.dto.GameListDto;
import com.markarian.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

  @Autowired
  private GameListService gameListService;
  // Injetando/Instanciando um service no controller.

  @GetMapping(value = "/{id}")
  public GameListDto findById(@PathVariable Long id) {
    GameListDto result = gameListService.findById(id);
    return result;
  }

  @GetMapping
  public List<GameListDto> findAll() {
    List<GameListDto> result = gameListService.findAll();
    return result;
  }
}
