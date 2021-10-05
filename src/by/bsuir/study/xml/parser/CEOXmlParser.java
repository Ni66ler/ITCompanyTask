package by.bsuir.study.xml.parser;

import by.bsuir.study.xml.creater.EmployeeXmlTag;
import by.bsuir.study.xml.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CEOXmlParser {
    private CEO ceo;
    private DocumentBuilder docBuilder;

    public CEOXmlParser() {
        ceo = new CEO();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public CEO getCeo() {
        return ceo;
    }

    public void buildCEO(String path) {
        Document document;
        try {
            document = docBuilder.parse(path);
            Element root = document.getDocumentElement();
            Element ceoElement = (Element) root.getElementsByTagName(EmployeeXmlTag.CEO.getValue()).item(0);
            CEO ceo = new CEO();
            buildEmployee(ceo, ceoElement);
            ceo.setOverallStrategy(getElementTextContent(ceoElement, EmployeeXmlTag.OVERALL_STRATEGY.getValue()));
            Element ctoElement = (Element) ceoElement.getElementsByTagName(EmployeeXmlTag.CTO.getValue()).item(0);
            CTO cto = buildCTO(ctoElement);
            ceo.setCto(cto);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private void buildEmployee(Employee employee, Element element) {
        employee.setName(getElementTextContent(element, EmployeeXmlTag.NAME.getValue()));
        employee.setContactNumber(getElementTextContent(element, EmployeeXmlTag.CONTACT_NUMBER.getValue()));
        employee.setEmail(getElementTextContent(element, EmployeeXmlTag.EMAIL.getValue()));
        int workExperience = Integer.parseInt(getElementTextContent(element, EmployeeXmlTag.WORK_EXPERIENCE.getValue()));
        employee.setWorkExperience(workExperience);
    }

    private CTO buildCTO(Element element) {
        CTO cto = new CTO();
        buildEmployee(cto, element);
        int resources = Integer.parseInt(getElementTextContent(element, EmployeeXmlTag.COMPANY_RESOURCES.getValue()));
        cto.setCompanyResources(resources);
        Element pms = (Element) element.getElementsByTagName(EmployeeXmlTag.PROJECT_MANAGERS.getValue()).item(0);
        NodeList pmsList = pms.getElementsByTagName(EmployeeXmlTag.PROJECT_MANAGER.getValue());
        for (int i = 0; i < pmsList.getLength(); i++) {
            Element pmElement = (Element) pmsList.item(i);
            ProjectManager pm = buildProjectManager(pmElement);
            cto.getProjectManagers().add(pm);
        }
        return cto;
    }

    private ProjectManager buildProjectManager(Element element) {
        ProjectManager pm = new ProjectManager();
        buildEmployee(pm, element);
        Element architectElement = (Element) element.getElementsByTagName(EmployeeXmlTag.SOFTWARE_ARCHITECT.getValue()).item(0);
        SoftwareArchitect architect = buildSoftwareArchitect(architectElement);
        pm.setSoftwareArchitect(architect);
        return pm;
    }

    private SoftwareArchitect buildSoftwareArchitect(Element element) {
        SoftwareArchitect architect = new SoftwareArchitect();
        buildEmployee(architect, element);
        Element teamLeads = (Element) element.getElementsByTagName(EmployeeXmlTag.TEAM_LEADERS.getValue()).item(0);
        NodeList teamLeadsList = teamLeads.getElementsByTagName(EmployeeXmlTag.TEAM_LEADER.getValue());
        for (int i = 0; i < teamLeadsList.getLength(); i++) {
            Element teamLeadElement = (Element) teamLeadsList.item(i);
            TeamLeader teamLeader = buildTeamLeader(teamLeadElement);
            architect.getTeamLeads().add(teamLeader);
        }
        Element testers = (Element) element.getElementsByTagName(EmployeeXmlTag.TESTERS.getValue()).item(0);
        NodeList testersList = testers.getElementsByTagName(EmployeeXmlTag.TESTER.getValue());
        for (int i = 0; i < testersList.getLength(); i++) {
            Element testerElement = (Element) testersList.item(i);
            Tester tester = buildTester(testerElement);
            architect.getTesters().add(tester);
        }
        return architect;
    }

    private TeamLeader buildTeamLeader(Element element) {
        TeamLeader teamLeader = new TeamLeader();
        buildEmployee(teamLeader, element);
        Element juniorDevs = (Element) element.getElementsByTagName(EmployeeXmlTag.JUNIOR_DEVS.getValue()).item(0);
        NodeList juniorDevsList = juniorDevs.getElementsByTagName(EmployeeXmlTag.JUNIOR.getValue());
        for (int i = 0; i < juniorDevsList.getLength(); i++) {
            Element juniorDevElement = (Element) juniorDevsList.item(i);
            JuniorDeveloper juniorDeveloper = buildJuniorDeveloper(juniorDevElement);
            teamLeader.getJuniorDevelopers().add(juniorDeveloper);
        }
        Element middlesDevs = (Element) element.getElementsByTagName(EmployeeXmlTag.MIDDLE_DEVS.getValue()).item(0);
        NodeList middleDevsList = middlesDevs.getElementsByTagName(EmployeeXmlTag.MIDDLE.getValue());
        for (int i = 0; i < middleDevsList.getLength(); i++) {
            Element middleDevElement = (Element) middleDevsList.item(i);
            MiddleDeveloper middleDeveloper = buildMiddleDeveloper(middleDevElement);
            teamLeader.getMiddleDevelopers().add(middleDeveloper);
        }
        Element seniorDevs = (Element) element.getElementsByTagName(EmployeeXmlTag.SENIOR_DEVS.getValue()).item(0);
        NodeList seniorDevsList = seniorDevs.getElementsByTagName(EmployeeXmlTag.SENIOR.getValue());
        for (int i = 0; i < seniorDevsList.getLength(); i++) {
            Element seniorDevElement = (Element) seniorDevsList.item(i);
            SeniorDeveloper seniorDeveloper = buildSeniorDeveloper(seniorDevElement);
            teamLeader.getSeniorDevelopers().add(seniorDeveloper);
        }
        return teamLeader;
    }

    private Tester buildTester(Element element) {
        Tester tester = new Tester();
        buildEmployee(tester, element);
        return tester;
    }

    private JuniorDeveloper buildJuniorDeveloper(Element element) {
        JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
        buildEmployee(juniorDeveloper, element);
        int efficiency = Integer.parseInt(getElementTextContent(element, EmployeeXmlTag.EFFICIENCY.getValue()));
        juniorDeveloper.setEfficiency(efficiency);
        return juniorDeveloper;
    }

    private MiddleDeveloper buildMiddleDeveloper(Element element) {
        MiddleDeveloper middleDeveloper = new MiddleDeveloper();
        buildEmployee(middleDeveloper, element);
        int efficiency = Integer.parseInt(getElementTextContent(element, EmployeeXmlTag.EFFICIENCY.getValue()));
        middleDeveloper.setEfficiency(efficiency);
        return middleDeveloper;
    }

    private SeniorDeveloper buildSeniorDeveloper(Element element) {
        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
        buildEmployee(seniorDeveloper, element);
        int efficiency = Integer.parseInt(getElementTextContent(element, EmployeeXmlTag.EFFICIENCY.getValue()));
        seniorDeveloper.setEfficiency(efficiency);
        return seniorDeveloper;
    }



    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        return nodeList.item(0).getTextContent();
    }
}
