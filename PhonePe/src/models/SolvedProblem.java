package models;

public class SolvedProblem {
    private final long id;
    private long userId;
    private long problemId;
    private int timeTaken;
    private int scoreAwarded;

    public SolvedProblem(long id, long userId, long problemId, int timeTaken, int scoreAwarded) {
        this.id = id;
        this.userId = userId;
        this.problemId = problemId;
        this.timeTaken = timeTaken;
        this.scoreAwarded = scoreAwarded;
    }

    public long getId() {
        return id;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProblemId() {
        return problemId;
    }

    public void setProblemId(long problemId) {
        this.problemId = problemId;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public int getScoreAwarded() {
        return scoreAwarded;
    }

    public void setScoreAwarded(int scoreAwarded) {
        this.scoreAwarded = scoreAwarded;
    }
}

