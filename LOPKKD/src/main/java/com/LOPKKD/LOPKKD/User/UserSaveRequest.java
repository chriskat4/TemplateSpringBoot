package com.LOPKKD.LOPKKD.User;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserSaveRequest(
                                @NotEmpty(message="name shouldn't be null")
                                String name,

                                @NotEmpty(message="email shouldn't be null")
                                @Email(message="email should be an valid email")
                                String email,

                                @NotEmpty(message="password shouldn't be null")
                                String password,

                                @NonNull
                                UserRoles userRole
) {

}
