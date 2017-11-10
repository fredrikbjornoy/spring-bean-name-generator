package no.bjornoy.net.generator.validator;

public interface Validator {

    boolean isValid(String chars);

    Version getVersion();

    enum Version {
        V1,
        V2,
    }
}
