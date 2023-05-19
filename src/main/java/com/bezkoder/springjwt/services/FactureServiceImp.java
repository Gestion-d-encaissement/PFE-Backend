package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.repository.ClientRepo;
import com.bezkoder.springjwt.repository.FactureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class FactureServiceImp implements FactureService {
  @Autowired
  FactureRepo factureRepo;
  @Autowired
  ClientRepo clientRepo;
  @Override
  public List<Facture> findAll() {
    return factureRepo.findAll();
   }

  @Override
  public Facture findbynumfacture(Long numfacture) {
     return factureRepo.findById(numfacture).get();
  }



  @Override
  public Facture save(Facture facture) {
    return factureRepo.save(facture);
  }
}
