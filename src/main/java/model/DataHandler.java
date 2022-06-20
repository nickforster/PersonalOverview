package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class DataHandler {
    private static List<Person> persons;
    private static List<Department> departments;
    private static List<Team> teams;
    private static List<Function> functions;

    JSONParser jsonParser = new JSONParser();

    public DataHandler() {
        persons = new ArrayList<>();
        departments = new ArrayList<>();
        teams = new ArrayList<>();
        functions = new ArrayList<>();

        readData();
    }

    private void listData() {
        for (Person person : persons) {
            System.out.println(
                    person.getFirstName() + " " +
                            person.getLastName() + " " +
                            person.getImagePath()
            );

            System.out.println(person.getDepartment().getDesignation());
            System.out.println(person.getFunction().getDesignation());
            for (int i = 0; i < person.getTeams().size(); i++) {
                System.out.println(person.getTeams().get(i).getDesignation());
            }
        }
        for (Department department : departments) {
            System.out.println(department.getDesignation());
        }
        for (Team team : teams) {
            System.out.println(team.getDesignation());
        }
        for (Function function : functions) {
            System.out.println(function.getDesignation());
        }
    }

    private void readData() {
        try {
            //Read JSON file of employees
            FileReader readPersons = new FileReader("src/main/java/data/person.json");
            Object personObj = jsonParser.parse(readPersons);
            JSONArray personList = (JSONArray) personObj;

            //Read JSON file of departments
            FileReader readDepartments = new FileReader("src/main/java/data/department.json");
            Object departmentObj = jsonParser.parse(readDepartments);
            JSONArray departmentList = (JSONArray) departmentObj;

            //Read JSON file of teams
            FileReader readTeams = new FileReader("src/main/java/data/team.json");
            Object teamObj = jsonParser.parse(readTeams);
            JSONArray teamList = (JSONArray) teamObj;

            //Read JSON file of teams
            FileReader readFunctions = new FileReader("src/main/java/data/function.json");
            Object functionObj = jsonParser.parse(readFunctions);
            JSONArray functionList = (JSONArray) functionObj;

            departmentList.forEach(emp -> parseDepartmentObject((JSONObject) emp));
            teamList.forEach(emp -> parseTeamObject((JSONObject) emp));
            functionList.forEach(emp -> parseFunctionObject((JSONObject) emp));
            personList.forEach(emp -> parsePersonObject((JSONObject) emp));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method is used to parse an JSONObject to an Person object.
     *
     * @param person JSONObject
     */
    private void parsePersonObject(JSONObject person) {
        String firstName = (String) person.get("firstName");
        String lastName = (String) person.get("lastName");
        String imagePath = (String) person.get("imagePath");
        long functionId = (long) person.get("functionId");
        long departmentId = (long) person.get("departmentId");

        JSONArray teamsIdsJsonArray = (JSONArray) person.get("teamsIds");
        long[] teamsIds = new long[teamsIdsJsonArray.toArray().length];
        for (int i = 0; i < teamsIdsJsonArray.toArray().length; i++) {
            teamsIds[i] = (long) teamsIdsJsonArray.get(i);
        }

        persons.add(new Person(firstName, lastName, imagePath, functionId, departmentId, teamsIds));
    }

    /**
     * This method is used to parse an JSONObject to an Department object.
     *
     * @param department JSONObject
     */
    private void parseDepartmentObject(JSONObject department) {
        String designation = (String) department.get("designation");
        departments.add(new Department(designation));
    }

    /**
     * This method is used to parse an JSONObject to an Team object.
     *
     * @param team JSONObject
     */
    private void parseTeamObject(JSONObject team) {
        String designation = (String) team.get("designation");
        teams.add(new Team(designation));
    }

    /**
     * This method is used to parse an JSONObject to an Function object.
     *
     * @param function JSONObject
     */
    private void parseFunctionObject(JSONObject function) {
        String designation = (String) function.get("designation");
        functions.add(new Function(designation));
    }

    public static Function getFunction(long index) {
        return functions.get((int) index);
    }

    public static Department getDepartment(long index) {
        return departments.get((int) index);
    }

    public static Team[] getTeams(long[] index) {
        Team[] returnTeam = new Team[index.length];
        for (int i = 0; i < index.length; i++) {
            returnTeam[i] = teams.get((int) index[i]);
        }
        return returnTeam;
    }

    public void writeDepartment() {
        JSONArray jsonArray = new JSONArray();

        for (Department department : departments) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("designation", department.getDesignation());
            jsonArray.add(jsonObject);
        }

        System.out.println(jsonArray);

        try (FileWriter file = new FileWriter("src/main/java/data/department.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDepartment(String designation) {
        departments.add(new Department(designation));
        writeDepartment();
    }

    public void editDepartment(int index, String designation) {
        departments.set(index, new Department(designation));
        writeDepartment();
    }

    public void writeFunction() {
        JSONArray jsonArray = new JSONArray();

        for (Function function : functions) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("designation", function.getDesignation());
            jsonArray.add(jsonObject);
        }

        System.out.println(jsonArray);

        try (FileWriter file = new FileWriter("src/main/java/data/function.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFunction(String designation) {
        functions.add(new Function(designation));
        writeFunction();
    }

    public void editFunction(int index, String designation) {
        functions.set(index, new Function(designation));
        writeFunction();
    }

    public void writeTeam() {
        JSONArray jsonArray = new JSONArray();

        for (Team team : teams) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("designation", team.getDesignation());
            jsonArray.add(jsonObject);
        }

        System.out.println(jsonArray);

        try (FileWriter file = new FileWriter("src/main/java/data/team.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTeam(String designation) {
        teams.add(new Team(designation));
        writeTeam();
    }

    public void editTeam(int index, String designation) {
        teams.set(index, new Team(designation));
        writeTeam();
    }

    public void writePerson() {
        JSONArray jsonArray = new JSONArray();

        for (Person person : persons) {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray1 = new JSONArray();
            jsonObject.put("firstName", person.getFirstName());
            jsonObject.put("lastName", person.getLastName());
            jsonObject.put("imagePath", person.getImagePath());
            jsonObject.put("departmentId", person.getDepartmentId());
            jsonObject.put("functionId", person.getDepartmentId());
            for (int i = 0; i < person.getTeamsIds().length; i++) {
                jsonArray1.add(person.getTeamsIds()[i]);
            }
            jsonObject.put("teamsIds", jsonArray1);
            jsonArray.add(jsonObject);
        }

        System.out.println(jsonArray);

        try (FileWriter file = new FileWriter("src/main/java/data/person.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPerson(String firstName, String lastName, long departmentId, long functionId, long[] teamsIds) {
        persons.add(new Person(firstName, lastName, "", functionId, departmentId, teamsIds));
        writePerson();
    }

    public void editPerson(int index, String firstName, String lastName, long departmentId, long functionId, long[] teamsIds) {
        persons.set(index, new Person(firstName, lastName, "", functionId, departmentId, teamsIds));
        writePerson();
    }
}
