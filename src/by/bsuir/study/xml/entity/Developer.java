package by.bsuir.study.xml.entity;

public abstract class Developer extends Employee{
    private int efficiency;

    public Developer(){}

    public Developer(int efficiency) {
        this.efficiency = efficiency;
    }

    public Developer(String name, String contactNumber, String email, int workExperience, int efficiency) {
        super(name, contactNumber, email, workExperience);
        this.efficiency = efficiency;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public abstract void writeCode();
}
