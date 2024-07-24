package models;

import models.enums.Department;

public class LeaderBoardEntry {
    private User user;
    private int score;
    private Department department;

    public LeaderBoardEntry(User user, int score, Department department) {
        this.user = user;
        this.score = score;
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

