package job_portal_system.dao;

import job_portal_system.model.*;
import job_portal_system.model.enums.UserType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    /**
     * Finds a user by email+password, returning the proper subclass
     * (Student, Professor, Company or Admin) with all fields loaded.
     */
    public User findByEmailAndPassword(String email, String passwordHash) throws SQLException {
        String sql =
            "SELECT user_id, Fname, Lname, email, password, user_role " +
            "FROM users " +
            "WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, passwordHash);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                int    userId = rs.getInt("user_id");
                String name   = rs.getString("Fname")+" " +rs.getString("Lname");
                String mail   = rs.getString("email");
                String pwd    = rs.getString("password");
                String role   = rs.getString("user_role");

                UserType type = UserType.valueOf(role);
                User     u;

                // use if/else rather than switch
                if (type == UserType.Student) {
                    Student s = new Student(userId, name, mail, pwd, "", 0, 0.0, "");
                    loadStudentDetails(s, conn);
                    u = s;

                } else if (type == UserType.Profossor) {
                    Professor p = new Professor(userId, name, mail, pwd, "", "");
                    loadProfessorDetails(p, conn);
                    u = p;

                } else if (type == UserType.Company) {
                    Company c = new Company(userId, name, mail, pwd,
                                            "", "", "", "", "");
                    loadCompanyDetails(c, conn);
                    u = c;

                } else { // ADMIN
                 u = new User(userId, name, mail, pwd, UserType.Admin) {};
                }

                return u;
            }
        }
    }

    /**
     * Finds a user by ID, loading subclass fields as above.
     */
    public User findById(int userId) throws SQLException {
        String sql =
            "SELECT user_id, Fname,Lname, email, password, user_role " +
            "FROM users " +
            "WHERE user_id = ?";

        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                String name   = rs.getString("Fname")+" " +rs.getString("Lname");
                String mail = rs.getString("email");
                String pwd  = rs.getString("password");
                String role = rs.getString("user_role");

                UserType type = UserType.valueOf(role);
                User     u;

                if (type == UserType.Student) {
                    Student s = new Student(userId, name, mail, pwd, "", 0, 0.0, "");
                    loadStudentDetails(s, conn);
                    u = s;

                } else if (type == UserType.Profossor) {
                    Professor p = new Professor(userId, name, mail, pwd, "", "");
                    loadProfessorDetails(p, conn);
                    u = p;

                } else if (type == UserType.Company) {
                    Company c = new Company(userId, name, mail, pwd,
                                            "", "", "", "", "");
                    loadCompanyDetails(c, conn);
                    u = c;

                } else {
                     u = new User(userId, name, mail, pwd, UserType.Admin) {};
                }

                return u;
            }
        }
    }

    /**
     * Returns all users (of any role).
     */
    public List<User> findAll() throws SQLException {
        String sql = "SELECT user_id FROM users";
        List<User> out = new ArrayList<>();

        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = findById(rs.getInt("user_id"));
                if (u != null) out.add(u);
            }
        }
        return out;
    }

    /**
     * Inserts a new user. Populates u.setId(...) with the generated key.
     */
    public void save(User u) throws SQLException {
        String sql =
            "INSERT INTO users(Fname,Lname, email, password, user_role) VALUES (?,?,?, ?, ?)";

        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            String[] parts= u.getName().split(" ",2);
            String Fname= parts[0];
            String Lname =parts.length > 1 ? parts[1]:" ";
                    
            ps.setString(1, Fname);
            ps.setString(2, Lname);
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getType().name());

            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    u.setId(keys.getInt(1));
                }
            }
        }

        // Now insert into the appropriate subtype table
        if (u instanceof Student) {
            Student s = (Student) u;
            System.out.println("DEBUG major=" + s.getMajor() + ", year=" + s.getYear());
            new StudentDAO().save(s);

        } else if (u instanceof Professor) {
            Professor p = (Professor) u;
            String sql2 =
                "INSERT INTO professors(user_id, department, research_area) VALUES (?, ?, ?)";

            try (Connection conn = DBConnection.get();
                 PreparedStatement ps = conn.prepareStatement(sql2)) {

                ps.setInt   (1, p.getId());
                ps.setString(2, p.getDepartment());
                ps.setString(3, p.getResearchArea());
                ps.executeUpdate();
            }

        } else if (u instanceof Company) {
            Company c = (Company) u;
            String sql2 =
                "INSERT INTO companies(user_id, company_name, sector, industry, contact_email) "
              + "VALUES (?, ?, ?, ?, ?)";

            try(Connection conn = DBConnection.get();){
                try (PreparedStatement ps = conn.prepareStatement(sql2)) {

                    ps.setInt   (1, c.getId());
                    ps.setString(2, c.getCompanyName());
                    ps.setString(3, c.getSector());
                    ps.setString(4, c.getIndustry());
                    ps.setString(5, c.getContactEmail());
                    ps.executeUpdate();
                }
                String sqlloc2 =
                    "INSERT INTO company_locations(company_id, location) "
                  + "VALUES (?, ?)";

                try (PreparedStatement ps = conn.prepareStatement(sqlloc2)) {
                    String[] location = c.getLocation().split(",");
                    for(String loc : location){
                        ps.setInt   (1, c.getId());
                        ps.setString(2, loc.trim());
                        ps.addBatch();
                    }
                    ps.executeBatch();
                }
            }
        }
        // Admin has no extra table
    }

    
    
   public void update(User u) throws SQLException {
  String sql = "UPDATE users SET Fname = ?,Lname = ?, email = ?, password = ?  , user_role = ?     WHERE user_id = ?";
  try ( Connection c = DBConnection.get();
        PreparedStatement ps = c.prepareStatement(sql) ) {
      
            String[] parts= u.getName().split(" ",2);
            String Fname= parts[0];
            String Lname =parts.length > 1 ? parts[1]:" ";
                    
            ps.setString(1, Fname);
            ps.setString(2, Lname);
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getType().name());
            ps.setInt(6,u.getId());
      
    int count = ps.executeUpdate();
    if(count != 1) {
      throw new SQLException("Expected to update 1 user row, but updated " + count);
    }
  }
}



    private void loadStudentDetails(Student s, Connection conn) throws SQLException {
        String sql =
            "SELECT major, year, gpa, resume_path " +
            "FROM students WHERE user_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    s.setMajor(rs.getString("major"));
                    s.setYear (rs.getInt   ("year"));
                    s.setGpa  (rs.getDouble("gpa"));
                    s.setResumePath(rs.getString("resume_path"));
                }
            }
        }
    }

    private void loadProfessorDetails(Professor p, Connection conn) throws SQLException {
        String sql =
            "SELECT department, research_area " +
            "FROM professors WHERE user_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p.setDepartment   (rs.getString("department"));
                    p.setResearchArea (rs.getString("research_area"));
                }
            }
        }
    }

    private void loadCompanyDetails(Company c, Connection conn) throws SQLException {
        String sql =
            "SELECT company_name,sector, industry, contact_email " +
            "FROM companies WHERE user_id = ?";
        String sqlloc2 =
            "SELECT company_id, location "
            + "FROM company_locations WHERE company_id = ?";
        
        // Load main company fields
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c.setCompanyName (rs.getString("company_name"));
                    c.setSector      (rs.getString("sector"));
                    c.setIndustry    (rs.getString("industry"));
                    c.setContactEmail(rs.getString("contact_email"));
                }
            }
        }

        // Load locations
        try (PreparedStatement ps = conn.prepareStatement(sqlloc2)) {
            ps.setInt(1, c.getId());
            try (ResultSet rs = ps.executeQuery()) {
                StringBuilder locations = new StringBuilder();
                while (rs.next()) {
                    if (locations.length() > 0) locations.append(", ");
                    locations.append(rs.getString("location"));
                }
                c.setLocation(locations.toString());
            }
        }
    }
}
