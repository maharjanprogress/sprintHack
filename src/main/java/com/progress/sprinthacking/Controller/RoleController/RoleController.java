package com.progress.sprinthacking.Controller.RoleController;

import com.progress.sprinthacking.DTO.ResponseDTO;
import com.progress.sprinthacking.DTO.RoleDTO;
import com.progress.sprinthacking.Services.Impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @PostMapping("/createRole")
    public ResponseEntity<ResponseDTO> createRole(@RequestBody RoleDTO roleDTO) {
        ResponseDTO responseDTO = roleService.createRole(roleDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
