package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ParCheque extends Paiement{
private String numcheq;
private String RIP;
private String RIB;

  public ParCheque(Long id, Date datepay, double montant, Facture facture, Caissier caissier, String numcheq, String RIP, String RIB) {
    super(id, datepay, montant, facture, caissier);
    this.numcheq = numcheq;
    this.RIP = RIP;
    this.RIB = RIB;
  }

  public String getNumcheq() {
    return numcheq;
  }

  public void setNumcheq(String numcheq) {
    this.numcheq = numcheq;
  }

  public String getRIP() {
    return RIP;
  }

  public void setRIP(String RIP) {
    this.RIP = RIP;
  }

  public String getRIB() {
    return RIB;
  }

  public void setRIB(String RIB) {
    this.RIB = RIB;
  }
}
