package models.enums;

public enum Difficulty {
    EASY,
    MEDIUM,
    HARD;

    private final String difficulty;

    Difficulty() {
        this.difficulty = this.name().toLowerCase();
    }

    public String getDifficulty() {
        return difficulty;
    }
}
