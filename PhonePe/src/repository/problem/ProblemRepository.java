package repository.problem;

import models.Problem;
import models.enums.Difficulty;

import java.util.List;

public interface ProblemRepository {
    Problem addProblem(String name, String description, String tag, Difficulty difficulty, int score);
    Problem getProblem(long id);
    List<Problem> getAllProblems();
    void likeProblem(long problemId);
    double getAverageScore(long problemId);
    void addSolvedProblemTime(long problemId, long time);
}
