package ecommerce.server.global.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    //http://localhost:8080/swagger-ui/index.html
    @Bean
    fun openApi():OpenAPI{
        return OpenAPI()
            .components(Components())
            .info(apiInfo())
    }

    private fun apiInfo(): Info {
        return Info()
            .title("e-커머스 서비스")
            .description("e-커머스 시스템의 백엔드 API Swagger Documentation")
            .version("1.0.0")
    }
}