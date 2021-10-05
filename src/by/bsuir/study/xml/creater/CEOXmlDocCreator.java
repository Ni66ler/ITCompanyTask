package by.bsuir.study.xml.creater;

import by.bsuir.study.xml.entity.*;
import by.bsuir.study.xml.entity.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;

public class CEOXmlDocCreator {

    public static void createXMLFile(CEO ceo, String path) {
        Document document = createXmlDocument(ceo);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter(path));
            transformer.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    private static Document createXmlDocument(CEO ceo) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement(EmployeeXmlTag.CEO.getValue());
        document.appendChild(rootElement);
        appendEmployeeElements(ceo, rootElement, document);

        Element elementOverallStrategy = document.createElement(EmployeeXmlTag.OVERALL_STRATEGY.getValue());
        String overallStrategy = ceo.getOverallStrategy();
        elementOverallStrategy.appendChild(document.createTextNode(overallStrategy));
        rootElement.appendChild(elementOverallStrategy);

        Element ctoElement = document.createElement(EmployeeXmlTag.CTO.getValue());
        rootElement.appendChild(ctoElement);
        appendCtoElements(ceo.getCto(), ctoElement, document);
        return document;
    }

    private static void appendEmployeeElements(Employee employee, Element parentElement, Document document) {
        Element elementName = document.createElement(EmployeeXmlTag.NAME.getValue());
        String name = employee.getName();
        elementName.appendChild(document.createTextNode(name));
        parentElement.appendChild(elementName);

        Element elementContactNumber = document.createElement(EmployeeXmlTag.CONTACT_NUMBER.getValue());
        String contactNumber = employee.getContactNumber();
        elementContactNumber.appendChild(document.createTextNode(contactNumber));
        parentElement.appendChild(elementContactNumber);

        Element elementEmail = document.createElement(EmployeeXmlTag.EMAIL.getValue());
        String email = employee.getEmail();
        elementEmail.appendChild(document.createTextNode(email));
        parentElement.appendChild(elementEmail);

        Element elementWorkExperience = document.createElement(EmployeeXmlTag.WORK_EXPERIENCE.getValue());
        int workExperience = employee.getWorkExperience();
        elementWorkExperience.appendChild(document.createTextNode(Integer.toString(workExperience)));
        parentElement.appendChild(elementWorkExperience);
    }

    private static void appendCtoElements(CTO cto, Element parentElement, Document document) {
        appendEmployeeElements(cto, parentElement, document);

        Element elementCompanyResources = document.createElement(EmployeeXmlTag.COMPANY_RESOURCES.getValue());
        int companyResources = cto.getCompanyResources();
        elementCompanyResources.appendChild(document.createTextNode(Integer.toString(companyResources)));
        parentElement.appendChild(elementCompanyResources);

        Element elementProjectManagers = document.createElement(EmployeeXmlTag.PROJECT_MANAGERS.getValue());
        parentElement.appendChild(elementProjectManagers);

        ProjectManager[] projectManagers = cto.getProjectManagers().toArray(new ProjectManager[0]);
        for (ProjectManager projectManager : projectManagers) {
            Element elementProjectManager = document.createElement(EmployeeXmlTag.PROJECT_MANAGER.getValue());
            elementProjectManagers.appendChild(elementProjectManager);
            appendProjectManagerElements(projectManager, elementProjectManager, document);
        }
    }

    private static void appendProjectManagerElements(ProjectManager projectManager,
                                                     Element parentElement, Document document) {
        appendEmployeeElements(projectManager, parentElement, document);

        Element elementSoftwareArchitect = document.createElement(EmployeeXmlTag.SOFTWARE_ARCHITECT.getValue());
        parentElement.appendChild(elementSoftwareArchitect);
        appendSoftwareArchitectElements(projectManager.getSoftwareArchitect(), elementSoftwareArchitect, document);

    }

    private static void appendSoftwareArchitectElements(SoftwareArchitect softwareArchitect,
                                                        Element parentElement, Document document) {
        appendEmployeeElements(softwareArchitect, parentElement, document);

        Element elementTeamLeaders = document.createElement(EmployeeXmlTag.TEAM_LEADERS.getValue());
        parentElement.appendChild(elementTeamLeaders);
        TeamLeader[] teamLeaders = softwareArchitect.getTeamLeads().toArray(new TeamLeader[0]);
        for (TeamLeader teamLeader : teamLeaders) {
            Element elementTeamLeader = document.createElement(EmployeeXmlTag.TEAM_LEADER.getValue());
            elementTeamLeaders.appendChild(elementTeamLeader);
            appendTeamLeaderElements(teamLeader, elementTeamLeader, document);

        }

        Element elementTesters = document.createElement(EmployeeXmlTag.TESTERS.getValue());
        parentElement.appendChild(elementTesters);
        Tester[] testers = softwareArchitect.getTesters().toArray(new Tester[0]);
        for (Tester tester : testers) {
            Element elementTester = document.createElement(EmployeeXmlTag.TESTER.getValue());
            elementTesters.appendChild(elementTester);
            appendTester(tester, elementTester, document);
        }

    }

    private static  void appendTeamLeaderElements(TeamLeader teamLeader, Element parentElement, Document document) {
        appendEmployeeElements(teamLeader, parentElement, document);

        Element elementJuniorDevs = document.createElement(EmployeeXmlTag.JUNIOR_DEVS.getValue());
        parentElement.appendChild(elementJuniorDevs);
        JuniorDeveloper[] juniorDevs = teamLeader.getJuniorDevelopers().toArray(new JuniorDeveloper[0]);
        for (JuniorDeveloper juniorDev : juniorDevs) {
            Element elementJuniorDev = document.createElement(EmployeeXmlTag.JUNIOR.getValue());
            elementJuniorDevs.appendChild(elementJuniorDev);
            appendJuniorDev(juniorDev, elementJuniorDev, document);
        }

        Element elementMiddleDevs = document.createElement(EmployeeXmlTag.MIDDLE_DEVS.getValue());
        parentElement.appendChild(elementMiddleDevs);
        MiddleDeveloper[] middleDevs = teamLeader.getMiddleDevelopers().toArray(new MiddleDeveloper[0]);
        for (MiddleDeveloper middleDev : middleDevs) {
            Element elementMiddleDev = document.createElement(EmployeeXmlTag.MIDDLE.getValue());
            elementMiddleDevs.appendChild(elementMiddleDev);
            appendMiddleDev(middleDev, elementMiddleDev, document);
        }

        Element elementSeniorDevs = document.createElement(EmployeeXmlTag.SENIOR_DEVS.getValue());
        parentElement.appendChild(elementSeniorDevs);
        SeniorDeveloper[] seniorDevs = teamLeader.getSeniorDevelopers().toArray(new SeniorDeveloper[0]);
        for (SeniorDeveloper seniorDev : seniorDevs) {
            Element elementSeniorDev = document.createElement(EmployeeXmlTag.SENIOR.getValue());
            elementSeniorDevs.appendChild(elementSeniorDev);
            appendSeniorDev(seniorDev, elementSeniorDev, document);
        }
    }

    private static void appendJuniorDev(JuniorDeveloper juniorDev, Element parentElement, Document document) {
        appendEmployeeElements(juniorDev, parentElement, document);
        Element elementEfficiency = document.createElement(EmployeeXmlTag.EFFICIENCY.getValue());
        elementEfficiency.appendChild(document.createTextNode(Integer.toString(juniorDev.getEfficiency())));
        parentElement.appendChild(elementEfficiency);
    }

    private static void appendMiddleDev(MiddleDeveloper middleDev, Element parentElement, Document document) {
        appendEmployeeElements(middleDev, parentElement, document);
        Element elementEfficiency = document.createElement(EmployeeXmlTag.EFFICIENCY.getValue());
        elementEfficiency.appendChild(document.createTextNode(Integer.toString(middleDev.getEfficiency())));
        parentElement.appendChild(elementEfficiency);
    }

    private static void appendSeniorDev(SeniorDeveloper seniorDev, Element parentElement, Document document) {
        appendEmployeeElements(seniorDev, parentElement, document);
        Element elementEfficiency = document.createElement(EmployeeXmlTag.EFFICIENCY.getValue());
        elementEfficiency.appendChild(document.createTextNode(Integer.toString(seniorDev.getEfficiency())));
        parentElement.appendChild(elementEfficiency);
    }

    private static void appendTester(Tester tester, Element parentElement, Document document) {
        appendEmployeeElements(tester, parentElement, document);
    }


}
