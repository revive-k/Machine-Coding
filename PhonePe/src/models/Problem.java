package models;

import models.enums.Difficulty;

public class Problem extends SolvedProblemTime{
    private final long id;
    private String name;
    private String description;
    private String tag;
    private Difficulty difficulty;
    private int score;
    private int likes;

    public Problem(long id, String name, String description, String tag, Difficulty difficulty, int score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.difficulty = difficulty;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLikes() {
        return likes;
    }

    public void addLikes() {
        this.likes++;
    }
}
