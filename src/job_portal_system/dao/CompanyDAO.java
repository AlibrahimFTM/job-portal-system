// job_portal_system/dao/CompanyDAO.java
package job_portal_system.dao;

import job_portal_system.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import job_portal_system.model.User;

public class CompanyDAO {

    public void save(Company c) throws SQLException {
        String sql = 
              "INSERT INTO companies "
            + "(user_id, company_name, sector, industry, contact_email) "
            + "VALUES (?,?,?,?,?)";
        String locationSql = "INSERT INTO company_locations (company_id, location) VALUES (?, ?)";
        
        
        Connection conn = DBConnection.get();
        conn.setAutoCommit(false);
        try{
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getId());
            ps.setString(2, c.getCompanyName());
            ps.setString(3, c.getSector());
            ps.setString(4, c.getIndustry());
            ps.setString(5, c.getContactEmail());
            ps.executeUpdate();
        }
        
        try (PreparedStatement ps = conn.prepareStatement(locationSql)) {
            String[] locations = c.getLocation().split(",");
            for (String loc : locations) {
                ps.setInt(1, c.getId());
                ps.setString(2, loc.trim());
                ps.addBatch();
                }
            ps.executeBatch();
            }

            conn.commit();
        }
        catch(SQLException ex){
                conn.rollback();
                throw ex;
        }finally{
        conn.setAutoCommit(true);
        }
    }


    public Company findById(int userId) throws SQLException {
        String sql =
            "SELECT u.user_id, u.Fname,u.Lname, u.email, u.password, " +
            "  c.company_name, c.sector, c.industry, c.contact_email " +
            "  FROM users u " +
            "  JOIN companies c ON u.user_id = c.user_id " +
            " WHERE u.user_id = ?";
        String locationSql = "SELECT  location FROM company_locations WHERE company_id=? ";
        

        try (Connection conn = DBConnection.get();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                String fullname=rs.getString("Fname")+" "+rs.getString("Lname");
                
                StringBuilder locationB= new StringBuilder();
                
                try(PreparedStatement psLoc = conn.prepareStatement(locationSql)){
                    psLoc.setInt(1, userId);
                   try (ResultSet rsLoc = psLoc.executeQuery()) {
                        while(rsLoc.next()){
                            if(locationB.length()>0){
                                locationB.append(", ");
                            }
                            locationB.append(rsLoc.getString("location"));
                        }

                    } 
                }
                
                    
                return new Company(
                    rs.getInt("user_id"),
                    fullname,
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("company_name"),
                    locationB.toString() ,//
                    rs.getString("sector"),
                    rs.getString("industry"),
                    rs.getString("contact_email")
                );
            }
        }
    
    }


    public void update(Company c) throws SQLException {
        String sql = 
              "UPDATE companies SET "
            + "company_name  = ?, "
            + "sector        = ?, "
            + "industry      = ?, "
            + "contact_email = ? "
            + "WHERE user_id = ?";
            
        String deletlocationSql = "DELETE FROM company_locations WHERE company_id=? ";
        String insertlocationSql = "INSERT INTO company_locations (company_id, location) VALUES (?, ?) ";
        

        Connection conn = DBConnection.get();
        conn.setAutoCommit(false);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getCompanyName());
            ps.setString(2, c.getSector());
            ps.setString(3, c.getIndustry());
            ps.setString(4, c.getContactEmail());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        }
        try (PreparedStatement ps = conn.prepareStatement(deletlocationSql)) {
                ps.setInt(1, c.getId());
                ps.executeUpdate();
            }
        try (PreparedStatement ps = conn.prepareStatement(insertlocationSql)) {
            String[] locations = c.getLocation().split(",");
            for (String loc : locations) {
                ps.setInt(1, c.getId());
                ps.setString(2, loc.trim());
                ps.addBatch();
                }
            ps.executeBatch();
            }
        
            conn.commit();
        }

    public void delete(int userId) throws SQLException {
        String sql = 
              "DELETE FROM companies "
            + "WHERE user_id = ?";
        String deletlocationSql = "DELETE FROM company_locations WHERE company_id=? ";
        Connection conn = DBConnection.get();
        
        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        }
        try (PreparedStatement ps = conn.prepareStatement(deletlocationSql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        }
    }
}

