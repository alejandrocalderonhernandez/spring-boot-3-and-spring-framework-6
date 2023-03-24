package com.debuggeando_ideas.best_travel.infraestructure.services;

import com.debuggeando_ideas.best_travel.domain.entities.documents.AppUserDocument;
import com.debuggeando_ideas.best_travel.domain.repositories.mongo.AppUserRepository;
import com.debuggeando_ideas.best_travel.infraestructure.abstract_services.ModifyUserService;
import com.debuggeando_ideas.best_travel.util.exceptions.UsernameNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class AppUserService implements ModifyUserService, UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public Map<String, Boolean> enabled(String username) {
        var user = this.appUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(COLLECTION_NAME));
        user.setEnabled(!user.isEnabled());
        var userSaved = this.appUserRepository.save(user);
        return Collections.singletonMap(userSaved.getUsername(), userSaved.isEnabled());
    }

    @Override
    public Map<String, Set<String>> addRole(String username, String role) {
        var user = this.appUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(COLLECTION_NAME));
        user.getRole().getGrantedAuthorities().add(role);
        var userSaved = this.appUserRepository.save(user);
        var authorities = userSaved.getRole().getGrantedAuthorities();
        log.info("User {} add role {}", userSaved.getUsername(), userSaved.getRole().getGrantedAuthorities().toString());
        return Collections.singletonMap(userSaved.getUsername(), authorities);
    }

    @Override
    public Map<String, Set<String>> removeRole(String username, String role) {
        var user = this.appUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(COLLECTION_NAME));
        user.getRole().getGrantedAuthorities().remove(role);
        var userSaved = this.appUserRepository.save(user);
        var authorities = userSaved.getRole().getGrantedAuthorities();
        log.info("User {} remove role {}", userSaved.getUsername(), userSaved.getRole().getGrantedAuthorities().toString());
        return Collections.singletonMap(userSaved.getUsername(), authorities);
    }

    private static final String COLLECTION_NAME = "app_user";

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = this.appUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(COLLECTION_NAME));
        return mapUserToUserDetails(user);
    }

    private static UserDetails mapUserToUserDetails(AppUserDocument user) {
       Set<GrantedAuthority> authorities = user.getRole()
               .getGrantedAuthorities()
               .stream()
               .map(SimpleGrantedAuthority::new)
               .collect(Collectors.toSet());
        System.out.println("Authority from db" + authorities);
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorities
        );
    }
}
