// job_portal_system.service.JobService.java
package job_portal_system.service;

import job_portal_system.dao.JobDAO;
import job_portal_system.model.Job;
import java.sql.SQLException;
import java.util.List;

public class JobService {
    private final JobDAO dao = new JobDAO();

    public Job postJob(Job job) throws SQLException {
        dao.save(job);
        return job;
    }

    public List<Job> listAllJobs() throws SQLException {
        return dao.findAll();
    }

    public List<Job> listMyJobs(int providerId) throws SQLException {
        return dao.findByProvider(providerId);
    }

    public void updateJob(Job job) throws SQLException {
        dao.update(job);
    }

    public void removeJob(int jobId, int providerId) throws SQLException {
        // you might check ownership first:
        Job existing = dao.findById(jobId);
        if (existing == null || existing.getProviderId() != providerId) {
            throw new IllegalArgumentException("Cannot delete a job you don't own.");
        }
        dao.delete(jobId);
    }
}
