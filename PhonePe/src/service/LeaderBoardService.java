package service;

import models.LeaderBoardEntry;
import models.enums.Department;
import repository.leaderboard.InMemoryLeaderBoardRepository;
import repository.leaderboard.LeaderBoardRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeaderBoardService {
    private final LeaderBoardRepository leaderboardRepository;

    public LeaderBoardService(LeaderBoardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    public List<LeaderBoardEntry> getTopUsers(int n) {
        return leaderboardRepository.getTopUsers(n);
    }

    public List<LeaderBoardEntry> getTopDepartments(int n) {
        Map<Department, Integer> departmentScores = new HashMap<>();

        for (LeaderBoardEntry entry : leaderboardRepository.getAllEntries()) {
            Department department = entry.getUser().getDepartment();
            departmentScores.put(department, departmentScores.getOrDefault(department, 0) + entry.getScore());
        }

        return departmentScores.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(n)
                .map(e -> new LeaderBoardEntry(null, e.getValue(), e.getKey()))
                .collect(Collectors.toList());
    }
}

