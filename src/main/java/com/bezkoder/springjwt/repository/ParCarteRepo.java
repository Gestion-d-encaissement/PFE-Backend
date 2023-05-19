package com.bezkoder.springjwt.repository;

 import com.bezkoder.springjwt.models.Caissier;
 import com.bezkoder.springjwt.models.Facture;
 import com.bezkoder.springjwt.models.Paiement;
 import com.bezkoder.springjwt.models.ParCarte;
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 import org.springframework.data.repository.query.Param;
 import org.springframework.stereotype.Repository;

 import java.util.Collection;
 import java.util.List;

@Repository @EnableJpaRepositories
public interface ParCarteRepo extends JpaRepository<ParCarte,Long> {
  List<ParCarte> findBycaissier(Caissier caissier);
  List<ParCarte> findByfacture(Facture facture);
    Collection<? extends Paiement> findAllByFacture(Facture facture);
  @Query(value = " SELECT SUM(paiement.montant), DATE_FORMAT(paiement.datepay, '%Y-%m-%d'),paiement.montant,paiement.idfact,facture.id,paiement.caissier,users.id,users.codeagence FROM `paiement`,`facture`,`users` WHERE users.id=paiement.caissier AND DATE_FORMAT(paiement.datepay, '%Y-%m-%d')= CURDATE() AND paiement.idfact=facture.id AND facture.etat='Soldee'",nativeQuery=true)
  List<ParCarte> getbordero();
}
