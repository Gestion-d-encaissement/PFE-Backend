package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.repository.ClientRepo;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ClientServiceImpl implements ClientService{
  @Autowired
  private ClientRepo clientRepo ;
  @Override
  public List<Client> findAll() {
    return clientRepo.findAll();
  }

  @Override
  public Client save(Client client) {
    return clientRepo.save(client);
  }
}
