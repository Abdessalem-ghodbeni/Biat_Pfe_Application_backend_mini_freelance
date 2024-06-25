package com.biat.biat.Services.IServices;

import com.biat.biat.Entites.Agent;
import com.biat.biat.Entites.AuthenticationResponse;
import com.biat.biat.Entites.RefreshTokenRequest;


import java.util.HashMap;

public interface IAuthenticationServices {
Agent RegisterAgent(Agent agent);
    AuthenticationResponse login(String email, String password);
    AuthenticationResponse refreshToken(RefreshTokenRequest refreshToken);
    HashMap<String,String> forgetPassword(String email);
    HashMap<String,String> resetPassword(String passwordResetToken, String newPassword);
}
