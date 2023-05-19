package com.bezkoder.springjwt.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenceDto {
  private Long id;
  private Long codeAgence;
  private String designation;
  private String adresse;
}
