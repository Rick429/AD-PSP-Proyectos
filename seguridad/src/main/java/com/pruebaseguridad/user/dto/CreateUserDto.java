package com.pruebaseguridad.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {

    private String username;
    private String fullname;
    private String email;
    private String password;
    private String password2;

}