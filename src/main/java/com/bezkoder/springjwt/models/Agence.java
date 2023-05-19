package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agence {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long codeAgence;
  private String designation;
  private String adresse;

  public Agence(String designation, String adress) {
    this.designation = designation;
    this.adresse = adress;
  }

  public Long getCodeAgence() {
    return codeAgence;
  }

  public void setCodeAgence(Long codeAgence) {
    this.codeAgence = codeAgence;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getAdress() {
    return adresse;
  }

  public void setAdress(String adress) {
    this.adresse = adress;
  }
}
