package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepo extends JpaRepository<Facture,Long> {
  @Override
  List<Facture> findAll();
  @Query(value = "SELECT sum(montantfact) FROM Facture")
    Long sumQuantities();
  @Query(value = "SELECT sum(montantfact) FROM Facture where etat='Soldee'")
  Double sumQuantitiessoldee();

}
