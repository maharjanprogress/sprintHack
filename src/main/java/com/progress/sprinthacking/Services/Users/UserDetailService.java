package com.progress.sprinthacking.Services.Users;

import com.progress.sprinthacking.Entity.User;
import com.progress.sprinthacking.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = repo.findByUserName(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(users.get());
    }
}
