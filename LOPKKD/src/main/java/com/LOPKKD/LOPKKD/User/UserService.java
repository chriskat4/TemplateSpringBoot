package com.LOPKKD.LOPKKD.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.LOPKKD.LOPKKD.Exception.UserNotFoundException;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAllUsers();
    }

    public User getUserById(UUID id) throws UserNotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not found!"));
    }

    public User getUserByEmail(String email) throws UserNotFoundException{
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User Not found!"));
    }

    public User saveUser(UserSaveRequest userReq){
        User user = User.builder()
            .name(userReq.name())
            .email(userReq.email())
            .password(userReq.password())
            .role(userReq.userRole())
            .build();
        return userRepository.save(user);
    }

    public User updateUser(UserUpdateRequest userReq) throws UserNotFoundException{
        User user = userRepository.findById(userReq.id()).orElseThrow(() -> new UserNotFoundException("User Not found!"));
        user = User.builder()
            .id(userReq.id())
            .name(userReq.name())
            .email(userReq.email())
            .password(userReq.password())
            .role(userReq.userRole())
            .build();
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) throws UserNotFoundException{
        if(userRepository.findById(id) == null){new UserNotFoundException("User Not found!");}
        userRepository.deleteById(id);
    }
}

