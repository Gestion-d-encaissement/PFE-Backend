package com.bezkoder.springjwt.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
  @NotBlank
   private String username;
  @NotBlank
  private String password;
  @NotBlank

  private String codeagence;

  private String nom;

  private String prenom;

  private String matricule;
   private Set<String> role;

  public SignupRequest(String username, String password, String codeagence, String nom, String prenom, String matricule) {
    this.username = username;
    this.password = password;
    this.codeagence = codeagence;
    this.nom = nom;
    this.prenom = prenom;
    this.matricule = matricule;
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



  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
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
}
