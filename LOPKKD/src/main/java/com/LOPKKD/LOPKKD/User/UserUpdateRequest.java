package com.LOPKKD.LOPKKD.User;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserUpdateRequest(
                                @NotEmpty(message="message shouldn't be null")
                                UUID id,
                                @NotEmpty(message="name shouldn't be null")
                                String name,
                                @NotEmpty(message="email shouldn't be null")
                                @Email(message="email should be an valid email")
                                String email,
                                @NotEmpty(message="password shouldn't be null")
                                String password
) {

}
