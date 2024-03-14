package com.notice.notice.jwt;

import com.notice.notice.user.user;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class jwtSvc {
    private static String KEY_JWT = "AISFJQWIFNQWIFNQWIFNQWIFNWEFENFWIEFDMGNERIGTUGNRTBNLRRNWOIGWNOGEWNFIOEWFNWEKFNDJGORIGJWOGWEJGOEWGJWOEGIJWEOG";
    public String getToken(user user){
        return getTokenPr( user);
    }
    private String getTokenPr( user user){
        Map<String,Object> extraClaims= new HashMap<>();
        extraClaims.put("email",user.getEmail());
        extraClaims.put("roles",user.getRoles()
                .stream().map(role -> role.getName()).toArray());
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(getKey(), io.jsonwebtoken.SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey(){
        byte[] keyBytes= Decoders.BASE64.decode(KEY_JWT);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String getUserNameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }
    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }
    public boolean isTokenValid(String token, String username){
        final String usernameToken= getUserNameFromToken(token);
        return (usernameToken.equals(username) && !isTokenExpired(token));
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username= getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims= getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private boolean isTokenExpired(String token){
        final Date expiration= getExpiration(token);
        return expiration.before(new Date());
    }

}
