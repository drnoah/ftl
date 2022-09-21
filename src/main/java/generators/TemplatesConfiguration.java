package generators;


import freemarker.template.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class TemplatesConfiguration {

    @Bean
    public Configuration serviceWithConfigurationConfig() throws IOException {
        var configuration = new Configuration();
        var file = new ClassPathResource("/templates/serviceWithConfiguration/").getFile();
        configuration.setDirectoryForTemplateLoading(file);
        return configuration;
    }
}
