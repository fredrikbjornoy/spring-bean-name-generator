package no.bjornoy.net.generator.service;

import no.bjornoy.net.generator.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidatorService {

    private final List<Validator> validators;

    @Autowired
    public ValidatorService(List<Validator> validators) {
        this.validators = validators;
    }

    public boolean validate(Validator.Version version, String chars) {
        return validators.stream()
                .filter(r -> version.equals(r.getVersion()))
                .findFirst()
                .map(r -> r.isValid(chars))
                .orElseThrow(() -> new IllegalArgumentException("Invalid version: " + version));
    }
}
