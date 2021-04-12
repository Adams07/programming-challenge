package de.exxcellent.challenge;

import de.exxcellent.challenge.exception.HeaderException;
import de.exxcellent.challenge.service.weather.WeatherStatisticsService;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        try {
            WeatherStatisticsService weatherStatisticsService = new WeatherStatisticsService("weather.csv");
            System.out.printf("Day with smallest temperature spread : %s%n", weatherStatisticsService.dayWithSmallestTempSpread());
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
        } catch (IOException e) {
            System.err.println("The file cannot be read.");
        } catch (HeaderException e) {
            System.err.println("Wrong header data.");
        } catch (NumberFormatException e) {
            System.err.println("Wrong numeric data.");
        }
    }
}
