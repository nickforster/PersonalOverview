package model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName;
    private String lastName;
    private String imagePath;

    private List<Team> teams;
    private Department department;
    private Function function;

    private long functionId;
    private long departmentId;
    private long[] teamsIds;

    private static DataHandler dataHandler = new DataHandler();

    public Person(String firstName,
                  String lastName,
                  String imagePath,
                  long functionId,
                  long departmentId,
                  long[] teamsIds) {
        teams = new ArrayList<>();
        setFirstName(firstName);
        setLastName(lastName);
        setImagePath(imagePath);
        setFunctionById(functionId);
        setDepartmentById(departmentId);
        setTeamsByIds(teamsIds);
    }

    private void setFunctionById(long functionId) {
        Function function = DataHandler.getFunction(functionId);
        setFunction(new Function(function.getDesignation()));
        setFunctionId(functionId);
    }

    private void setDepartmentById(long departmentId) {
        Department department = DataHandler.getDepartment(departmentId);
        setDepartment(new Department(department.getDesignation()));
        setDepartmentId(departmentId);
    }

    private void setTeamsByIds(long[] teamsIds) {
        Team[] teamsList = DataHandler.getTeams(teamsIds);
        for (Team team : teamsList) {
            teams.add(new Team(team.getDesignation()));
        }
        setTeamsIds(teamsIds);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(long functionId) {
        this.functionId = functionId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long[] getTeamsIds() {
        return teamsIds;
    }

    public void setTeamsIds(long[] teamsIds) {
        this.teamsIds = teamsIds;
    }
}
