package by.bsuir.study.xml.entity;

public class SeniorDeveloper extends Developer {

    public SeniorDeveloper() {
    }

    public SeniorDeveloper(int efficiency) {
        super(efficiency);
    }

    public SeniorDeveloper(String name, String contactNumber, String email, int workExperience, int efficiency) {
        super(name, contactNumber, email, workExperience, efficiency);
    }

    @Override
    public void writeCode() {
        System.out.println("Programs components");
    }

    public void doBaseTest() {
        System.out.println("Deals with the base testing of components");
    }

    public void doDetailEngineering() {
        System.out.println("Deals with the detailed engineering of the project");
    }
}
