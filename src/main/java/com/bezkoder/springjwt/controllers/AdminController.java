package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.Dto.UserDto;
import com.bezkoder.springjwt.models.Caissier;
import com.bezkoder.springjwt.models.Employer;
import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.FactureRepo;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
  @Autowired
  private UserService userService;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private FactureRepo factureRepo;

  @GetMapping(path = "/Users")
  public List<User> getUsers() {
    return this.userService.findAll();
  }
  @DeleteMapping("/Users/{id}")
  public String deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
    return "User deleted successfully.";
  }
  @PutMapping(path = "/updateuser")
  public String update(@RequestBody UserDto userDto) throws IOException {
    userService.updateUser(userDto);
    return "update ok ";
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<User> getTutorialById(@PathVariable("id") long id) {
    Optional<User> userData = userRepository.findById(id);

    if (userData.isPresent()) {
      return new ResponseEntity<>(userData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
