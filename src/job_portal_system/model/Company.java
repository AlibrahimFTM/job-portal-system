package job_portal_system.model;

import job_portal_system.model.enums.UserType;


public class Company extends User {
    private String companyName;
    private String location;
    private String sector;
    private String industry;
    private String contactEmail;
    
    public Company(int userId, String name, String email, String password,
                   String companyName, String location, String sector, 
                   String industry, String contactEmail) {
        super(userId, name, email, password, UserType.Company);
        this.companyName = companyName;
        this.location = location;
        this.sector = sector;
        this.industry = industry;
        this.contactEmail = contactEmail;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getSector() {
        return sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    
    public String getIndustry() {
        return industry;
    }
    
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
    public String getContactEmail() {
        return contactEmail;
    }
    
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
