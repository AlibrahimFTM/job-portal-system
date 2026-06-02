package job_portal_system.model;

import java.time.LocalDateTime;



public class Job {
    private int id;
    private String title;
    private String location;
    private String description;
    private LocalDateTime postedAt;
    private int providerId;

    public Job(int id, String title, String location, String description,
               LocalDateTime postedAt, int providerId) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.description = description;
        this.postedAt = postedAt;
        this.providerId = providerId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDateTime getPostedAt() {
        return postedAt;
    }
    
    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }
    
    public int getProviderId() {
        return providerId;
    }
    
    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
}
