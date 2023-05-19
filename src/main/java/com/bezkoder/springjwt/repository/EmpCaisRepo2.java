package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Caissier;
import com.bezkoder.springjwt.models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpCaisRepo2 extends JpaRepository<Employer, Long> {
  @Override
  List<Employer> findAll();
  Optional<Employer> findByUsername(String username);

  boolean isActiveByStatuts(Boolean statuts);

}
