package com.example.uzbekinvest_producs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        servers = {@Server(url = "/",description ="Server URL  https:swagger.uzbekinvest.uz" )},
        info = @Info(title = "Products API", version = "1.0", description = "Products Information")
)
public class UzbekinvestProducsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UzbekinvestProducsApplication.class, args);
    }

}
