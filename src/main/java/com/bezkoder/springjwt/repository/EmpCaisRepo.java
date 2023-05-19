package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Caissier;

import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpCaisRepo extends JpaRepository<Caissier, Long> {
  Optional<Caissier> findByUsername(String username);
  boolean isActiveByStatuts(Boolean statuts);

}
