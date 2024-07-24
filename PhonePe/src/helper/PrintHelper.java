package helper;

import models.LeaderBoardEntry;
import models.Problem;
import models.SolvedProblem;
import models.User;
import models.enums.FilterBy;
import models.enums.SortBy;
import service.LeaderBoardService;
import service.ProblemService;
import service.SolvedProblemService;

import java.util.List;
import java.util.Map;

public class PrintHelper {

    private final ProblemService problemService;
    private final SolvedProblemService solvedProblemService;
    private final LeaderBoardService leaderBoardService;

    public PrintHelper(ProblemService problemService, SolvedProblemService solvedProblemService, LeaderBoardService leaderBoardService) {
        this.problemService = problemService;
        this.solvedProblemService = solvedProblemService;
        this.leaderBoardService = leaderBoardService;
    }

    public void fetchProblems(FilterBy filterBy, String filterByValue, SortBy sortBy) {
        System.out.println("----Filtered by " + filterBy.toString() + " with value " + filterByValue + " and sorted by " + sortBy.toString() + "----");
        List<Problem> filteredAndSortedProblems = problemService.getProblems(filterBy, filterByValue, sortBy);
        for (Problem problem : filteredAndSortedProblems) {
            Map<String, Object> problemStatistics = solvedProblemService.getSolvedProblemStatistics(problem.getId());
            System.out.println(problem.getName() + ": " + problem.getTag() + ", " + problem.getDifficulty() + ", " + problem.getScore());
            System.out.println("Number of users solved: " + problemStatistics.get("numberOfUsers"));
            System.out.println("Average time taken: " + problemStatistics.get("averageTimeTaken"));
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------");
    }

    public void fetchSolvedProblems(User user) {
        System.out.println("----Problems solved by " + user.getName() + "----");
        List<SolvedProblem> solvedProblems = solvedProblemService.getSolvedProblemsByUser(user.getId());
        for (SolvedProblem solvedProblem : solvedProblems) {
            Problem problem = problemService.getProblem(solvedProblem.getProblemId());
            System.out.println(problem.getName() + ": " + problem.getTag()
                    + ", " + problem.getDifficulty() + ", " + problem.getScore());
        }
        System.out.println("---------------------------------------------------------------------");
    }

    public void displayLeaderBoard(String type, int topX) {
        System.out.println("-------------------------Leaderboard-------------------------");
        if ("contestants".equals(type)) {
            System.out.println("--------------Top Contestants--------------");
            List<LeaderBoardEntry> topUsers = leaderBoardService.getTopUsers(topX);
            for (LeaderBoardEntry entry : topUsers) {
                System.out.println("User: " + entry.getUser().getName() + ", Score: " + entry.getScore());
                List<SolvedProblem> solvedProblemsByUser = solvedProblemService.getSolvedProblemsByUser(entry.getUser().getId());
                for (SolvedProblem solvedProblem : solvedProblemsByUser) {
                    Problem problem = problemService.getProblem(solvedProblem.getProblemId());
                    System.out.println("  Solved: " + problem.getName());
                }
            }
        }
        else if ("departments".equals(type)) {
            System.out.println("--------------Top Departments--------------");
            List<LeaderBoardEntry> topDepartments = leaderBoardService.getTopDepartments(topX);
            for (LeaderBoardEntry entry : topDepartments) {
                System.out.println("Department: " + entry.getDepartment() + ", Score: " + entry.getScore());
            }
        }
        System.out.println("---------------------------------------------------------------------");
    }

    public void getTopLikedProblems(String tag, int topX) {
        System.out.println("----Most liked problems for tag " + tag + "----");
        List<Problem> topLikedProblems = problemService.getTopLikedProblemsByTag(tag, topX);
        for (Problem problem : topLikedProblems) {
            System.out.println(problem.getName() + ": " + problem.getLikes());
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
