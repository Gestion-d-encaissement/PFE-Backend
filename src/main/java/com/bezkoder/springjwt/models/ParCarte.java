package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ParCarte extends Paiement{

  private Long idtransaction;
  private String numcarte;

  public ParCarte(Long id, Date datepay, double montant, Facture facture, Caissier caissier, Long idtransaction, String numcarte) {
    super(id, datepay, montant, facture, caissier);
    this.idtransaction = idtransaction;
    this.numcarte = numcarte;
  }

  public Long getIdtransaction() {
    return idtransaction;
  }

  public void setIdtransaction(Long idtransaction) {
    this.idtransaction = idtransaction;
  }

  public String getNumcarte() {
    return numcarte;
  }

  public void setNumcarte(String numcarte) {
    this.numcarte = numcarte;
  }
}
