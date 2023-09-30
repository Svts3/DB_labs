package ua.lviv.iot.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ua.lviv.iot.service.OwnerService;
import ua.lviv.iot.service.RoleService;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    private OwnerService ownerService;

    private RoleService roleService;

    public String generateToken(UserDetails userDetails) {
        Date expirationDate = new Date(System.currentTimeMillis() + jwtExpiration);
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(expirationDate).signWith(getSigningKey())
                .compact();
    }

    public String extractEmailFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token)
                .getBody().getSubject();
    }

    public Boolean TokenIsValid(String token) {

        Date expirationDate = Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token)
                .getBody().getExpiration();
        return new Date().before(expirationDate);
    }

    public Key getSigningKey() {
        byte[] bytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(bytes);
    }


}
