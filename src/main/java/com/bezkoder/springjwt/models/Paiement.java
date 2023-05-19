package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "paiement")
@AllArgsConstructor
@NoArgsConstructor

public abstract class Paiement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @JsonFormat(pattern="yyyy-MM-dd")
  private Date datepay;
  private double montant;

  @OneToOne
  @JoinColumn(name = "idfact")
  private Facture facture;

  @ManyToOne
  @JoinColumn(name = "caissier")
   private Caissier caissier;
}
