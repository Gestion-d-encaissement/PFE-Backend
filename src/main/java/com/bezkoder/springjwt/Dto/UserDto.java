package com.bezkoder.springjwt.Dto;

import com.bezkoder.springjwt.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  private long id;
  private String username;
  private String codeagence;
  private String nom;
  private String prenom;
  private String agence;
  private String matricule;
  private boolean isActiveByStatuts;
  private List<Role> roles;
}
