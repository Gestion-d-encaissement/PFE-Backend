package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@NoArgsConstructor
@Entity
public class Administrateur extends User{


  public Administrateur(String username, String codeagence, String nom, String prenom, String matricule, String password) {
    super(username, codeagence, nom, prenom, matricule, password);
  }
}



