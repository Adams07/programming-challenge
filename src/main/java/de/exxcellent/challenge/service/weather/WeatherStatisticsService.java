package de.exxcellent.challenge.service.weather;

import de.exxcellent.challenge.exception.HeaderException;
import de.exxcellent.challenge.service.Statistics;

import java.io.IOException;
import java.util.List;

public class WeatherStatisticsService extends Statistics {
    private static final String DAY = "Day";
    private static final String MAX_TEMP = "MxT";
    private static final String MIN_TEMP = "MnT";
    private int dayColumnIndex = -1;
    private int maxTempColumnIndex = -1;
    private int minTempColumnIndex = -1;

    public WeatherStatisticsService(String filePath) throws IOException, HeaderException {
        super(filePath);
        for (int i = 0; i < header.size(); i++) {
            switch (header.get(i)) {
                case DAY:
                    dayColumnIndex = i;
                    break;
                case MAX_TEMP:
                    maxTempColumnIndex = i;
                    break;
                case MIN_TEMP:
                    minTempColumnIndex = i;
                    break;
                default:
                    break;
            }
        }
        if (dayColumnIndex == -1 || maxTempColumnIndex == -1 || minTempColumnIndex == -1) {
            throw new HeaderException();
        }
    }

    public int dayWithSmallestTempSpread() {
        double minSpread = Double.MAX_VALUE;
        int dayOfMinSpread = -1;
        for (List<String> record : data) {
            double spread = Double.parseDouble(record.get(maxTempColumnIndex)) - Double.parseDouble(record.get(minTempColumnIndex));
            if (spread < minSpread) {
                minSpread = spread;
                dayOfMinSpread = Integer.parseInt(record.get(dayColumnIndex));
            }
        }
        return dayOfMinSpread;
    }
}
