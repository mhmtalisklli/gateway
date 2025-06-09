package eba.rich.gateway.util;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "U7y1eE3t1Kp9rLmVzA1casljhlasgajjnoojaaDeFgHiJkLmnO";

    public String extractUsername(String token) {
        return Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;    
        } catch (Exception e) {
            return false;
        }
    }
}
