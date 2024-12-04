package org.example.aaaaaaaaa.security;

import org.example.aaaaaaaaa.models.AppUser;
import org.example.aaaaaaaaa.repository.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    public CustomUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .build();
    }
}
