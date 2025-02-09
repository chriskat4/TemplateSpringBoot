package com.LOPKKD.LOPKKD.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LOPKKD.LOPKKD.Exception.UserNotFoundException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Api/User")
@Transactional
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) throws UserNotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(email));
    }



    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserSaveRequest userReq){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userReq));
    }



    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody UserUpdateRequest userReq) throws UserNotFoundException{
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(userReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User Excluido!");
    }
}
