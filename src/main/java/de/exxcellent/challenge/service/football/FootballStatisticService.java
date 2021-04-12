package de.exxcellent.challenge.service.football;

import de.exxcellent.challenge.exception.HeaderException;
import de.exxcellent.challenge.service.Statistics;

import java.io.IOException;
import java.util.List;

public class FootballStatisticService extends Statistics {
    private static final String TEAM_NAME = "Team";
    private static final String GOALS = "Goals";
    private static final String GOALS_ALLOWED = "Goals Allowed";
    private int teamNameColumnIndex = -1;
    private int goalsColumnIndex = -1;
    private int goalsAllowedColumnIndex = -1;

    public FootballStatisticService(String filePath) throws IOException, HeaderException {
        super(filePath);
        for (int i = 0; i < header.size(); i++) {
            switch (header.get(i)) {
                case TEAM_NAME:
                    teamNameColumnIndex = i;
                    break;
                case GOALS:
                    goalsColumnIndex = i;
                    break;
                case GOALS_ALLOWED:
                    goalsAllowedColumnIndex = i;
                    break;
                default:
                    break;
            }
        }
        if (teamNameColumnIndex == -1 || goalsColumnIndex == -1 || goalsAllowedColumnIndex == -1) {
            throw new HeaderException();
        }
    }

    public String teamWithSmallestDistance() {
        int minDistance = Integer.MAX_VALUE;
        String teamName = "";
        for (List<String> record : data) {
            int distance = Integer.parseInt(record.get(goalsColumnIndex)) - Integer.parseInt(record.get(goalsAllowedColumnIndex));
            if (Math.abs(distance) < minDistance) {
                minDistance = distance;
                teamName = record.get(teamNameColumnIndex);
            }
        }
        return teamName;
    }
}
