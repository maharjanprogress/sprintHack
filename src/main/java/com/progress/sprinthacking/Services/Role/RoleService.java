package com.progress.sprinthacking.Services.Role;

import com.progress.sprinthacking.DTO.ResponseDTO;
import com.progress.sprinthacking.DTO.RoleDTO;
import com.progress.sprinthacking.Entity.Role;
import com.progress.sprinthacking.Repo.RoleRepo;
import com.progress.sprinthacking.Services.Impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public ResponseDTO createRole(RoleDTO roleDTO) {
        Role roleEntity = new Role();
        roleEntity.setRoleAlias(roleDTO.getRoleAlias());
        roleEntity.setRoleName(roleDTO.getRoleName());
        roleEntity.setRemarks(roleDTO.getRemarks());
        roleRepo.save(roleEntity);
        return ResponseDTO.success("Role created successfully");
    }
}
