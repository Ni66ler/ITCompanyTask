package by.bsuir.study.xml.creater;

public enum EmployeeXmlTag {
    CEO("ceo"),
    CTO("cto"),
    PROJECT_MANAGER("project_manager"),
    SOFTWARE_ARCHITECT("software_architect"),
    TEAM_LEADER("team_leader"),
    TESTER("tester"),
    JUNIOR("junior_developer"),
    MIDDLE("middle_developer"),
    SENIOR("senior_developer"),
    NAME("name"),
    CONTACT_NUMBER("contact_number"),
    EMAIL("email"),
    WORK_EXPERIENCE("work_experience"),
    EXTERNAL_CONTACTS("external_contacts"),
    OVERALL_STRATEGY("overall_strategy"),
    COMPANY_RESOURCES("company_resources"),
    PROJECT_MANAGERS("project_managers"),
    TESTERS("testers"),
    TEAM_LEADERS("team_leaders"),
    JUNIOR_DEVS("junior_developers"),
    MIDDLE_DEVS("middle_developers"),
    SENIOR_DEVS("senior_developers"),
    EFFICIENCY("efficiency");
    private String value;
    EmployeeXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
