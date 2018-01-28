package com.example.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {
   public static void main (String args[]){
       //signToken();
   }

   public String  signToken(){
       String signKey = "test";
       String cwizPayLoad = "{\n" +
               " \n" +
               "  \"userId\":\"test\",\n" +
               "  \"accessToken\":\"0987y-u87@#dghui-lop&tghh\",\n" +
               "  \"applicationAcl\":\n" +
               "    [\n" +
               "      {\n" +
               "      \"name\":\"DEEnvision\",\n" +
               "      \"appId\":\"Xcvd\",\n" +
               "       \"description\":\"The access level the user has on the apllication\",\n" +
               "      \"version\":\"1.0\",\n" +
               "      \"accessLevel\":\"Edit\"\n" +
               "      }\n" +
               "    ]\n" +
               "   \n" +
               "  }";
       String signedToken = Jwts.builder().setSubject(cwizPayLoad).signWith(SignatureAlgorithm.HS512, signKey.getBytes()).compact();
       return signedToken;

   }

   public String verifySignature(String signedToken){
       Claims claim = Jwts.parser().setSigningKey("test".getBytes()).parseClaimsJws(signedToken).getBody();
      return claim.getSubject();
   }
}
