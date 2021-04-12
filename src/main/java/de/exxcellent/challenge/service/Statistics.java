package de.exxcellent.challenge.service;

import de.exxcellent.challenge.service.file.CSVFileService;
import de.exxcellent.challenge.service.file.FileService;

import java.io.IOException;
import java.util.List;

public abstract class Statistics {
    protected List<String> header;
    protected List<List<String>> data;

    protected Statistics(String filePath) throws IOException {
        FileService fileService = new CSVFileService();
        List<List<String>> fileData = fileService.readFile(filePath);

        this.header = fileData.remove(0);
        this.data = fileData;
    }

}
