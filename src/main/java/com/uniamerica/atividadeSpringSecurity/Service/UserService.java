package com.uniamerica.atividadeSpringSecurity.Service;

import com.uniamerica.atividadeSpringSecurity.Entity.UserEntity;
import com.uniamerica.atividadeSpringSecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var userEntity = repository.findByUsername(username);
            System.out.println(userEntity.getUsername());
            return (UserDetails) userEntity;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuário não localizado");
        }
    }

}