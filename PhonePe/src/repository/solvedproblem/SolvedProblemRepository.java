package repository.solvedproblem;

import models.Problem;
import models.SolvedProblem;
import models.User;

import java.util.List;

public interface SolvedProblemRepository {
    SolvedProblem addSolvedProblem(long userId, long problemId, int timeTaken, int scoreAwarded);
    List<SolvedProblem> getSolvedProblemsByUser(long userId);
}
