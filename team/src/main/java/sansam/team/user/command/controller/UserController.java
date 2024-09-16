package sansam.team.user.command.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.user.command.dto.JwtToken;
import sansam.team.user.command.dto.UserDTO;
import sansam.team.user.command.service.UserService;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //로그인 페이지 진입 호출 메소드
    @GetMapping(value = {"", "/", "/login"})
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("login");
    }

    @PostMapping(value = {"/login"})
    public ResponseEntity<JwtToken> loginProcess(@RequestParam String id, @RequestParam String pw) throws JsonProcessingException {
        JwtToken token = userService.loginProcess(id, pw);
        if(token == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(token);
    }

    @PostMapping(value = {"/join"})
    public ResponseEntity<String> joinProcess(@RequestBody UserDTO userDTO) {
        boolean isJoinMember = userService.joinProcess(userDTO);

        return ResponseEntity.status(isJoinMember ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
                .body(isJoinMember ? "join member successfully" : " Error join member");
    }


}
