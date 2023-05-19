package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Employer extends User {

  Boolean isActiveByStatuts=false;

  @ManyToOne
  @JoinColumn(name = "code_Agence")
  private Agence  agence;
  public Employer(String username, String codeagence, String nom, String prenom, String matricule,Agence agence,Boolean isActiveByStatuts, String password) {
    super(username, codeagence, nom, prenom, matricule, password);
    this.agence=agence;
    this.isActiveByStatuts=isActiveByStatuts;
  }

  public Agence getAgence() {
    return agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }
}
