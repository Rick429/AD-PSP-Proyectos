package com.pruebaseguridad.user.service;

import com.pruebaseguridad.services.base.BaseService;
import com.pruebaseguridad.user.dto.CreateUserDto;
import com.pruebaseguridad.user.model.UserEntity;
import com.pruebaseguridad.user.model.UserRole;
import com.pruebaseguridad.user.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service("userDetailsService")
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, UUID, UserEntityRepository> implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.repositorio.findFirstByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(email + " no encontrado"));
    }

    public UserEntity save(CreateUserDto newUser, UserRole role) {
        if (newUser.getPassword().contentEquals(newUser.getPassword2())) {
            UserEntity userEntity = UserEntity.builder()
                    .password(passwordEncoder.encode(newUser.getPassword()))
                    .fullname(newUser.getFullname())
                    .email(newUser.getEmail())
                    .role(role)
                    .build();
            return save(userEntity);
        } else {
            return null;
        }
    }
}
