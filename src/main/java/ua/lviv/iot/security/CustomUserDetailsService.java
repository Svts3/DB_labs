package ua.lviv.iot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.service.OwnerService;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private OwnerService ownerService;

    @Autowired
    public CustomUserDetailsService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Owner owner = ownerService.findByEmail(username);
        return new User(owner.getEmail(), owner.getPassword(), Arrays.asList(
                new SimpleGrantedAuthority(owner.getRole().getName())));
    }
}
