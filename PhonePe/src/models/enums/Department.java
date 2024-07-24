package models.enums;

public enum Department {
    SALES("Sales"),
    MARKETING("Marketing"),
    ENGINEERING("Engineering"),
    HR("Human Resources"),
    FINANCE("Finance");

    private final String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
