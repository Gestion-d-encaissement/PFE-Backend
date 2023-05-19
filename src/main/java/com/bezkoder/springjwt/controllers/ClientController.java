package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Client;

import com.bezkoder.springjwt.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
  @RequestMapping("/api/client")
public class ClientController {
  @Autowired
  ClientService clientService;


  @GetMapping(path = "/clients")
  public List<Client> getUsers() {
    return this.clientService.findAll();
  }
}
