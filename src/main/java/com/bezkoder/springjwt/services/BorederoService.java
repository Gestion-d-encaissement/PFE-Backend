package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Bordoreau;
import com.bezkoder.springjwt.models.ParCheque;
import org.springframework.stereotype.Service;

@Service
public interface BorederoService {
  Bordoreau save(Bordoreau bordoreau);
}
