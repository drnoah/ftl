package generators;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWritingService {

    private static final String BASE_FOLDER = "target/";
    private static final String MAIN_CODE_BASE_PATH = BASE_FOLDER + "src/main/";
    private static final String TEST_CODE_BASE_PATH = BASE_FOLDER + "src/test/";

    public void writeMainCode(String fileName, String fileContent) throws IOException {
        writeFile(MAIN_CODE_BASE_PATH, fileName, fileContent);
    }

    public void writeTestCode(String fileName, String fileContent) throws IOException {
        writeFile(TEST_CODE_BASE_PATH, fileName, fileContent);
    }


    private void writeFile(String codePath, String fileName, String fileContent) throws IOException {
        var path = Paths.get(codePath);
        Files.createDirectories(path);
        var filePath = path.resolve(fileName);
        Files.writeString(filePath, fileContent);
    }
}
