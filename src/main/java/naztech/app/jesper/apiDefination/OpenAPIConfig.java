package naztech.app.jesper.apiDefination;/*
 * ==============================================================
 * @Project: jesper
 * File: OpenAPIConfig
 * Created: 1/16/2025
 * Author: DURJOY ACHARJYA
 * Email: da-durjoy@outlook.com
 * ==============================================================
 *
 * Copyright (c) 2025, naztech.inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * naztech.inc. You shall not disclose such confidential information
 * and shall use it only in accordance with the terms of the license
 * agreement you entered into with naztech.inc.
 *
 * ==============================================================
 */

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Book Reader Application API",
                version = "1.0.0",
                description = "API documentation for Book Reader Application",
                contact = @Contact(
                        name = "Durjoy Acharjya",
                        email = "da-durjoy@outlook.com"

                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )



        ),
servers = {
@Server(url = "${api.server.url:http://localhost:9090}", description = "Local Server"),
@Server(url = "${api.prod.server.url:https://api.bookreader.com}", description = "Production Server")
        },
externalDocs = @ExternalDocumentation(
        description = "More API Documentation",
        url = "${api.externalDocs.url:https://docs.bookreader.com}"
)

)
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Jesper API Documentation")
                        .version("1.0")
                        .description("API documentation for Jesper application")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Durjoy Acharjya")
                                .email("da-durjoy@outlook.com")))
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)
                                        .name("Authorization")));
    }

}
