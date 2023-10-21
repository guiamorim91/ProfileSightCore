package com.guiamorim91.ProfileSightCore.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("ProfileSightCore")
                                .description("O ProfileSightCore é o núcleo de backend do sistema ProfileSight, uma plataforma inovadora de análise comportamental. O sistema foi desenvolvido para fornecer insights precisos sobre os perfis comportamentais dos indivíduos, permitindo uma melhor compreensão de suas características e comportamentos.")
                                .version("0.0.1-SNAPSHOT")
                                .termsOfService("Este software é destinado apenas para uso não comercial. Apesar da licença não proibir explicitamente o uso comercial, solicitamos que respeite esta intenção.")
                                .license(new License()
                                        .name("GNU Affero General Public License v3 (AGPLv3)")
                                        .url("https://www.gnu.org/licenses/agpl-3.0.en.html"))
                ).externalDocs(new ExternalDocumentation()
                        .description("Guilherme Amorim")
                        .url("https://github.com/guiamorim91"));
    }
}
