package com.LOPKKD.LOPKKD.User;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Table(name = "user_tb")
public class User{
    @Id
    @GeneratedValue
    UUID id;

    @Column(unique = true, nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    String password;

    @Column(unique = true, nullable = false)
    String email;
    
}
