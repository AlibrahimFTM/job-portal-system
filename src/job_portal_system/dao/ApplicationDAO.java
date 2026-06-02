package job_portal_system.dao;

import job_portal_system.model.Application;
import job_portal_system.model.enums.ApplicationStatus;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {

    /** Create: student applies for a job */
    public void create(int jobId, int studentId) throws SQLException {
        String sql = 
            "INSERT INTO applications(job_id, student_id, app_status, applied_at) " +
            "VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        try (Connection c = DBConnection.get();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, jobId);
            p.setInt(2, studentId);
            p.setString(3, ApplicationStatus.PENDING.name());
            p.executeUpdate();
        }
    }

    /** Read: all applications by a given student */
    public List<Application> findByStudent(int studentId) throws SQLException {
        String sql = 
            "SELECT job_id, student_id, app_status, applied_at " +
            "FROM applications WHERE student_id = ?";
        List<Application> apps = new ArrayList<>();
        try (Connection c = DBConnection.get();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, studentId);
            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {
                    apps.add(mapRow(rs));
                }
            }
        }
        return apps;
    }

    /** Read: all applications for a given job (provider) */
    public List<Application> findByJob(int jobId) throws SQLException {
        String sql =
            "SELECT job_id, student_id, app_status, applied_at " +
            "FROM applications WHERE job_id = ?";
        List<Application> apps = new ArrayList<>();
        try (Connection c = DBConnection.get();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, jobId);
            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {
                    apps.add(mapRow(rs));
                }
            }
        }
        return apps;
    }
    
    
    
    
    

    /** Update: change application status (ACCEPTED/REJECTED) */
    public void updateStatus(int jobId, int studentId, ApplicationStatus newStatus) throws SQLException {
        String sql =
            "UPDATE applications SET app_status = ?  WHERE job_id = ? AND student_id = ?";
        try (Connection c = DBConnection.get();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, newStatus.name());
            p.setInt(2, jobId);
            p.setInt(3, studentId);
            p.executeUpdate();
        }
    }

    /** Delete: withdraw an application */
    public void deleteById(int jobId, int studentId) throws SQLException {
        String sql = "DELETE FROM applications WHERE job_id = ? AND student_id = ?";
        try (Connection c = DBConnection.get();
            PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, jobId);
            p.setInt(2, studentId);
            p.executeUpdate();
        }
    }
   /** Read: fetch **all** applications (admin view) */
public List<Application> findAll() throws SQLException {
    String sql =
        "SELECT job_id, student_id, app_status, applied_at " +
        "FROM applications ORDER BY applied_at DESC";

    List<Application> apps = new ArrayList<>();
    try (Connection c = DBConnection.get();
         PreparedStatement p = c.prepareStatement(sql);
         ResultSet rs = p.executeQuery()) {

        while (rs.next()) {
            apps.add(mapRow(rs));   
        }
    }
    return apps;
}
 
    
    /** Helper to map a ResultSet row to your model */
    private Application mapRow(ResultSet rs) throws SQLException {
        int jobId     = rs.getInt("job_id");
        int seekerId  = rs.getInt("student_id");
        ApplicationStatus status = ApplicationStatus.valueOf(rs.getString("app_status"));
        Timestamp ts  = rs.getTimestamp("applied_at");
        LocalDateTime appliedAt = ts.toLocalDateTime();
        return new Application(0,jobId, seekerId, status, appliedAt);
    }
    

public List<Application> findByProvider(int providerId) throws SQLException {

    String sql =
            "SELECT a.job_id, a.student_id, a.app_status, a.applied_at " +
            "FROM applications a " +
            "JOIN jobs j ON a.job_id = j.id " +
            "WHERE j.provider_id = ? " +         
            "ORDER BY a.applied_at DESC";

    List<Application> apps = new ArrayList<>();
    try (Connection c = DBConnection.get();
         PreparedStatement ps = c.prepareStatement(sql)) {

        ps.setInt(1, providerId);              

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                apps.add(mapRow(rs));           
            }
        }
    }
    return apps;
}

    
}
