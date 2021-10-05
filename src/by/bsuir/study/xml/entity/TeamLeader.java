package by.bsuir.study.xml.entity;

import java.util.HashSet;
import java.util.Set;

public class TeamLeader extends Employee{
    private Set<JuniorDeveloper> juniorDevelopers;
    private Set<MiddleDeveloper> middleDevelopers;
    private Set<SeniorDeveloper> seniorDevelopers;

    public TeamLeader() {
        juniorDevelopers = new HashSet<>();
        middleDevelopers = new HashSet<>();
        seniorDevelopers = new HashSet<>();
    }

    public TeamLeader(Set<JuniorDeveloper> juniorDevelopers, Set<MiddleDeveloper> middleDevelopers, Set<SeniorDeveloper> seniorDevelopers) {
        this.juniorDevelopers = juniorDevelopers;
        this.middleDevelopers = middleDevelopers;
        this.seniorDevelopers = seniorDevelopers;
    }

    public TeamLeader(String name, String contactNumber, String email, int workExperience, Set<JuniorDeveloper> juniorDevelopers, Set<MiddleDeveloper> middleDevelopers, Set<SeniorDeveloper> seniorDevelopers) {
        super(name, contactNumber, email, workExperience);
        this.juniorDevelopers = juniorDevelopers;
        this.middleDevelopers = middleDevelopers;
        this.seniorDevelopers = seniorDevelopers;
    }

    public Set<JuniorDeveloper> getJuniorDevelopers() {
        return juniorDevelopers;
    }

    public void setJuniorDevelopers(Set<JuniorDeveloper> juniorDevelopers) {
        this.juniorDevelopers = juniorDevelopers;
    }

    public Set<MiddleDeveloper> getMiddleDevelopers() {
        return middleDevelopers;
    }

    public void setMiddleDevelopers(Set<MiddleDeveloper> middleDevelopers) {
        this.middleDevelopers = middleDevelopers;
    }

    public Set<SeniorDeveloper> getSeniorDevelopers() {
        return seniorDevelopers;
    }

    public void setSeniorDevelopers(Set<SeniorDeveloper> seniorDevelopers) {
        this.seniorDevelopers = seniorDevelopers;
    }

    public void manageDevelopers() {
        System.out.println("Manages the development team, coordinates a particular aspect of the project");
    }
}
