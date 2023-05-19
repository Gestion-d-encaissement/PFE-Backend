package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.models.Agence;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class SignupEmpCaisRequest {
  @NotBlank
  private String username;
  @NotBlank
  private String password;
  @NotBlank

  private String codeagence;

  private String nom;

  private String prenom;

  private String matricule;
  private Agence agence;
  Boolean isActiveByStatuts=false;
  private Set<String> role;

  public SignupEmpCaisRequest(String username, String password, String codeagence, String nom, String prenom, String matricule, Agence agence, Boolean isActiveByStatuts) {
    this.username = username;
    this.password = password;
    this.codeagence = codeagence;
    this.nom = nom;
    this.prenom = prenom;
    this.matricule = matricule;
    this.agence = agence;
    this.isActiveByStatuts = isActiveByStatuts;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCodeagence() {
    return codeagence;
  }

  public void setCodeagence(String codeagence) {
    this.codeagence = codeagence;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
  }

  public Agence getAgence() {
    return agence;
  }

  public void setAgence(Agence agence) {
    this.agence = agence;
  }

  public Set<String> getRole() {
    return role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

  public Boolean getActiveByStatuts() {
    return isActiveByStatuts;
  }

  public void setActiveByStatuts(Boolean activeByStatuts) {
    isActiveByStatuts = activeByStatuts;
  }
}
