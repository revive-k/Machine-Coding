package repository.leaderboard;

import models.LeaderBoardEntry;
import models.User;

import java.util.List;

public interface LeaderBoardRepository {
    void updateLeaderboard(User user, int score);
    List<LeaderBoardEntry> getTopUsers(int n);
    List<LeaderBoardEntry> getAllEntries();
}
