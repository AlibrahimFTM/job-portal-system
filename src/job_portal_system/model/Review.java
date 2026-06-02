package job_portal_system.model;
import java.time.LocalDateTime;

public class Review {
    private int id;
    private int studentId;
    private int companyId;
    private int rating;
    private String comment;
    private LocalDateTime appliedAt;

    public Review(int id, int studentId, int companyId, int rating, String comment, LocalDateTime appliedAt) {
        this.id = id;
        this.studentId = studentId;
        this.companyId = companyId;
        this.rating = rating;
        this.comment = comment;
        this.appliedAt = appliedAt;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public int getCompanyId() {
        return companyId;
    }
    
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }
    
    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
}
