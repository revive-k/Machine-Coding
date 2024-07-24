package repository.problem;

public class ProblemIdGenerator {
    private static long problemIdGenerator = 1L;

    public static long generateProblemId() {
        return problemIdGenerator++;
    }
}
