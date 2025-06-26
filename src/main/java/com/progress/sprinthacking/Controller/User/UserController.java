package com.progress.sprinthacking.Controller.User;

import com.progress.sprinthacking.DTO.ResponseDTO;
import com.progress.sprinthacking.Services.Impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllUser(){
        ResponseDTO responseDTO = userService.getAllUsers();
        return ResponseEntity.ok(responseDTO);
    }
}
