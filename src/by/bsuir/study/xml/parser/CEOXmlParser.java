package by.bsuir.study.xml.parser;

import by.bsuir.study.xml.creater.EmployeeXmlTag;
import by.bsuir.study.xml.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        return nodeList.item(0).getTextContent();
    }
}
