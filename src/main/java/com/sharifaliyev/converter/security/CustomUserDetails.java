package com.sharifaliyev.converter.security;

import com.sharifaliyev.converter.entities.Person;
import com.sharifaliyev.converter.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = personRepository.findByEmail(username);
        if(user == null) {
            throw  new UsernameNotFoundException("User with email " + username + " not found!");
        }

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
