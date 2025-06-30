package com.progress.sprinthacking.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String password;
    private Long roleId;
    private String email;
}
