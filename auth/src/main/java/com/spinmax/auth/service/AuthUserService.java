package com.spinmax.auth.service;

import com.spinmax.auth.dto.AuthUserDto;
import com.spinmax.auth.entity.AuthUser;
import com.spinmax.auth.entity.TokenDto;

public interface AuthUserService {

    public AuthUser save(AuthUserDto authUserDto);

    public TokenDto login(AuthUserDto authUserDto);

    public TokenDto validate(String token);

}
