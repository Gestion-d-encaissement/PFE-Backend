package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Caissier;
import com.bezkoder.springjwt.models.Paiement;
import com.bezkoder.springjwt.models.ParCarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository @EnableJpaRepositories
public interface PaimentRepo extends JpaRepository<Paiement,Long> {
  @Query(value = "SELECT    SUM(paiement.montant)  FROM   paiement WHERE DATE_FORMAT(paiement.datepay, '%Y-%m-%d')= CURDATE() AND paiement.caissier=caissier  ",nativeQuery=true)
  Double findBycaissier(Caissier caissier);


  List<Paiement> findAllByFacture(Long id);
  @Query(value = "SELECT SUM(paiement.montant) FROM paiement WHERE DATE_FORMAT(paiement.datepay, '%Y-%m-%d')= CURDATE()  ",nativeQuery=true)
  Double total();

  @Query(value = "SELECT * , SUM(montant) FROM paiement,users,facture WHERE paiement.caissier=users.id AND DATE_FORMAT(paiement.datepay, '%Y-%m-%d')= CURDATE() AND paiement.idfact=facture.id AND facture.etat='Soldee' GROUP BY paiement.caissier;",nativeQuery=true)
  List<Paiement> getbordero();
  @Query(value = "SELECT   SUM(paiement.montant), users.id FROM users, paiement WHERE DATE_FORMAT(paiement.datepay, '%Y-%m-%d')= CURDATE() AND paiement.caissier=users.id GROUP BY paiement.caissier",nativeQuery=true)
  List<Object> getbordero1( );

  @Query(value = "SELECT *,SUM(montant) FROM `paiement` GROUP BY paiement.caissier",nativeQuery=true)
  List<Paiement> caisssier();

  @Query(value = "SELECT * ,  SUM(paiement.montant)  FROM paiement WHERE DATE_FORMAT(paiement.datepay, '%Y-%m-%d')= CURDATE() GROUP BY paiement.caissier",nativeQuery=true)
  Map < List<Paiement> , List<Object> > ch();
  @Query(value = "SELECT *, SUM(paiement.montant) FROM paiement WHERE DATE_FORMAT(paiement.datepay, '%Y-%m-%d')= CURDATE() GROUP BY paiement.caissier",nativeQuery=true)
 List<Paiement> ss();

  @Query(value = "SELECT   SUM(paiement.montant) FROM paiement,users WHERE paiement.caissier=users.id AND DATE_FORMAT(paiement.datepay, '%Y-%m-%d')= CURDATE()    ",nativeQuery=true)
  Double getbycaissier(Caissier caissier );


}
