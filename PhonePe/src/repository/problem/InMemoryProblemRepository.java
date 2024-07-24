package repository.problem;

import models.Problem;
import models.enums.Difficulty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryProblemRepository implements ProblemRepository{
    private final Map<Long, Problem> problems = new HashMap<>();
    @Override
    public Problem addProblem(String name, String description, String tag, Difficulty difficulty, int score) {
        Problem problem = new Problem(ProblemIdGenerator.generateProblemId(), name, description, tag, difficulty, score);
        problems.put(problem.getId(), problem);
        return problem;
    }

    @Override
    public Problem getProblem(long id) {
        return problems.get(id);
    }

    @Override
    public List<Problem> getAllProblems() {
        return new ArrayList<>(problems.values());
    }

    @Override
    public void likeProblem(long problemId) {
        Problem problem = problems.get(problemId);
        if(problem != null){
            problem.addLikes();
        }
    }

    @Override
    public double getAverageScore(long problemId) {
        Problem problem = problems.get(problemId);
        if(problem != null){
            return problem.getAverageTime();
        }
        return 0L;
    }

    @Override
    public void addSolvedProblemTime(long problemId, long time) {
        Problem problem = problems.get(problemId);
        if(problem != null) {
            problem.addSolvedProblemTime(time);
        }
    }

}
