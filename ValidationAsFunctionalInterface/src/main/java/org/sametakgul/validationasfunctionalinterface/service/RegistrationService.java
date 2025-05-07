package org.sametakgul.validationasfunctionalinterface.service;

import org.sametakgul.validationasfunctionalinterface.model.User;
import org.sametakgul.validationasfunctionalinterface.validator.Validator;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final Validator<String> emailValidator;
    private final Validator<String> passwordValidator;

    public RegistrationService(Validator<String> emailValidator,
                               Validator<String> passwordValidator) {
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    public void register(User user) {
        if (!emailValidator.validate(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (!passwordValidator.validate(user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        System.out.println("User registered: " + user.getEmail());
    }
}