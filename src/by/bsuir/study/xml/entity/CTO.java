package by.bsuir.study.xml.entity;

import java.util.HashSet;
import java.util.Set;

public class CTO extends Employee {
    private int companyResources;
    private Set<ProjectManager> projectManagers;

    public CTO() {
        projectManagers = new HashSet<>();
    }

    public CTO(int companyResources, Set<ProjectManager> projectManagers) {
        this.companyResources = companyResources;
        this.projectManagers = projectManagers;
    }

    public CTO(String name, String contactNumber, String email, int workExperience,
               int companyResources, Set<ProjectManager> projectManagers) {
        super(name, contactNumber, email, workExperience);
        this.companyResources = companyResources;
        this.projectManagers = projectManagers;
    }

    public Set<ProjectManager> getProjectManagers() {
        return projectManagers;
    }

    public void setProjectManagers(Set<ProjectManager> projectManagers) {
        this.projectManagers = projectManagers;
    }

    public int getCompanyResources() {
        return companyResources;
    }

    public void setCompanyResources(int companyResources) {
        this.companyResources = companyResources;
    }

    public void createTechnicalStrategy(){
        System.out.println("Find a strategic resolution of scientific and technical issues");
    }
}
