package job_portal_system.model;

import java.time.LocalDateTime;
import job_portal_system.model.enums.ApplicationStatus;

public class Application {
    private int id;
    private int jobId;
    private int studentId;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;

    public Application(int id, int jobId, int studentId,  ApplicationStatus status, LocalDateTime appliedAt) {
        this.id = id;
        this.jobId = jobId;
        this.studentId = studentId;
        this.status = status;
        this.appliedAt = appliedAt;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getJobId() {
        return jobId;
    }
    
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public ApplicationStatus getAppStatus() {
        return status;
    }
    
    public void setAppStatus(ApplicationStatus status) {
        this.status = status;
    }
    
    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }
    
    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
}

