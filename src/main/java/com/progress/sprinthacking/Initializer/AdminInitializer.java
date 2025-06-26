package com.progress.sprinthacking.Initializer;

import com.progress.sprinthacking.Entity.Role;
import com.progress.sprinthacking.Entity.User;
import com.progress.sprinthacking.Repo.RoleRepo;
import com.progress.sprinthacking.Repo.UserRepo;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminInitializer {
    private static final Logger logger = LoggerFactory.getLogger(AdminInitializer.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @PostConstruct
    @Transactional
    public void createAdminUserIfDoesnotExist() {
        logger.info("Creating admin Role");
        if (roleRepo.findById(1L).isEmpty()){
            Role role = new Role();
            role.setRoleAlias("ADMIN");
            role.setRoleName("System Administrator");
            role.setRemarks("this is the system administrator");
            Role savedRole = roleRepo.save(role);
            logger.info("Admin Role created");
            logger.info("Creating admin user");
            if (userRepo.findByUserName("admin").isEmpty()) {
                User user = new User();
                user.setUserName("admin");
                user.setPasswordHash("admin");
                user.setRole(savedRole);
                userRepo.save(user);
                logger.info("Admin User created");
            }else {
                logger.error("Admin User already exists");
                return;
            }
        }
        else {
            logger.error("Admin Role already exists");
            return;
        }

    }
}
