package com.ssafy.fit.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.User;
import com.ssafy.fit.model.service.UserService;
import com.ssafy.fit.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags ="유저 컨트롤러")
@RequestMapping("/api-user")
public class UserRestController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    //전체 유저 불러오기 -> 관리자 있으면 사용
    @GetMapping("users")
    public List<User> userList() {
        return userService.getUserList();
    }
    
    
    //아이디로 유저 찾기
    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        User user =  userService.searchById(id);
        if(user != null)
            return new ResponseEntity<User>(user,HttpStatus.OK);
        else
            return new ResponseEntity<String>("아이디에 해당하는 사용자가 없습니다.",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //로그인
    //user 이용해서 service -> dao -> db 통해 실제 확인    
    @GetMapping("/login")
    @ApiOperation(value = "id, password가 일치하는 경우 로그인", response = User.class)
    public ResponseEntity<Map<String, Object>> doLogin(User user){
                
        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println(user);
            
        HttpStatus status = null;
            
        try {                
            if(user != null) {
                User loginUser = userService.searchById(user.getId());
                    System.out.println(loginUser);
                if (loginUser.getPassword().equals(user.getPassword())){
                    user.setName(loginUser.getName());
                        
                    //얘도 저장해야하는지
                    result.put("access-token", jwtUtil.createAccessToken("id", "nickName",user.getId(),loginUser.getNickName()));
                    result.put("refresh-token",jwtUtil.createRefreshToken(user.getId()));
                    //세션에 access + refreshToken저장
//                    response.addCookie(new Cookie("access-token", jwtUtil.createAccessToken("id", "nickName",user.getId(),loginUser.getNickName())));
    //                response.addCookie(new Cookie("refresh-token", jwtUtil.createRefreshToken(user.getId())));
                    //session.setAttribute("access-token", jwtUtil.createAccessToken("id", "nickName",user.getId(),loginUser.getNickName()));
                    //session.setAttribute("refresh-token", jwtUtil.createRefreshToken(user.getId()));
                    
                    result.put("user", loginUser);
                    result.put("message", "login success");
                    status = HttpStatus.ACCEPTED;
                        
                } else {
                    result.put("message", "not this password");
                    status = HttpStatus.NO_CONTENT;
                }
            } else {
                result.put("message", "no match this id");
                status = HttpStatus.NO_CONTENT;
            }
                
        } catch(UnsupportedEncodingException e) {
            result.put("message", "sever_error");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
            
        return new ResponseEntity<Map<String, Object>>(result, status);
            
    }
        
    //유저등록 
    @PostMapping("signup")
    public ResponseEntity<?> signup(User user) {
        int result = userService.signup(user);
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
        
    }
    
    //로그아웃 다시 구현해야함
    @GetMapping("logout")
    public ResponseEntity<?> logout(HttpSession session){
        //토큰 만료시키기로 변경

        //access토큰 있는지 찾기
        //토큰에서 유효기간의 정보를 가져와서 0으로 만들기 ->고냥 없애버림
        String token = (String) session.getAttribute("access-token");
        
        if (token != null) {
            //만료시키기....
            session.removeAttribute("access-token");
            return new ResponseEntity<String>("logout success", HttpStatus.OK);
        }
        
        //refreshToken 만료시켜야함
//        session.invalidate();
//        boolean result = true;
//        try {
//            result = jwtUtil.isTokenExpired(token);
//            System.out.println(result);
//        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
//                | IllegalArgumentException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return new ResponseEntity<String>("error!",HttpStatus.BAD_REQUEST);
//        }
        //ㅠㅠ 계속 로그아웃 됐다고 뜬다...

        return new ResponseEntity<String>("logout fail",HttpStatus.BAD_REQUEST);        
        
    }
    
    //회원 수정
    @PutMapping("/user/{id}")
    public ResponseEntity<String> update(User user) {
        userService.modifyUser(user);
        return new ResponseEntity<String>("update user success", HttpStatus.OK);
    }
    
    //아이디 중복체크
    @GetMapping("/idCheck")
    public ResponseEntity<?> idCheck(String id) throws UnsupportedEncodingException {
        System.out.println(id);
        int result = userService.idCheck(id);
        if(result != 0)
            return new ResponseEntity<String> ("you can't use duplicated id", HttpStatus.OK);
        return new ResponseEntity<String> ("you can use this id", HttpStatus.OK);
    }
    
    //닉네임 중복체크
    @GetMapping("/nickNameCheck")
    public ResponseEntity<?> nickNameCheck(String nickName) throws UnsupportedEncodingException {
        //nickName 디코딩 해야함 한글이니까~
        int result = userService.nickNameCheck(URLDecoder.decode(nickName, "UTF-8"));
        if(result != 0)
            return new ResponseEntity<String> ("you can't use duplicated nickName", HttpStatus.OK);
        return new ResponseEntity<String> ("you can use this nickName", HttpStatus.OK);
    }
    
    //이메일 중복체크
    @GetMapping("/emailCheck")
    public ResponseEntity<?> emailCheck(String email) {
        int result = userService.emailCheck(email);
        if(result != 0)
            return new ResponseEntity<String> ("you can't use duplicated email", HttpStatus.OK);
        return new ResponseEntity<String> ("you can use this email", HttpStatus.OK);
    }    
    
    //회원탈퇴?
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        if (userService.removeUser(id)) {
            return new ResponseEntity<String>("delete success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("delete fail", HttpStatus.NO_CONTENT);
    }
    
    //토큰 해석....
    @GetMapping("/decode")
    public String decodeToken(String token){
        System.out.println(token);
        return jwtUtil.decodeToken(token); 
    }
}
