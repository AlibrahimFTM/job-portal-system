// job_portal_system.dao.JobDAO.java
package job_portal_system.dao;

import job_portal_system.model.Job;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    /** Create (insert new) */
    public void save(Job job) throws SQLException {
        String sql = "INSERT INTO jobs(title, location, description, provider_id) VALUES(?,?,?,?)";
        try (Connection c = DBConnection.get();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getLocation());
            ps.setString(3, job.getDescription());
            ps.setInt(4, job.getProviderId());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    job.setId(keys.getInt(1));
                }
            }
        }
    }

    /** Read one by ID */
    public Job findById(int id) throws SQLException {
        String sql = "SELECT id, title, location, description, posted_at, provider_id FROM jobs WHERE id = ?";
        try (Connection c = DBConnection.get();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return new Job(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("location"),
                    rs.getString("description"),
                    rs.getTimestamp("posted_at").toLocalDateTime(),
                    rs.getInt("provider_id")
                );
            }
        }
    }

    /** Read all jobs */
    public List<Job> findAll() throws SQLException {
        String sql = "SELECT id, title, location, description, posted_at, provider_id FROM jobs";
        List<Job> jobs = new ArrayList<>();
        try (Connection c = DBConnection.get();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                jobs.add(new Job(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("location"),
                    rs.getString("description"),
                    rs.getTimestamp("posted_at").toLocalDateTime(),
                    rs.getInt("provider_id")
                ));
            }
        }
        return jobs;
    }

    /** Read all jobs posted by one provider */
    public List<Job> findByProvider(int providerId) throws SQLException {
        String sql = "SELECT id, title, location, description, posted_at, provider_id "
                   + "FROM jobs WHERE provider_id = ?";
        List<Job> jobs = new ArrayList<>();
        try (Connection c = DBConnection.get();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, providerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    jobs.add(new Job(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getTimestamp("posted_at").toLocalDateTime(),
                        rs.getInt("provider_id")
                    ));
                }
            }
        }
        return jobs;
    }

    /** Update an existing job */
    public void update(Job job) throws SQLException {
        String sql = "UPDATE jobs SET title = ?, location = ?, description = ? WHERE id = ?";
        try (Connection c = DBConnection.get();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getLocation());
            ps.setString(3, job.getDescription());
            ps.setInt(4, job.getId());
            ps.executeUpdate();
        }
    }

    /** Delete a job */
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM jobs WHERE id = ?";
        try (Connection c = DBConnection.get();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
