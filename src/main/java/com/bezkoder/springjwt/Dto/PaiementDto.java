package com.bezkoder.springjwt.Dto;

import com.bezkoder.springjwt.models.Caissier;
import com.bezkoder.springjwt.models.Facture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiementDto {
  private Long id;
  private Date datepay;
  private double montant;
  private Facture facture;
  private Caissier caissier;
  private Long idtransaction;
  private String numcarte;
}
