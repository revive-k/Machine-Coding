package repository.leaderboard;

import models.LeaderBoardEntry;
import models.User;
import models.enums.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryLeaderBoardRepository implements LeaderBoardRepository{
    private final List<LeaderBoardEntry> leaderboard = new ArrayList<>();

    @Override
    public void updateLeaderboard(User user, int score) {
        LeaderBoardEntry entry = leaderboard.stream().filter(e -> e.getUser().getId()==user.getId()).findFirst().orElse(null);
        if (entry != null) {
            entry.setScore(entry.getScore() + score);
        } else {
            leaderboard.add(new LeaderBoardEntry(user, score, user.getDepartment()));
        }
        leaderboard.sort((e1, e2) -> e2.getScore() - e1.getScore());
    }

    @Override
    public List<LeaderBoardEntry> getTopUsers(int n) {
        return leaderboard.stream().limit(n).collect(Collectors.toList());
    }

    @Override
    public List<LeaderBoardEntry> getAllEntries() {
        return leaderboard;
    }
}
