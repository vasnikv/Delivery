package ru.iv.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.iv.entity.Person;
import ru.iv.repository.PersonsRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class DeliveryUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonsRepository personsRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Person person = personsRepository.findByLogin(login);

        if(person == null) {
            throw new UsernameNotFoundException(login + " не найден");
        }
//        if(person.getDismDate() != null) {
//            throw new UsernameNotFoundException(login + " уволен");
//        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(person.getRole()));

        return new User(person.getLogin(), person.getPassword(), authorities);
//        return new User(person.getLogin(), person.getPassword(), person.getDismDate() != null, person.getDismDate() != null, true, person.getDismDate() != null, authorities);
    }
}
