package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.models.ParCarte;
import com.bezkoder.springjwt.models.ParCheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcheqRepo extends JpaRepository<ParCheque,Long> {
  List<ParCheque> findByfacture(Facture facture);
}
