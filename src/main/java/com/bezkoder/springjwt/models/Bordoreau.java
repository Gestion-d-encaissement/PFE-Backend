package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "bordoreau")
@AllArgsConstructor
@NoArgsConstructor
public class Bordoreau {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @JsonFormat(pattern="yyyy-MM-dd")
  private Date date_j_actual;
  private String reference;

  @ManyToOne
  @JoinColumn(name = "paiement_id")
   private Paiement paiement;
}
