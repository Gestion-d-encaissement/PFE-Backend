package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Bordoreau;
import com.bezkoder.springjwt.models.ParCheque;
import com.bezkoder.springjwt.repository.BorderoRepo;
import com.bezkoder.springjwt.repository.FactureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BorderoServiceImpl implements BorederoService{
  @Autowired
  BorderoRepo borderoRepo ;

  @Override
  public Bordoreau save(Bordoreau bordoreau) {
    return borderoRepo.save(bordoreau);
  }
}
