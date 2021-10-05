package by.bsuir.study.xml.entity;

public class Tester extends Employee{

    public Tester() {
    }

    public Tester(String name, String contactNumber, String email, int workExperience) {
        super(name, contactNumber, email, workExperience);
    }

    public void checkFinishedProduct() {
        System.out.println("Check the finished product for inconsistencies and errors");
    }

    public void logErrors() {
        System.out.println("Logs any errors found");
    }
}
