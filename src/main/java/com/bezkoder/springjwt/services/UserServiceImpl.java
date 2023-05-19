package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Dto.UserDto;
import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.repository.EmpCaisRepo;
import com.bezkoder.springjwt.repository.EmpCaisRepo2;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmpCaisRepo empCaisRepo;
    @Autowired
     private EmpCaisRepo2 empCaisRepo2;

    @Override
    public List<User> findAll() {
        return  userRepository.findAll() ;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
  public void updateUser(UserDto userDto) {
    User user=userRepository.findById(userDto.getId()).get();
    if (userDto.getUsername()!=null){
      user.setUsername(userDto.getUsername());
    }
    if (userDto.getNom()!=null){
      user.setNom(userDto.getNom());
    }

    userRepository.save(user);
  }

  @Override
  public Caissier findByNom(String nom) {
    return null;
  }

  @Override
  public Caissier save(Caissier caissier) {
    return null;
  }

  @Override
  public Caissier payer(Facture facture) {
    return null;
  }

  @Override
  public Caissier imprimerRecu(PaiementService paiement) {
    return null;
  }

  @Override
  public Employer save(Employer employer) {
    return null;
  }


}
