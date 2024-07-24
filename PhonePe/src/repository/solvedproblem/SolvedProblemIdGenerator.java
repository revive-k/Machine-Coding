package repository.solvedproblem;

public class SolvedProblemIdGenerator {
    private static long solvedProblemIdGenerator = 1L;

    public static long generateSolvedProblemId() {
        return solvedProblemIdGenerator++;
    }
}
