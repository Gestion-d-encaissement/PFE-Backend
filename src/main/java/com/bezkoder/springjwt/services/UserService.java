package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Dto.UserDto;
import com.bezkoder.springjwt.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserService {
  List<User> findAll();
  ///méthode admin
  void deleteUser(Long id);
  void updateUser ( UserDto  userDto);



  /*  // crud agence
    Administrateur ajouteragence(Agence agence);
    Administrateur modifieragence(Agence agence);
    Administrateur supprimeragence(Agence agence);
*/
  //méthode caissier
  Caissier findByNom(String nom);
  Caissier save(Caissier caissier);
  Caissier payer(Facture facture);
  Caissier imprimerRecu(PaiementService paiement);
  //methode employe
  Employer save(Employer employer);
}
