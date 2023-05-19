package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Dto.PaiementDto;
import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.*;
import com.bezkoder.springjwt.services.BorederoService;
import com.bezkoder.springjwt.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/paiement")
public class PaiementController {
  @Autowired
  UserRepository  userRepository;
  @Autowired
  EmpCaisRepo empCaisRepo;
  @Autowired
  BorederoService borederoService;
  @Autowired
  PaiementService paiementService;
  @Autowired
  ParCarteRepo parCarteRepo;
  @Autowired
  ParcheqRepo parcheqRepo;
  @Autowired
  ParEspRepo parEspRepo;
  @Autowired
  PaimentRepo paimentRepo;
  @Autowired
  FactureRepo factureRepo;
//!important
  @GetMapping("/paye/{id}")
  public List<ParCarte> getListOfLaptopsByBrand (@PathVariable Long id) {


    Facture facture=factureRepo.findById(id).get();

    return parCarteRepo.findByfacture(facture);
  }
  //!!
  @GetMapping("/payerall")
  public List<Paiement>getall(){
    return paimentRepo.getbordero();
  }
  @GetMapping(path = "/bord")
  public List<Object> dome( ){



    return paimentRepo.getbordero1();
  }//!!!
  @GetMapping(path = "/bycaissier/{id}")
  public Double bycaissier(@PathVariable Long id){
 Caissier caissier= empCaisRepo.findById(id).get();


    return paimentRepo.getbycaissier(caissier);
  }
  @GetMapping(path = "/getbycai/{id}")
  public Double getbycai(@PathVariable Long id){
    Caissier caissier= empCaisRepo.findById(id).get();


    return paimentRepo.findBycaissier(caissier);
  }

  @GetMapping(path = "/bord1")
  public Map < List<Paiement> , List<Object> >ss( ){

    return paimentRepo.ch();
  }
  @GetMapping(path = "/total")
  public Double tot(){
    return  paimentRepo.total();
  }

  //!important
  //!important
  @GetMapping("/payechq/{id}")
  public List<ParCheque> getListOfLaptopsByBrand2 (@PathVariable Long id) {


    Facture facture=factureRepo.findById(id).get();

    return parcheqRepo.findByfacture(facture);
  }
  //!important
  //!important
  @GetMapping("/payesp/{id}")
  public List<ParEspece> getListOfLaptopsByBrand3 (@PathVariable Long id) {


    Facture facture=factureRepo.findById(id).get();

    return parEspRepo.findByfacture(facture);
  }
  //!important



  @PostMapping(path = "/addpaiementcarte")

  public void createparcarte(@RequestBody PaiementDto paiementDto ){
    paiementService.createparcart(paiementDto);


  }

  @GetMapping(path = "/getparcart")
  public List<ParCarte>  getparcart(Facture facture) {
    return this.paiementService.findbyidfact(facture);
  }
  @GetMapping(path = "/getcart/{id}")
  public Optional<Paiement> getbyid(@PathVariable("id") Long id ){
    return this.paiementService.getbyid(id);
  }
  //!important

  @PostMapping(path = "/addpaycart")
  public ParCarte save(@RequestBody ParCarte parCarte){
     Facture  facture=factureRepo.findById(parCarte.getFacture().getId()).get();
     facture.setEtat("Soldee");
     factureRepo.save(facture);
    return paiementService.save(parCarte);
  }
  //!important
  //!important

  @PostMapping(path = "/addpaycheq")
  public ParCheque save2(@RequestBody ParCheque  parCheque){
    Facture  facture=factureRepo.findById(parCheque.getFacture().getId()).get();
    facture.setEtat("Soldee");
    factureRepo.save(facture);
    return paiementService.save2(parCheque);
  }
  //!important
  //!important

  @PostMapping(path = "/addpayesp")
  public ParEspece save3(@RequestBody ParEspece parEspece){
    Facture  facture=factureRepo.findById(parEspece.getFacture().getId()).get();
    facture.setEtat("Soldee");
    factureRepo.save(facture);
    return paiementService.save3(parEspece);
  }
  //!important
 @PostMapping(path ="/bordero")
  public Bordoreau insert(@RequestBody Bordoreau bordoreau){
    return borederoService.save(bordoreau);
 }
}
