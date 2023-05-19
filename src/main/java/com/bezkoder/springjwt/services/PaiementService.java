package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Dto.PaiementDto;
import com.bezkoder.springjwt.models.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PaiementService {
  void createparcart(PaiementDto paiementDto);
  List<ParCarte> findbyidfact(Facture facture);
  ParCarte findbyidfactt(Long id);
  List<ParCarte> getbyid(Facture facture);
  Optional<Paiement> getbyid(Long id);
  void createparcheq(ParCheque parCheque);
  void createparesp(ParEspece parEspece);
  ParCarte save(ParCarte parCarte);
  ParCheque save2(ParCheque parCheque);
  ParEspece save3(ParEspece parEspece);
}
