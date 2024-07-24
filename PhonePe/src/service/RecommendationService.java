package service;

import models.Problem;
import repository.problem.ProblemRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RecommendationService {

    private ProblemRepository problemRepository;

    public RecommendationService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public List<Problem> getRecommendation(String strategy, String value, int topX) {
        List<Problem> problems = problemRepository.getAllProblems();
        switch (strategy) {
            case "similarTag":
                problems = problems.stream().filter(p -> p.getTag().equals(value)).limit(topX).collect(Collectors.toList());
                break;
            case "similarDifficulty":
                problems = problems.stream().filter(p -> p.getDifficulty().equals(value)).limit(topX).collect(Collectors.toList());
                break;
            default:
                break;
        }
        return problems;
    }
}
