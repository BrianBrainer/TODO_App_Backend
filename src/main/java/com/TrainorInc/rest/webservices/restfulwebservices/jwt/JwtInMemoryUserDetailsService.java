package com.TrainorInc.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;

import com.TrainorInc.rest.webservices.restfulwebservices.user.UserEntity;
import com.TrainorInc.rest.webservices.restfulwebservices.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
                "2a$10$VzPfrB6DexbWj/.9Zu/uvefTtpAMEckewo/HCwin020wwLNWckVIi", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(2L, "Ryan",
                "$2a$10$VzPfrB6DexbWj/.9Zu/uvefTtpAMEckewo/HCwin020wwLNWckVIi", "ROLE_USER_2"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findUserByUsername(username);

        if (null == userEntity) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return userEntity;
    }

}
