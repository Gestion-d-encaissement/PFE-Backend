package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FactureService {
  List<Facture> findAll();
  Facture  findbynumfacture(Long numfacture);

  Facture save(Facture facture);
}
