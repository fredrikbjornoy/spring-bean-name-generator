package no.bjornoy.net.generator;

import no.bjornoy.net.generator.validator.Validator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;

import java.util.Arrays;

public class CustomBeanNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        if (definition instanceof ScannedGenericBeanDefinition) {
            String[] interfaceNames = ((ScannedGenericBeanDefinition) definition).getMetadata().getInterfaceNames();

            if (Arrays.stream(interfaceNames)
                    .anyMatch(Validator.class.getTypeName()::equals)) {
                return definition.getBeanClassName();
            }
        }

        return super.generateBeanName(definition, registry);
    }
}
