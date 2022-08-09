package com.example.bank.registration;

import com.example.bank.appuser.AppUser;
import com.example.bank.appuser.AppUserRepository;
import com.example.bank.appuser.AppUserRole;
import com.example.bank.appuser.AppUserService;
import com.example.bank.registration.token.ConfirmationToken;
import com.example.bank.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        String token = appUserService.signUpUser(new AppUser(request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER));

        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }
        appUserService.enableAppUser(confirmationToken.getAppUser());
        return "confirmed";
    }

    public void saveUser(AppUser appUser){
        appUserRepository.save(appUser);
    }


}
