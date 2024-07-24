package service;

import models.Problem;
import models.SolvedProblem;
import models.User;
import repository.leaderboard.InMemoryLeaderBoardRepository;
import repository.leaderboard.LeaderBoardRepository;
import repository.problem.InMemoryProblemRepository;
import repository.problem.ProblemRepository;
import repository.solvedproblem.InMemorySolvedProblemRepository;
import repository.solvedproblem.SolvedProblemRepository;
import repository.user.InMemoryUserRepository;
import repository.user.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SolvedProblemService {
    private final SolvedProblemRepository solvedProblemRepository;
    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;
    private final LeaderBoardRepository leaderboardRepository;

    public SolvedProblemService(SolvedProblemRepository solvedProblemRepository, UserRepository userRepository, ProblemRepository problemRepository, LeaderBoardRepository leaderboardRepository) {
        this.solvedProblemRepository = solvedProblemRepository;
        this.userRepository = userRepository;
        this.problemRepository = problemRepository;
        this.leaderboardRepository = leaderboardRepository;
    }

    public void solveProblem(long userId, long problemId, int timeTaken) {
        User user = userRepository.getUser(userId);
        Problem problem = problemRepository.getProblem(problemId);
        solvedProblemRepository.addSolvedProblem(userId, problemId, timeTaken, problem.getScore());
        problem.addSolvedProblemTime(timeTaken);
        leaderboardRepository.updateLeaderboard(user, problem.getScore());
    }

    public List<SolvedProblem> getSolvedProblemsByUser(long userId) {
        return solvedProblemRepository.getSolvedProblemsByUser(userId);
    }

    public Map<String, Object> getSolvedProblemStatistics(long problemId) {
        Problem problem = problemRepository.getProblem(problemId);
        if(Objects.isNull(problem)){
            return null;
        }
        Map<String, Object> statistics = new HashMap<>();
        statistics.put("numberOfUsers", problem.getSolvedByPeople());
        statistics.put("averageTimeTaken", problem.getAverageTime());

        return statistics;
    }
}
