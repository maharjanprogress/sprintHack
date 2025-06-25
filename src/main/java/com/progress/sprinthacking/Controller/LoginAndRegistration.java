package com.progress.sprinthacking.Controller;

import com.progress.sprinthacking.DTO.LoginDTO;
import com.progress.sprinthacking.DTO.ResponseDTO;
import com.progress.sprinthacking.DTO.UserDTO;
import com.progress.sprinthacking.Services.Impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAndRegistration {
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        ResponseDTO responseDTO = userService.verify(loginDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = userService.createUser(userDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
