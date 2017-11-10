package no.bjornoy.net.generator.service;

import no.bjornoy.net.generator.CustomBeanNameGenerator;
import no.bjornoy.net.generator.validator.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class ValidatorServiceTest {

    @Autowired
    private ValidatorService validatorService;

    @Test
    public void testValidate() throws Exception {
        assertTrue(validatorService.validate(Validator.Version.V1, "fredrik"));
    }

    @Configuration
    @ComponentScan(value = {
            "no.bjornoy.net.generator.service",
            "no.bjornoy.net.generator.validator"
    }, nameGenerator = CustomBeanNameGenerator.class)
    static class Config {

    }

}