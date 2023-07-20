package com.ssafy.fit.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {

	private static final String SALT = "SSAFIT";
	private long tokenValidTime = 30 * 50 * 1000L;
	
	//id, 무슨 토큰인지, 유효기간
//	private String create(String id, String subject, long expireMin) throws UnsupportedEncodingException{
//		 JwtBuilder builder = Jwts.builder()
//				   					.setHeaderParam("alg", "HS256")
//				   					.setHeaderParam("typ", "JWT") // 헤더끝
//				   					.setSubject(subject)
//				   					.setExpiration(new Date(System.currentTimeMillis()+expireMin)); // 유효기간, 페이로드 완료	
//		
//		//null이면 refreshtoken
//		if (id !=null) {		   					
//				   builder.claim("user", id);
//		}
//
//		builder.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"));
//		
//		//직렬화 처리
//		return builder.compact();
//	}
	
	//30분
	// 토큰 생성
	// 인자로 키와 밸류가 넘어왔다라고만 처리
	public String createAccessToken(String claimId, String claimNickName, String id, String nickName ) throws UnsupportedEncodingException {
		
		return Jwts.builder()
				   .setHeaderParam("alg", "HS256")
				   .setHeaderParam("typ", "JWT") // 헤더끝
				   .claim(claimNickName, nickName)
				   .claim(claimId, id)
				   .setExpiration(new Date(System.currentTimeMillis()+tokenValidTime)) // 유효기간, 페이로드 완료
				   .signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
				   .compact();
		
	}
	
	//유효기간은 accesstoken의 5배
	public String createRefreshToken(String id) throws UnsupportedEncodingException {
		
		return Jwts.builder()
				   .setHeaderParam("alg", "HS256")
				   .setHeaderParam("typ", "JWT") // 헤더끝
				   .claim("userId",id)
				   .setExpiration(new Date(System.currentTimeMillis()+tokenValidTime*5)) // 유효기간, 페이로드 완료
				   .signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
				   .compact();
	}
	
	//액세스 토큰 날라갔을 때 리프레시 토큰 있으면 리프레시 토큰 반환 ->프론트
	
	//토큰 있으면 읽어와서 반환 ->프론트에서 토큰 보내고 백에서 읽어서 보내기 -> 프론트에서 닉네임 아이디 잘라오기
	public String decodeToken(String token) {
		return new String(Base64.getDecoder().decode(token.split("\\.")[1]));
	}

	
	// 유효성 검사
	public void validCheck(String token) throws Exception {
		Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
	}
	
	//토큰 만료시간 불리언 반환
	public Boolean isTokenExpired(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException{
		 Date expiration = Jwts.parser()
		          .setSigningKey("SSAFIT".getBytes("UTF-8"))
		          .parseClaimsJws(token)
		          .getBody()
		          .getExpiration();
		 
		 //지금 시간이 expiration보다 전이면 true
		 return expiration.before(new Date());
	}	


	
	
}
