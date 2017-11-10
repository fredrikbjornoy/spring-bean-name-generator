# spring-bean-name-generator
In some cases it is desirable to have several Spring Beans with the same name. E.g this application has two classes named `CharacterValidator`
that are annoted with Spring's `@Component`. Spring will try to create two beans named `characterValidator` and fail at startup with an 
exception similar to this `org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'characterValidator'`.

To prevent this, `CustomBeanNameGenerator` overrides `generateBeanName` like this:
```java
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
```

By doing it like this, we make sure that all classes that implement the `no.bjornoy.net.generator.validator.Validator` interface will get a unique bean name i.e it's fully qualified name.