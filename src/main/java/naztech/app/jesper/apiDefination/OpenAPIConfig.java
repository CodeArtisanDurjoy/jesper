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

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Book Reader Application API",
                version = "1.0.0",
                description = "API documentation for Book Reader Application",
                contact = @Contact(
                        name = "Developer Support",
                        email = "da-durjoy@outlook.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class OpenAPIConfig {


}
