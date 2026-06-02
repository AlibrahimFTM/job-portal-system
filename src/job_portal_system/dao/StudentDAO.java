package job_portal_system.dao;

import job_portal_system.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import job_portal_system.model.User;

/**
 * DAO for the `students` table.
 * Expects that the corresponding User row (in `users`) already exists.
 */
public class StudentDAO   {

    /**
     * Inserts a new row into students for the given Student.
     * @param s the Student (must have s.getId() set to the users.user_id PK)
     */
    public void save(Student s) throws SQLException {
        String sql = "INSERT INTO students(user_id, major, year, gpa, resume_path) VALUES (?,?,?,?,?) ";

        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getMajor());
            ps.setInt(3, s.getYear());
            ps.setDouble(4, s.getGpa());
            ps.setString(5, s.getResumePath());
            ps.executeUpdate();
        }
    }

    /**
     * Loads a Student by their user_id.
     * Also loads the base User fields via UserDAO.findById().
     */
    public Student findById(int userId) throws SQLException {
        String sql = "SELECT major, year, gpa, resume_path FROM students WHERE user_id = ?";
        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                // load the base User first
                User base = new UserDAO().findById(userId);
                if (!(base instanceof Student)) {
                    throw new SQLException("User " + userId + " is not a Student");
                }
                Student s = (Student) base;
                s.setMajor(rs.getString("major"));
                s.setYear(rs.getInt("year"));
                s.setGpa(rs.getDouble("gpa"));
                s.setResumePath(rs.getString("resume_path"));
                return s;
            }
        }
    }

    /**
     * Updates an existing students row.
     */
    public void update(Student s) throws SQLException {
        String sql = "UPDATE students SET major = ?, year = ?, gpa = ?, resume_path = ? WHERE user_id = ? ";
        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getMajor());
            ps.setInt(2, s.getYear());
            ps.setDouble(3, s.getGpa());
            ps.setString(4, s.getResumePath());
            ps.setInt(5, s.getId());
            ps.executeUpdate();
        }
    }

    /**
     * Deletes the students row for the given user_id.
     * Cascading on the `users` table FK will clean up the base user.
     */
    public void delete(int userId) throws SQLException {
        String sql = "DELETE FROM students WHERE user_id = ?";
        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.executeUpdate();
        }
    }
}
