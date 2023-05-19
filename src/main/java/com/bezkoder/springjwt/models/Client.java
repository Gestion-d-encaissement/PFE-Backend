package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
 @AllArgsConstructor
@NoArgsConstructor
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  private String prenom;
  private String adresse;
  private Long tel;



  public Client(String nom, String prenom, String adresse, Long tel) {
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.tel = tel;
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

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public Long getTel() {
    return tel;
  }

  public void setTel(Long tel) {
    this.tel = tel;
  }
}
