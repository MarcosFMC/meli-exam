package com.example.mercado_libre_exam.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {
        @Value("${PORT:8080}") // Si PORT no está definida, usa 8080 como predeterminado
        private int port;

        @Bean
        public ServletWebServerFactory servletContainer() {
            TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
            factory.setPort(port);
            return factory;
        }
}
