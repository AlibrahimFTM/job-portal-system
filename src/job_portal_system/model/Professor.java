package job_portal_system.model;


import job_portal_system.model.enums.UserType;




public class Professor extends User {
    private String department;
    private String researchArea;
    
    public Professor(int userId, String name, String email, String password, 
                     String department, String researchArea) {
        super(userId, name, email, password, UserType.Profossor);
        this.department = department;
        this.researchArea = researchArea;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getResearchArea() {
        return researchArea;
    }
    
    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }
}
