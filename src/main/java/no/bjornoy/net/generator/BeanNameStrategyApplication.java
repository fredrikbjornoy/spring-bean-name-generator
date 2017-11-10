package no.bjornoy.net.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
public class BeanNameStrategyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanNameStrategyApplication.class, args);
    }
}
