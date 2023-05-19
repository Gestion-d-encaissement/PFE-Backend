package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.models.Facture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
  List<Client> findAll();
  Client save(Client  client);
}
