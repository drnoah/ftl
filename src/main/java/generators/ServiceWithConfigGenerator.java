package generators;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static java.util.Collections.emptyList;

@RequiredArgsConstructor
public class ServiceWithConfigGenerator implements DependencyGenerator {

    private final Configuration serviceWithConfigurationConfig;
    private final FileWritingService fileWritingService;

    @SneakyThrows
    @Override
    public void generateFiles(String targetPackage)  {
        generateMainCode(targetPackage);

        var serviceTemplate = serviceWithConfigurationConfig.getTemplate("ServiceTest.ftl");
        var input = Map.of("package", targetPackage);

        var stringWriter = new StringWriter();
        serviceTemplate.process(input, stringWriter);
        fileWritingService.writeTestCode("ServiceTest.java", stringWriter.toString());
    }

    private void generateMainCode(String targetPackage) throws IOException, TemplateException {
        var serviceTemplate = serviceWithConfigurationConfig.getTemplate("Service.ftl");
        var input = Map.of("package", targetPackage,
                "imports", emptyList());

        var stringWriter = new StringWriter();
        serviceTemplate.process(input, stringWriter);
        fileWritingService.writeMainCode("Service.java", stringWriter.toString());
    }
}
