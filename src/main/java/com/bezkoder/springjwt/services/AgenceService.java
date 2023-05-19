package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Dto.AgenceDto;
import com.bezkoder.springjwt.Dto.UserDto;
import com.bezkoder.springjwt.models.Agence;
import com.bezkoder.springjwt.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgenceService {
  List<Agence> findAll();
  Agence save(Agence  agence);
  void deleteAgence(Long id);
  void updateAgence (AgenceDto  agenceDto);
}
