package service;

import models.Problem;
import models.enums.Difficulty;
import models.enums.FilterBy;
import models.enums.SortBy;
import repository.problem.InMemoryProblemRepository;
import repository.problem.ProblemRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemService {
    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public Problem addProblem(String name, String description, String tag, Difficulty difficulty, int score) {
        return problemRepository.addProblem(name, description, tag, difficulty, score);
    }

    public Problem getProblem(long id) {
        return problemRepository.getProblem(id);
    }

    public List<Problem> getProblems(FilterBy filterBy, String filterByValue, SortBy sortBy) {
        List<Problem> problems = problemRepository.getAllProblems();
        if (filterBy != null) {
            switch (filterBy) {
                case DIFFICULTY:
                    problems = problems.stream().filter(p -> p.getDifficulty().equals(Difficulty.valueOf(filterByValue))).collect(Collectors.toList());
                    break;
                case TAG:
                    problems = problems.stream().filter(p -> p.getTag().equals(filterByValue)).collect(Collectors.toList());
                default:
                    break;
            }
        }
        if (sortBy != null) {
            switch (sortBy) {
                case SCORE:
                    problems.sort(Comparator.comparingInt(Problem::getScore).reversed());
                    break;
                case DIFFICULTY:
                    problems.sort(Comparator.comparing(Problem::getDifficulty));
                default:
                    break;
            }
        }
        return problems;
    }

    public void likeProblem(long problemId) {
        problemRepository.likeProblem(problemId);
    }

    public List<Problem> getTopLikedProblemsByTag(String tag, int limit) {
        List<Problem> problems = problemRepository.getAllProblems();
        return problems.stream()
                .filter(problem -> problem.getTag().equalsIgnoreCase(tag))
                .sorted((a, b) -> b.getLikes() - a.getLikes())
                .limit(limit)
                .collect(Collectors.toList());
    }
}

