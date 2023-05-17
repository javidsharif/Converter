package com.sharifaliyev.converter.services;

import com.sharifaliyev.converter.dto.UserRegistrationDto;
import com.sharifaliyev.converter.entities.Person;
import com.sharifaliyev.converter.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonRepository personRepository;

    public Person save(UserRegistrationDto registrationDto) {
        if(registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            Person user = new Person();
            user.setEmail(registrationDto.getEmail());
            user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            return personRepository.saveAndFlush(user);
        }
        return null;
    }

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Person getCurrentUser(){
        return personRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
