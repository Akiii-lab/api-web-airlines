
package ProgramacionWeb.security.jwt;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtil {

    private static Logger log = LoggerFactory.getLogger(JwtUtil.class);
    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expirationMs}")
    private String jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserDetails userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();

    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()
                    .setSigningKey(key())
                    .build()
                    .parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Ivalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is supported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("Jwt Claim string is empty: {}", e.getMessage());
        }
        return false;

    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(key()).build()
                .parseClaimsJwt(token).getPayload().getSubject();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
}