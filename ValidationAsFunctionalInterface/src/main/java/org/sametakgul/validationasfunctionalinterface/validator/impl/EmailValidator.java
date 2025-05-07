package org.sametakgul.validationasfunctionalinterface.validator.impl;

import org.sametakgul.validationasfunctionalinterface.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class EmailValidator implements Validator<String> {

    @Override
    public boolean validate(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }
}
