package de.exxcellent.challenge.service.file;

import java.io.IOException;
import java.util.List;

public interface FileService {
    List<List<String>> readFile(String path) throws IOException;
}
