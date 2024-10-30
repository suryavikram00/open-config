package com.openapi.openconfig.utility;


import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.openapi.openconfig.entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JwtTokenUtils {

    private static final String API_KEY = "apikey"; // salt

    // 20 mts from the token is created
    private static final Long EXPIRATION_MILLI_SECOND = (long) 1800000;

    private static final String ISSUER = "template-engine.com"; // merchant_key

    static Long userId = null;

//    static String permissionDetails = null;

    static String userEmailId = null;

    public String createJWT(UserEntity userEntity) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(API_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = null;
        builder = Jwts.builder().setId(userEntity.getId().toString()).setIssuedAt(now)
                .setSubject(userEntity.getEmail()).setIssuer(ISSUER)
                .signWith(signatureAlgorithm, signingKey);

        if (EXPIRATION_MILLI_SECOND >= 0) {
            long expMillis = nowMillis + EXPIRATION_MILLI_SECOND;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
    
    public static Long getLoggedInUserId() {
        return userId;
    }
    
    public static String getLoggedInUserEmail() {
        return userEmailId;
    }

    public boolean parseJWT(String jwt) {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(API_KEY))
                    .parseClaimsJws(jwt).getBody();
            Date date = new Date();
            if (claims.getExpiration().before(date)) {
                return false;
            }
            userId = Long.parseLong(claims.getId());
            userEmailId = claims.getSubject().toString();
        } catch (Exception e) {
            return false;
        }
        return true;

    }
   

}
