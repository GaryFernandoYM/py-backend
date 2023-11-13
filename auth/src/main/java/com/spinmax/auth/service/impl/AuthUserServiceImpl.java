package com.spinmax.auth.service.impl;

import com.spinmax.auth.dto.AuthUserDto;
import com.spinmax.auth.entity.AuthUser;
import com.spinmax.auth.entity.TokenDto;
import com.spinmax.auth.repository.AuthUserRepository;
import com.spinmax.auth.security.JwtProvider;
import com.spinmax.auth.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;
    @Override
    public AuthUser save(AuthUserDto dto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(dto.getUserName());
        if (user.isPresent())
            return null;
        String password = passwordEncoder.encode(dto.getPassword());
        AuthUser authUser = AuthUser.builder()
                .userName(dto.getUserName())
                .password(password)
                .build();
        return authUserRepository.save(authUser);
    }

    @Override
    public TokenDto login(AuthUserDto dto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(dto.getUserName());
        if(!user.isPresent())
            return null;
        if(passwordEncoder.matches(dto.getPassword(), user.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(user.get()));
        return null;
    }

    @Override
    public TokenDto validate(String token) {
        if(!jwtProvider.validate(token))
            return null;
        String username = jwtProvider.getUserNameFromToken(token);
        if(!authUserRepository.findByUserName(username).isPresent())
            return null;
        return new TokenDto(token);
    }
}
