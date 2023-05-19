package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.repository.FactureRepo;
import com.bezkoder.springjwt.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/facture")
public class FactureController {
  @Autowired
  FactureRepo factureRepo;
  @Autowired
  FactureService factureService;

  @GetMapping(path = "/factures")
  public List<Facture> getUsers() {
    return this.factureService.findAll();
  }

  @GetMapping(path = "/count")
public long count(){

    return this.factureRepo.sumQuantities();
  }
  @GetMapping(path = "/countpay")
  public Double countpay(){

    return this.factureRepo.sumQuantitiessoldee();


  }
  @GetMapping(path = "/fact/{id}")
  public Facture getbyid(@PathVariable("id") Long num_facture){
    return this.factureService.findbynumfacture(num_facture);
  }

  @PostMapping(path = "/addfact")
  public Facture save(@RequestBody Facture facture){
    facture.setEtat("non soldee");
    return factureService.save(facture);
  }
}
