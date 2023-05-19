package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Client;
import com.bezkoder.springjwt.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
  @Override
  List<Client> findAll();
}
