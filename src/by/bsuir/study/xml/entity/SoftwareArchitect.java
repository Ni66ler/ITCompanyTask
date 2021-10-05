package by.bsuir.study.xml.entity;

import java.util.HashSet;
import java.util.Set;

public class SoftwareArchitect extends Employee {
    private Set<TeamLeader> teamLeaders;
    private Set<Tester> testers;
    public SoftwareArchitect() {
        teamLeaders = new HashSet<>();
        testers = new HashSet<>();
    }

    public SoftwareArchitect(Set<TeamLeader> teamLeaders, Set<Tester> testers) {
        this.teamLeaders = teamLeaders;
        this.testers = testers;
    }

    public SoftwareArchitect(String name, String contactNumber, String email,
                             int workExperience, Set<TeamLeader> teamLeaders, Set<Tester> testers) {
        super(name, contactNumber, email, workExperience);
        this.teamLeaders = teamLeaders;
        this.testers = testers;
    }

    public Set<TeamLeader> getTeamLeads() {
        return teamLeaders;
    }

    public void setTeamLeads(Set<TeamLeader> teamLeaders) {
        this.teamLeaders = teamLeaders;
    }

    public Set<Tester> getTesters() {
        return testers;
    }

    public void setTesters(Set<Tester> testers) {
        this.testers = testers;
    }

    public void developSoftwareArchitecture(){
        System.out.println("Makes high-level design choices and tries to enforce technical standards," +
                " including software coding standards, tools, and platforms.");
    }
}
