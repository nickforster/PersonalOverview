package model;

public class Department {
    private String designation;

    public Department(String designation) {
        setDesignation(designation);
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
