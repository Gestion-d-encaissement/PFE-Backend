package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Agence;
import com.bezkoder.springjwt.models.Bordoreau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorderoRepo extends JpaRepository<Bordoreau,Long> {


}
