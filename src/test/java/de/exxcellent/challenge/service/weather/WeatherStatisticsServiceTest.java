package de.exxcellent.challenge.service.weather;

import de.exxcellent.challenge.exception.HeaderException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherStatisticsServiceTest {
    WeatherStatisticsService weatherStatisticsService;

    @Test
    void notThrown() {
        try {
            weatherStatisticsService = new WeatherStatisticsService("weather.csv");
        } catch (IOException | HeaderException e) {
            e.printStackTrace();
        }
        assertDoesNotThrow(() -> weatherStatisticsService.dayWithSmallestTempSpread());
    }

    @Test
    void throwsWrongHeader() {
        assertThrows(HeaderException.class, () -> new WeatherStatisticsService("weatherWrongHeader.csv"));
    }

    @Test
    void throwsWrongData() {
        try {
            weatherStatisticsService = new WeatherStatisticsService("weatherWrongData.csv");
        } catch (IOException | HeaderException e) {
            e.printStackTrace();
        }
        assertThrows(NumberFormatException.class, () -> weatherStatisticsService.dayWithSmallestTempSpread());
    }

    @Test
    void findDay14() {
        try {
            weatherStatisticsService = new WeatherStatisticsService("weather.csv");
        } catch (IOException | HeaderException e) {
            e.printStackTrace();
        }
        assertEquals(14, weatherStatisticsService.dayWithSmallestTempSpread());
    }
}
