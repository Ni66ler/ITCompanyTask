package by.bsuir.study.xml.entity;

public class ProjectManager extends Employee {
    private SoftwareArchitect softwareArchitect;

    public ProjectManager(SoftwareArchitect softwareArchitect) {
        this.softwareArchitect = softwareArchitect;
    }

    public ProjectManager(String name, String contactNumber, String email,
                          int workExperience, SoftwareArchitect softwareArchitect) {
        super(name, contactNumber, email, workExperience);
        this.softwareArchitect = softwareArchitect;
    }

    public SoftwareArchitect getSoftwareArchitect() {
        return softwareArchitect;
    }

    public void setSoftwareArchitect(SoftwareArchitect softwareArchitect) {
        this.softwareArchitect = softwareArchitect;
    }

    public void setPriorities() {
        System.out.println("Prioritizes something");
    }

}
