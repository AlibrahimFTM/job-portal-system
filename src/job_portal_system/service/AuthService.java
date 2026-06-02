package job_portal_system.service;

import job_portal_system.dao.UserDAO;
import job_portal_system.model.User;
import job_portal_system.util.IdGenerator;

import java.security.MessageDigest;
import job_portal_system.dao.CompanyDAO;
import job_portal_system.dao.StudentDAO;
import job_portal_system.model.Company;
import job_portal_system.model.Student;
import static job_portal_system.model.enums.UserType.Company;
import static job_portal_system.model.enums.UserType.Student;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();
   private final StudentDAO studentDao = new StudentDAO();
  private final CompanyDAO companyDAO = new CompanyDAO();
    private String hash(String s) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes());
        return new java.math.BigInteger(1, md.digest()).toString(16);
    }

   
    public User login(String email, String password) throws Exception {
        String h = hash(password);
        User u = userDAO.findByEmailAndPassword(email, h);
        if (u == null) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        return u;
    }

   
    public User register(User user, String plainPassword) throws Exception {
     
        String h = hash(plainPassword);
        user.setPassword(h);
        userDAO.save(user);
        
        
//        
//    if (user instanceof Student) {
//        // 3) insert into students table
//        Student s = (Student)user;
//        studentDao.save(s); 
//      
//    }
//        
//        if (user instanceof Company) {
//        // 3) insert into students table
//        Company s = (Company)user;
//        companyDAO.save(s); 
//      
//    }
        
        
        return user;
    }

   
//    public void updateProfile(User user) throws Exception {
//        userDAO.update(user);
//    }
}
