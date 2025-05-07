package org.sametakgul.validationasfunctionalinterface.validator.impl;

import org.sametakgul.validationasfunctionalinterface.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements Validator<String> {
    @Override
    public boolean validate(String password) {
        return password != null && password.length() >= 8;
    }
}