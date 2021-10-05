package by.bsuir.study.xml.parser;

import by.bsuir.study.xml.creater.CEOXmlDocCreator;
import by.bsuir.study.xml.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        JuniorDeveloper juniorDeveloper = new JuniorDeveloper("vanya", "374499", "vany@", 8, 10);
        MiddleDeveloper middleDeveloper = new MiddleDeveloper("roma", "343243", "rom@", 2, 1);
        SeniorDeveloper seniorDeveloper = new SeniorDeveloper("ilya", "33333", "ily@", 15, 20);
        Set<JuniorDeveloper> juniorDevelopers = new HashSet<>();
        juniorDevelopers.add(juniorDeveloper);
        Set<MiddleDeveloper> middleDevelopers = new HashSet<>();
        middleDevelopers.add(middleDeveloper);
        Set<SeniorDeveloper> seniorDevelopers = new HashSet<>();
        seniorDevelopers.add(seniorDeveloper);
        TeamLeader teamLeader = new TeamLeader("ivan", "44444", "iv@n", 10, juniorDevelopers, middleDevelopers, seniorDevelopers);
        Tester tester = new Tester("daniil", "5555", "d@niil", 10);
        Set<TeamLeader> teamLeaders = new HashSet<>();
        teamLeaders.add(teamLeader);
        Set<Tester> testers = new HashSet<>();
        testers.add(tester);
        SoftwareArchitect softwareArchitect = new SoftwareArchitect("vlad", "6666", "vl@d", 12, teamLeaders, testers);
        ProjectManager projectManager = new ProjectManager("dima", "7777", "dim@", 20, softwareArchitect);
        Set<ProjectManager> projectManagers = new HashSet<>();
        projectManagers.add(projectManager);
        CTO cto = new CTO("anton", "8888", "@nton", 20, 100, projectManagers);
        CEO ceo = new CEO("olya", "9999", "oly@", 24, "destroy everyone on the market", cto);
        CEOXmlDocCreator.createXMLFile(ceo, "result.xml");
    }
}
