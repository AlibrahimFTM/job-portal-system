// ReviewDAO.java
package job_portal_system.dao;

import job_portal_system.model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * بالإضافة إلى عمليات CRUD، يُرجع Stats بعدد المراجعات ومتوسط التقييم.
 */
//public class ReviewDAO {
//    public static class Stats {
//        public final int count;
//        public final double average;
//        public Stats(int count, double average) {
//            this.count = count;
//            this.average = average;
//        }
//    }
//
//    public List<Review> findByCompany(String companyId) throws SQLException {
//        String sql = "SELECT * FROM reviews WHERE company_id = ?";
//        try (Connection c = DBConnection.get();
//             PreparedStatement p = c.prepareStatement(sql)) {
//            p.setString(1, companyId);
//            try (ResultSet rs = p.executeQuery()) {
//                List<Review> list = new ArrayList<>();
//                while (rs.next()) {
//                    Review r = new Review();
//                    r.setId(rs.getString("review_id"));
//                    r.setCompanyId(companyId);
//                    r.setSeekerId(rs.getString("seeker_id"));
//                    r.setRating(rs.getInt("rating"));
//                    r.setContent(rs.getString("content"));
//                    list.add(r);
//                }
//                return list;
//            }
//        }
//    }
//
//    public void save(Review r) throws SQLException {
//        String sql = "INSERT INTO reviews(review_id,company_id,seeker_id,rating,content) VALUES(?,?,?,?,?)";
//        try (Connection c = DBConnection.get();
//             PreparedStatement p = c.prepareStatement(sql)) {
//            p.setString(1, r.getId());
//            p.setString(2, r.getCompanyId());
//            p.setString(3, r.getSeekerId());
//            p.setInt(4, r.getRating());
//            p.setString(5, r.getContent());
//            p.executeUpdate();
//        }
//    }
//
//    public Stats getStats(String companyId) throws SQLException {
//        String sql = "SELECT COUNT(*) AS cnt, AVG(rating) AS avg_rating FROM reviews WHERE company_id = ?";
//        try (Connection c = DBConnection.get();
//             PreparedStatement p = c.prepareStatement(sql)) {
//            p.setString(1, companyId);
//            try (ResultSet rs = p.executeQuery()) {
//                rs.next();
//                return new Stats(rs.getInt("cnt"), rs.getDouble("avg_rating"));
//            }
//        }
//    }
//}
