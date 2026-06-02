package job_portal_system.service;

import job_portal_system.dao.UserDAO;
import job_portal_system.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO dao = new UserDAO();

    /**
     * Fetch all users from the database.
     */
    public List<User> listUsers() throws SQLException {
        return dao.findAll();
    }

    /**
     * Update an existing user (name, email, role, etc.).
     * Password should be set on the User object before calling.
     */
    public void updateUser(User u) throws SQLException {
      dao.update(u);
    }
    
        public User findById(int id) throws SQLException {
       return dao.findById(id);
    }

    /**
     * Delete a user by its ID.
     */
    public void deleteUser(int id) throws SQLException {
      //  dao.delete(String.valueOf(id));
    }




}
