import freemarker.template.TemplateException;
import generators.FileWritingService;
import generators.ServiceWithConfigGenerator;
import generators.TemplatesConfiguration;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, TemplateException {
        var baseConfiguration = new TemplatesConfiguration().serviceWithConfigurationConfig();
        var fileWriterService = new FileWritingService();
        new ServiceWithConfigGenerator(baseConfiguration, fileWriterService).generateFiles("com.hsbc.tralala");
    }
}
