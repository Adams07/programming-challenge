package de.exxcellent.challenge.service.file;

import java.util.List;

public interface FileService {
    List<List<String>> readFile(String path);
}
