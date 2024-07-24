import helper.PrintHelper;
import models.*;
import models.enums.Department;
import models.enums.Difficulty;
import models.enums.FilterBy;
import models.enums.SortBy;
import repository.leaderboard.InMemoryLeaderBoardRepository;
import repository.leaderboard.LeaderBoardRepository;
import repository.problem.InMemoryProblemRepository;
import repository.problem.ProblemRepository;
import repository.solvedproblem.InMemorySolvedProblemRepository;
import repository.solvedproblem.SolvedProblemRepository;
import repository.user.InMemoryUserRepository;
import repository.user.UserRepository;
import service.*;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        ProblemRepository problemRepository = new InMemoryProblemRepository();
        SolvedProblemRepository solvedProblemRepository = new InMemorySolvedProblemRepository();
        LeaderBoardRepository leaderboardRepository = new InMemoryLeaderBoardRepository();

        UserService userService = new UserService(userRepository);
        ProblemService problemService = new ProblemService(problemRepository);
        SolvedProblemService solveProblemService = new SolvedProblemService(solvedProblemRepository, userRepository, problemRepository, leaderboardRepository);
        LeaderBoardService leaderboardService = new LeaderBoardService(leaderboardRepository);
        PrintHelper printHelper = new PrintHelper(problemService, solveProblemService, leaderboardService);


        // Add users
        User user1 = userService.addUser("Alice", Department.ENGINEERING);
        User user2 = userService.addUser("Bob", Department.SALES);
        User user3 = userService.addUser("John", Department.FINANCE);

        // Add problems
        Problem problem1 = problemService.addProblem("Problem 1", "Description 1", "Tag1", Difficulty.EASY, 100);
        Problem problem2 = problemService.addProblem("Problem 2", "Description 2", "Tag2", Difficulty.MEDIUM, 200);
        Problem problem3 = problemService.addProblem("Problem 3", "Description 3", "Tag3", Difficulty.HARD, 600);
        Problem problem4 = problemService.addProblem("Problem 4", "Description 4", "Tag2", Difficulty.MEDIUM, 100);
        Problem problem5 = problemService.addProblem("Problem 5", "Description 5", "Tag3", Difficulty.EASY, 50);
        Problem problem6 = problemService.addProblem("Problem 6", "Description 6", "Tag1", Difficulty.HARD, 300);

        // Solve problems
        solveProblemService.solveProblem(user1.getId(), problem1.getId(), 30);
        solveProblemService.solveProblem(user1.getId(), problem5.getId(), 35);
        solveProblemService.solveProblem(user1.getId(), problem6.getId(), 85);
        solveProblemService.solveProblem(user2.getId(), problem2.getId(), 40);
        solveProblemService.solveProblem(user2.getId(), problem3.getId(), 60);
        solveProblemService.solveProblem(user2.getId(), problem1.getId(), 35);
        solveProblemService.solveProblem(user3.getId(), problem5.getId(), 25);
        solveProblemService.solveProblem(user3.getId(), problem2.getId(), 55);
        solveProblemService.solveProblem(user3.getId(), problem6.getId(), 75);
        solveProblemService.solveProblem(user3.getId(), problem1.getId(), 30);


        // Filter and sort problems
        printHelper.fetchProblems(FilterBy.DIFFICULTY, Difficulty.EASY.toString(), SortBy.SCORE);
        printHelper.fetchProblems(FilterBy.DIFFICULTY, Difficulty.HARD.toString(), SortBy.SCORE);
        printHelper.fetchProblems(FilterBy.TAG, "Tag3", SortBy.SCORE);

        //Problem solved by user
        printHelper.fetchSolvedProblems(user1);
        printHelper.fetchSolvedProblems(user2);
        printHelper.fetchSolvedProblems(user3);

        // LeaderBoard
        printHelper.displayLeaderBoard("contestants", 2);
        printHelper.displayLeaderBoard("departments", 2);

        //Add likes
        problemService.likeProblem(problem1.getId());
        problemService.likeProblem(problem3.getId());
        problemService.likeProblem(problem3.getId());
        problemService.likeProblem(problem1.getId());
        problemService.likeProblem(problem2.getId());
        problemService.likeProblem(problem4.getId());
        problemService.likeProblem(problem6.getId());

        //Get top liked problems for certain tag
        printHelper.getTopLikedProblems("Tag3", 2);
        printHelper.getTopLikedProblems("Tag1", 1);
    }
}
