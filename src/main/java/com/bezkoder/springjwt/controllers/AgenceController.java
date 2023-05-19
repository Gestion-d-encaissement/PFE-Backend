package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Dto.AgenceDto;
import com.bezkoder.springjwt.Dto.UserDto;
import com.bezkoder.springjwt.models.Agence;
import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.services.AgenceService;
import com.bezkoder.springjwt.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/agence")
public class AgenceController {
  @Autowired
  AgenceService agenceService;

  @GetMapping(path = "/agences")
  public List<Agence> getUsers() {
    return this.agenceService.findAll();
  }
  @PostMapping(path = "/addagence")
  public Agence save(@RequestBody Agence  agence){
    return agenceService.save(agence);
  }
  @PutMapping(path = "/updatagence")
  public String update(@RequestBody AgenceDto agenceDto) throws IOException {
    agenceService.updateAgence(agenceDto);
    return "update ok ";
  }
  @DeleteMapping("/Agence/{id}")
  public String deleteUser(@PathVariable Long id) {
    agenceService.deleteAgence(id);
    return "User deleted successfully.";
  }
}
