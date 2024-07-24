package repository.leaderboard;

public class LeaderBoardIdGenerator {
    private static long leaderBoardIdGenerator = 1L;

    public static long generateLeaderBoardId() {
        return leaderBoardIdGenerator++;
    }
}
