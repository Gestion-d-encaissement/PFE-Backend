package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

@NoArgsConstructor
public class Facture {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
  private Long numfact;

  private Double montantfact;
  @JsonFormat(pattern="yyyy-MM-dd")
  //@JsonFormat(pattern = "yyyy/MM/dd")

  private Date datedebut;
  @JsonFormat(pattern="yyyy-MM-dd")
//  @JsonFormat(pattern = "yyyy/MM/dd")
  private Date datefin;
  private String etat;

  @ManyToOne
  @JoinColumn(name = "idClient")
  private Client client;

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getMontantfact() {
    return montantfact;
  }

  public void setMontantfact(Double montantfact) {
    this.montantfact = montantfact;
  }




  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

  public Date getDatedebut() {
    return datedebut;
  }

  public void setDatedebut(Date datedebut) {
    this.datedebut = datedebut;
  }

  public Date getDatefin() {
    return datefin;
  }

  public void setDatefin(Date datefin) {
    this.datefin = datefin;
  }

  public Long getNumfact() {
    return numfact;
  }

  public void setNumfact(Long numfact) {
    this.numfact = numfact;
  }
}
