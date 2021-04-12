package de.exxcellent.challenge.service.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileServiceTest {
    FileService csvService = new CSVFileService();

    @Test
    void notThrown() {
        assertDoesNotThrow(() -> csvService.readFile("weather.csv"));
    }

    @Test
    void throwExceptionWrongPath() {
        assertThrows(Exception.class, () -> csvService.readFile("weather.csvXXX"));
    }

    @Test
    void throwExceptionWrongData() {
        assertThrows(Exception.class, () -> csvService.readFile("weatherWrongData.csv"));
    }

    @Test
    void returnNotNullList() {
        try {
            assertNotNull(csvService.readFile("weather.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void readAllLines() {
        try {
            assertEquals(31, csvService.readFile("weather.csv").size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
