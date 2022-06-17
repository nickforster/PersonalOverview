package model;

public class Team {
    private String designation;

    public Team(String designation) {
        setDesignation(designation);
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
