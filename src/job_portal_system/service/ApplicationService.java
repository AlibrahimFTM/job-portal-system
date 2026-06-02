package job_portal_system.service;

import job_portal_system.dao.ApplicationDAO;
import job_portal_system.model.enums.ApplicationStatus;

import java.sql.SQLException;
import java.util.List;
import job_portal_system.model.Application;

public class ApplicationService {
    private final ApplicationDAO dao = new ApplicationDAO();

    /** Student applies for a job */
    public void applyForJob(int jobId, int studentId) throws SQLException {
        dao.create(jobId, studentId);
    }

    /** List all of the current student’s applications */
    public List<Application> listMyApplications(int studentId) throws SQLException {
        return dao.findByStudent(studentId);
    }

    /** List all applications for a given job (provider view) */
    public List<Application> listApplicationsForJob(int jobId) throws SQLException {
        return dao.findByJob(jobId);
    }
    
    
       /** List all applications */
    public List<Application> listAllApplications() throws SQLException {
        return dao.findAll();
    }

       public List<Application> listApplicationsForProvider(int Id) throws SQLException {
        return dao.findByProvider(Id);
    }

    /** Provider accepts or rejects an application */
    public void updateApplicationStatus(int jobID , int studentID, ApplicationStatus newStatus) 
            throws SQLException {
        
        dao.updateStatus(jobID,studentID,newStatus);
    }

    /** Student withdraws their application */
    public void withdrawApplication(int jobID , int studentID) throws SQLException {
        dao.deleteById(jobID,studentID);
    }
}
