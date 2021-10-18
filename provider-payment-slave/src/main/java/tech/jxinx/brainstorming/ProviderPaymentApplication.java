package tech.jxinx.brainstorming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentApplication.class, args);
    }
}
