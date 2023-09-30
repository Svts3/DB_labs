package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.dto.JwtRequest;
import ua.lviv.iot.dto.JwtResponse;
import ua.lviv.iot.dto.LoginRequest;
import ua.lviv.iot.exception.RoleNotFoundException;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.security.CustomUserDetailsService;
import ua.lviv.iot.security.jwt.JwtTokenProvider;
import ua.lviv.iot.service.OwnerService;
import ua.lviv.iot.service.RoleService;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private JwtTokenProvider jwtTokenProvider;

    private OwnerService ownerService;

    private CustomUserDetailsService userDetailsService;

    private RoleService roleService;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(JwtTokenProvider jwtTokenProvider, OwnerService ownerService,
                          CustomUserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager,
                          RoleService roleService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.ownerService = ownerService;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleService = roleService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody JwtRequest request) throws RoleNotFoundException {
        Owner owner = new Owner();
        owner.setGender(request.getGender());
        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setEmail(request.getEmail());
        owner.setPassword(passwordEncoder.encode(request.getPassword()));
        owner.setDateOfBirth(request.getDateOfBirth());
        owner.setRole(roleService.findByName("ROLE_USER"));

        if (ownerService.existsByEmail(owner.getEmail())) {
            return new ResponseEntity<>(String.format("User [%s] already exists", owner.getEmail()),
                    HttpStatus.BAD_REQUEST);
        }
        ownerService.save(owner);
        return ResponseEntity.ok("User was created successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        String jwt = jwtTokenProvider.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(jwt);
        return ResponseEntity.ok(jwtResponse);
    }
}
