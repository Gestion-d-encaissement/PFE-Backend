package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.models.ParCarte;
import com.bezkoder.springjwt.models.ParEspece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParEspRepo extends JpaRepository<ParEspece,Long> {
  List<ParEspece> findByfacture(Facture facture);
}
