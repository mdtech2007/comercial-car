package com.md.car.security.services;

import com.md.car.security.models.SecureToken;

public interface SecureTokenService {

    SecureToken createToken();

    void saveSecureToken(SecureToken secureToken);

    SecureToken findByToken(String token);

    void removeToken(SecureToken token);
}
