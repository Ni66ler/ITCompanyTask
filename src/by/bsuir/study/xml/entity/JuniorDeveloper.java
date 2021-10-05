package by.bsuir.study.xml.entity;

public class JuniorDeveloper extends Developer {

    public JuniorDeveloper() {
    }

    public JuniorDeveloper(int efficiency) {
        super(efficiency);
    }

    public JuniorDeveloper(String name, String contactNumber, String email, int workExperience, int efficiency) {
        super(name, contactNumber, email, workExperience, efficiency);
    }

    @Override
    public void writeCode() {
        System.out.println("Perform technical tasks");
    }


}
