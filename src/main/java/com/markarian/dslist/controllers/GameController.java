package com.markarian.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markarian.dslist.dto.GameMinDto;
import com.markarian.dslist.services.GameService;

//Através dos controladores é possivel acessar os serviços da API.
@RestController
@RequestMapping(value = "/games")
public class GameController {
  
  @Autowired
  private GameService gameService;
  //Injetando/Instanciando um service no controller.

  @GetMapping
  public List<GameMinDto> findAll() {
    List<GameMinDto> result = gameService.findAll();
    return result;
  }
}
