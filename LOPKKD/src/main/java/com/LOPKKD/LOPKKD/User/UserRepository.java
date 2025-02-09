package com.LOPKKD.LOPKKD.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, UUID>{
    //@Query(value = "SELECT * FROM table WHERE id = :id", nativeQuery = true)
    //Type FuncName(Type id);
    @Query(value = "SELECT * FROM user_tb", nativeQuery = true)
    List<User> findAllUsers();

    @Query(value = "SELECT * FROM user_tb WHERE email = :email", nativeQuery = true)
    Optional<User> findUserByEmail(String email);
}
