package fr.bemore.sec;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * This Interface represents the securities params.
 *
 * @author Omar Moalla
 * @version 1.0
 */
public class SecurityParams {
    public static final String JWT_HEADER_NAME = "Authorization";
    public static final String SECRET = "omar.moalla@bemore.com";
    public static final long EXPIRATION = 10 * 24 * 3600;
    public static final String HEADER_PREFIX = "Bearer ";

    public static void addAuthentication(HttpServletResponse res, String username) {

        String jwt = createToken(username);

        res.addHeader(JWT_HEADER_NAME, HEADER_PREFIX + " " + jwt);
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String jwtToken = request.getHeader(SecurityParams.JWT_HEADER_NAME);
        System.out.println("Token=" + jwtToken);
        if (jwtToken != null) {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParams.SECRET)).build();
            String jwt = jwtToken.substring(SecurityParams.HEADER_PREFIX.length());
            DecodedJWT decodedJWT = verifier.verify(jwt);
            System.out.println("JWT=" + jwt);

            String username = decodedJWT.getSubject();
            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
            System.out.println("username=" + username);
            System.out.println("roles=" + roles);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            roles.forEach(rn -> {
                authorities.add(new SimpleGrantedAuthority(rn));
            });
            return username != null ?
                    new UsernamePasswordAuthenticationToken(username, null, authorities) :
                    null;
        }
        return null;
    }

    public static String createToken(String username) {
        List<String> roles = new ArrayList<String>();
            roles.add("USER");
        if (username == "bemore_admin"){

            roles.add("ADMIN");
        }
        String[] rolesA = new String[roles.size()];
         String jwt = JWT.create().withSubject(username)
                        .withArrayClaim("roles",roles.toArray(rolesA))
                        .withExpiresAt(new Date(System.currentTimeMillis() + SecurityParams.EXPIRATION))
                        .sign(Algorithm.HMAC256(SecurityParams.SECRET));

        return "Bearer "+jwt;
    }


}
