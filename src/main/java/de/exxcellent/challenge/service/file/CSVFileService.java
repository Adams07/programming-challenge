package de.exxcellent.challenge.service.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVFileService implements FileService {
    private static final String RESOURCES_PATH = "src/main/resources/de/exxcellent/challenge/";

    @Override
    public List<List<String>> readFile(String path) throws IOException {
        List<List<String>> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RESOURCES_PATH + path))) {
            String line = reader.readLine();
            while (line != null) {
                String[] values = line.split(",");
                lines.add(Arrays.asList(values));
                line = reader.readLine();
            }
        }

        return lines;
    }
}
