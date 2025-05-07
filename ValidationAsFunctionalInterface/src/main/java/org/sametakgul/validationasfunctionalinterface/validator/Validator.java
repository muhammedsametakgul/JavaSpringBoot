package org.sametakgul.validationasfunctionalinterface.validator;

@FunctionalInterface
public interface Validator<T> {
    boolean validate(T t);

    default Validator<T> and(Validator<T> other) {
        return t -> this.validate(t) && other.validate(t);
    }
}
