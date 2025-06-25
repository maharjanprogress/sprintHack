package com.progress.sprinthacking.Services.Impl;

import com.progress.sprinthacking.DTO.LoginDTO;
import com.progress.sprinthacking.DTO.ResponseDTO;
import com.progress.sprinthacking.DTO.UserDTO;

public interface IUserService {
    ResponseDTO createUser(UserDTO userDTO);
    ResponseDTO updateUser(Long id,UserDTO userDTO);
    ResponseDTO deleteUser(Long id);
    ResponseDTO getUserById(Long id);
    ResponseDTO getAllUsers();
    ResponseDTO verify(LoginDTO dto);
}
