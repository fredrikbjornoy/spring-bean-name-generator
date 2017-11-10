package no.bjornoy.net.generator.validator.v2;

import no.bjornoy.net.generator.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class CharacterValidator implements Validator {

    @Override
    public boolean isValid(String chars) {
        return chars != null && chars.length() > 2;
    }

    @Override
    public Version getVersion() {
        return Version.V2;
    }
}
