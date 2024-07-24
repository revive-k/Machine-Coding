package models;

public abstract class SolvedProblemTime {
    private double totalTime;
    private int solvedByPeople;

    public double getTotalTime() {
        return totalTime;
    }

    public int getSolvedByPeople() {
        return solvedByPeople;
    }

    public void addSolvedProblemTime(final double timeTaken) {
        totalTime += timeTaken;
        this.solvedByPeople++;
    }

    public double getAverageTime() {
        return solvedByPeople==0 ? 0.0 : totalTime / solvedByPeople;
    }
}
