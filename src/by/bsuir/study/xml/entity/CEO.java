package by.bsuir.study.xml.entity;

import java.util.HashSet;
import java.util.Set;

public class CEO extends Employee{
    private String overallStrategy;
    private CTO cto;

    public CEO() {
    }

    public CEO(String overallStrategy, CTO cto) {
        this.overallStrategy = overallStrategy;
        this.cto = cto;
    }

    public CEO(String name, String contactNumber, String email, int workExperience,
               String overallStrategy, CTO cto) {
        super(name, contactNumber, email, workExperience);
        this.overallStrategy = overallStrategy;
        this.cto = cto;
    }

    public String getOverallStrategy() {
        return overallStrategy;
    }

    public void setOverallStrategy(String overallStrategy) {
        this.overallStrategy = overallStrategy;
    }

    public CTO getCto() {
        return cto;
    }

    public void setCto(CTO cto) {
        this.cto = cto;
    }
}
