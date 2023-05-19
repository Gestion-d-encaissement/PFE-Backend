package com.bezkoder.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.payload.request.LoginEmpCaisRequest;
import com.bezkoder.springjwt.payload.request.SignupEmpCaisRequest;
import com.bezkoder.springjwt.repository.EmpCaisRepo;
import com.bezkoder.springjwt.repository.EmpCaisRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.request.SignupRequest;
import com.bezkoder.springjwt.payload.response.JwtResponse;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;
  @Autowired
  EmpCaisRepo empCaisRepo;
  @Autowired
  EmpCaisRepo2 empCaisRepo2;
  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;


  //login admin
  @PostMapping("/signinadmin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
                         userDetails.getId(),
                         userDetails.getUsername(),
                         userDetails.getCodeagence(),
                         roles));
  }


  // login   caissier
  @PostMapping("/signinCais")
  public ResponseEntity<?> authenticateCais(@Valid @RequestBody LoginEmpCaisRequest loginEmpCaisRequest) {
    /*
    if (empCaisRepo.isActiveByStatuts(loginEmpCaisRequest.getActiveByStatuts().equals(false))) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: compte desactiver"));
    }
     */

    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(loginEmpCaisRequest.getUsername(), loginEmpCaisRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
      .map(item -> item.getAuthority())
      .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
      userDetails.getId(),
      userDetails.getUsername(),
      userDetails.getCodeagence(),
      roles));
  }
  // login employe
  @PostMapping("/signinEmp")
  public ResponseEntity<?> authenticateEmp (@Valid @RequestBody LoginEmpCaisRequest loginEmpCaisRequest) {
    /*
    if (empCaisRepo.isActiveByStatuts(loginEmpCaisRequest.getActiveByStatuts().equals(false))) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: compte desactiver"));
    }
     */

    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(loginEmpCaisRequest.getUsername(), loginEmpCaisRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
      .map(item -> item.getAuthority())
      .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
      userDetails.getId(),
      userDetails.getUsername(),
      userDetails.getCodeagence(),
      roles));
  }

/*

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsBycodeagence(signUpRequest.getCodeagence())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
               signUpRequest.getCodeagence(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

*/

  //admin


  @PostMapping("/signupad")
  public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsBycodeagence(signUpRequest.getCodeagence())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: Codeagent is already in use!"));
    }

    // Create new user's account
    Administrateur administrateur = new Administrateur(signUpRequest.getUsername(),
      signUpRequest.getCodeagence(),signUpRequest.getNom(),signUpRequest.getPrenom(),signUpRequest.getMatricule(),
      encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);
      });
    }

    administrateur.setRoles(roles);
    userRepository.save(administrateur);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  //fin admin

//Caisser
  @PostMapping("/signupcai")
  public ResponseEntity<?> registerCais(@Valid @RequestBody SignupEmpCaisRequest signupEmpCaisRequest) {
    if (userRepository.existsByUsername(signupEmpCaisRequest.getUsername())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsBycodeagence(signupEmpCaisRequest.getCodeagence())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: codeagent is already in use!"));
    }

    // Create new user's account
     Caissier caissier = new Caissier(signupEmpCaisRequest.getUsername(),signupEmpCaisRequest.getCodeagence(),
       signupEmpCaisRequest.getNom(),signupEmpCaisRequest.getPrenom(),signupEmpCaisRequest.getMatricule(),
       signupEmpCaisRequest.getAgence(),signupEmpCaisRequest.getActiveByStatuts(),encoder.encode(signupEmpCaisRequest.getPassword()));


    Set<String> strRoles = signupEmpCaisRequest.getRole();
    Set<Role> roles = new HashSet<>();
    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_CAISSIER)
        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        Role adminRole = roleRepository.findByName(ERole.ROLE_CAISSIER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);
      });
    }

    caissier.setRoles(roles);
    userRepository.save(caissier);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  //fin caisser
//employe
  @PostMapping("/signupemp")
  public ResponseEntity<?> registerEmp(@Valid @RequestBody SignupEmpCaisRequest signupEmpCaisRequest) {
    if (userRepository.existsByUsername(signupEmpCaisRequest.getUsername())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsBycodeagence(signupEmpCaisRequest.getCodeagence())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: code agent is already in use!"));
    }

    // Create new user's account
    Employer employer = new Employer(signupEmpCaisRequest.getUsername(),signupEmpCaisRequest.getCodeagence(),
      signupEmpCaisRequest.getNom(),signupEmpCaisRequest.getPrenom(),signupEmpCaisRequest.getMatricule(),
      signupEmpCaisRequest.getAgence(),signupEmpCaisRequest.getActiveByStatuts(),encoder.encode(signupEmpCaisRequest.getPassword()));

    Set<String> strRoles = signupEmpCaisRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_EMPLOYE)
        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        Role adminRole = roleRepository.findByName(ERole.ROLE_EMPLOYE)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);
      });
    }

    employer.setRoles(roles);
    userRepository.save(employer);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  //fin employe

  @GetMapping(path = "/caissier/{id}")
  public Caissier getbyid(@PathVariable("id") Long id){
    return this.empCaisRepo.findById(id).get();
  }
}
