package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Agence;
import com.bezkoder.springjwt.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenceRepo extends JpaRepository<Agence,Long> {
  @Override
  List<Agence> findAll();
}
