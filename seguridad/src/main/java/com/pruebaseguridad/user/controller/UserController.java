package com.pruebaseguridad.user.controller;

import com.pruebaseguridad.user.dto.CreateUserDto;
import com.pruebaseguridad.user.dto.GetUserDto;
import com.pruebaseguridad.user.dto.UserDtoConverter;
import com.pruebaseguridad.user.model.UserEntity;
import com.pruebaseguridad.user.model.UserRole;
import com.pruebaseguridad.user.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserEntityService userEntityService;
    private final UserDtoConverter userDtoConverter;

    @PostMapping("/auth/register")
    public ResponseEntity<GetUserDto> nuevoUsuario(@RequestBody CreateUserDto newUser, @PathVariable String role) {
        UserRole userRole = UserRole.valueOf(role.toUpperCase());
        UserEntity saved = userEntityService.save(newUser, userRole);

        if(saved == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(userDtoConverter.convertUserEntityToGetUserDto(saved));
    }
}
