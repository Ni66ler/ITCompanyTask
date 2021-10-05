package by.bsuir.study.xml.entity;

public abstract class Employee {
    private String name;
    private String contactNumber;
    private String email;
    private int workExperience;

    public Employee(){}

    public Employee(String name, String contactNumber, String email, int workExperience) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.workExperience = workExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}
