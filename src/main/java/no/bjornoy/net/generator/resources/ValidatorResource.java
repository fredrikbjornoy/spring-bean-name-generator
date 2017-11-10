package no.bjornoy.net.generator.resources;

import no.bjornoy.net.generator.service.ValidatorService;
import no.bjornoy.net.generator.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorResource {

    private final ValidatorService validatorService;

    @Autowired
    public ValidatorResource(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @GetMapping("/{version}/{chars}")
    public ResponseEntity<Boolean> validate(@PathVariable("version") String version, @PathVariable("chars") String chars) {
        return ResponseEntity.ok(validatorService.validate(Validator.Version.valueOf(version.toUpperCase()), chars));
    }
}
