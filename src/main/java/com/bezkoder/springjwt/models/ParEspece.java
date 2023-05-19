package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ParEspece extends Paiement{
  private long idesp;

  public ParEspece(Long id, Date datepay, double montant, Facture facture, Caissier caissier, long id1) {
    super(id, datepay, montant, facture, caissier);
    this.idesp = id1;
  }

  public long getIdesp() {
    return idesp;
  }

  public void setIdesp(long idesp) {
    this.idesp = idesp;
  }
}
