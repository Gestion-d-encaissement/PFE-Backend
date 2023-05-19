package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users",
    uniqueConstraints = {
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "codeagence")
    })
@AllArgsConstructor

public abstract class  User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
   private String username;

  @NotBlank

  private String codeagence;
  @NotBlank

  private String nom;
  @NotBlank

  private String prenom;
  @NotBlank

  private String matricule;


  @NotBlank
   private String password;



  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();


  public User(String username, String codeagence, String nom, String prenom, String matricule, String password) {
    this.username = username;
    this.codeagence = codeagence;
    this.nom = nom;
    this.prenom = prenom;
    this.matricule = matricule;
    this.password = password;
  }
  public User(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  public String getCodeagence() {
    return codeagence;
  }

  public void setCodeagence(String codeagence) {
    this.codeagence = codeagence;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
  }
}
