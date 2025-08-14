package core.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileHelper {
    public static String readJsonFileAsString(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read JSON-file path => : " + filePath, e);
        }
    }
}
