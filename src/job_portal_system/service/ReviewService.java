package job_portal_system.service;

//import job_portal_system.dao.ReviewDAO;
//import job_portal_system.model.Review;
//
//import java.util.List;
//
//public class ReviewService {
//    private final ReviewDAO reviewDAO = new ReviewDAO();
//
//    /** يضيف تقييم جديد لشركة */
//    public void addReview(Review review) throws Exception {
//        review.setId(job_portal_system.util.IdGenerator.generate());
//        reviewDAO.save(review);
//    }
//
//    /** يعيد كل التقييمات لشركة */
//    public List<Review> listReviewsForCompany(String companyId) throws Exception {
//        return reviewDAO.findByCompany(companyId);
//    }
//
//    /** يحسب متوسط التقييمات وعددها */
//    public ReviewDAO.Stats getReviewStats(String companyId) throws Exception {
//        return reviewDAO.getStats(companyId);
//    }
//}
