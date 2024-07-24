package repository.solvedproblem;

import models.Problem;
import models.SolvedProblem;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemorySolvedProblemRepository implements SolvedProblemRepository{
    private final Map<Long, List<SolvedProblem>> solvedProblemsByUserId = new HashMap<>();
    @Override
    public SolvedProblem addSolvedProblem(long userId, long problemId, int timeTaken, int scoreAwarded) {
        SolvedProblem solvedProblem = new SolvedProblem(SolvedProblemIdGenerator.generateSolvedProblemId(), userId, problemId, timeTaken, scoreAwarded);
        solvedProblemsByUserId.computeIfAbsent(userId, k -> new ArrayList<>()).add(solvedProblem);
        return solvedProblem;
    }

    @Override
    public List<SolvedProblem> getSolvedProblemsByUser(long userId) {
        return solvedProblemsByUserId.getOrDefault(userId, new ArrayList<>());
    }
}
