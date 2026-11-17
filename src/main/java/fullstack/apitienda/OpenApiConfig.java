package fullstack.apitienda;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("The One Page API - Backend Spring Boot")
                        .version("1.0")
                        .description("Documentación interactiva de la API REST para la tienda y panel de administración de manga."));
    }
}
