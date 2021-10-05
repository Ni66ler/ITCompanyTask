package by.bsuir.study.xml.entity;

public class MiddleDeveloper extends Developer {

    public MiddleDeveloper() {
    }

    public MiddleDeveloper(int efficiency) {
        super(efficiency);
    }

    public MiddleDeveloper(String name, String contactNumber, String email, int workExperience, int efficiency) {
        super(name, contactNumber, email, workExperience, efficiency);
    }

    @Override
    public void writeCode() {
        System.out.println("Write the assigned component of the system");
    }

    public void supportJuniorDevelopers(){
        System.out.println("Helps juniors");
    }


}
