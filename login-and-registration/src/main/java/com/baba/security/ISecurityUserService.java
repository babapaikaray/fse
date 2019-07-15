package com.baba.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
