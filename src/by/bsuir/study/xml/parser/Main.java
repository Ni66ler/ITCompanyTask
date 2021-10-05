package by.bsuir.study.xml.parser;

import by.bsuir.study.xml.creater.CEOXmlDocCreator;
import by.bsuir.study.xml.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        CEOXmlParser ceoXmlParser = new CEOXmlParser();
        ceoXmlParser.buildCEO("result.xml");
        System.out.println(ceoXmlParser.getCeo().getCto().getEmail());
    }
}
