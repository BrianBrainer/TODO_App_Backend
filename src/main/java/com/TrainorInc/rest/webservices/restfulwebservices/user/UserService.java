package com.TrainorInc.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends JpaRepository<UserEntity, Long> {
//   @Query(value = "Select id From user WHERE username = :username")
//    public User findUserByUsername(@Param("username") String username);

    public UserEntity findUserByUsername(String username);
}
