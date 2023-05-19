package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Dto.PaiementDto;
import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaiementServiceImpl implements PaiementService{
  @Autowired
  EmpCaisRepo  empCaisRepo;
  @Autowired
  FactureRepo factureRepo;

  @Autowired
  ParCarteRepo parCarteRepo;
  @Autowired
  ParcheqRepo parcheqRepo;
  @Autowired
  ParEspRepo parEspRepo;
  @Autowired
  PaimentRepo paimentRepo;

  @Override
  public void createparcart(PaiementDto paiementDto  ) {
  ParCarte parCartee=new ParCarte();
    Caissier caissier=empCaisRepo.findById(paiementDto.getCaissier().getId()).get();
    Facture  facture=factureRepo.findById(paiementDto.getFacture().getId()).get();
    parCartee.setIdtransaction( paiementDto.getIdtransaction());
    parCartee.setNumcarte(paiementDto.getNumcarte());
    parCartee.setDatepay(paiementDto.getDatepay());
    parCartee.setMontant(paiementDto.getMontant());
    parCartee.setCaissier(caissier);
    parCartee.setFacture(facture);
     parCarteRepo.save(parCartee);
  }

  @Override
  public List<ParCarte> findbyidfact(Facture facture) {
    return parCarteRepo.findByfacture(facture);
  }

  @Override
  public ParCarte findbyidfactt(Long id) {
    return null;
  }
  @Override
  public List<ParCarte> getbyid(Facture facture){
    return this.parCarteRepo.findByfacture(facture);
 }

  @Override
  public Optional<Paiement> getbyid(Long id) {
    return paimentRepo.findById(id) ;
  }

  @Override
  public void createparcheq(ParCheque parCheque) {

  }

  @Override
  public void createparesp(ParEspece parEspece) {

  }

  @Override
  public ParCarte save(ParCarte parCarte) {
    return parCarteRepo.save(parCarte);
  }

  @Override
  public ParCheque save2(ParCheque parCheque) {
    return parcheqRepo.save(parCheque);
  }

  @Override
  public ParEspece save3(ParEspece parEspece) {
    return parEspRepo.save(parEspece);
  }
}
