package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Dto.AgenceDto;
import com.bezkoder.springjwt.models.Agence;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.AgenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AgenceServiceImpl implements AgenceService {
  @Autowired
  AgenceRepo  agenceRepo;
  @Override
  public List<Agence> findAll() {
    return agenceRepo.findAll();
  }

  @Override
  public Agence save(Agence agence) {
    return agenceRepo.save(agence);
  }

  @Override
  public void deleteAgence(Long id) {
    agenceRepo.deleteById(id);
  }

  @Override
  public void updateAgence(AgenceDto agenceDto) {
    Agence agence=agenceRepo.findById(agenceDto.getId()).get();
    if (agenceDto.getAdresse()!=null){
      agence.setAdress(agenceDto.getAdresse());
    }
    if (agenceDto.getCodeAgence()!=null){
      agence.setCodeAgence(agenceDto.getCodeAgence());
    }

    agenceRepo.save(agence);

  }
}
