
package job_portal_system.service;

//import job_portal_system.dao.CompanyDAO;
//import job_portal_system.model.Company;
//
//import java.util.List;
//
//public class CompanyService {
//    private final CompanyDAO compDAO = new CompanyDAO();
//
//    /** يعيد كل الشركات */
//    public List<Company> listCompanies() throws Exception {
//        return compDAO.findAll();
//    }
//
//    /** ينشئ شركة جديدة أو يحدث موجودة */
//    public void saveCompany(Company company) throws Exception {
//        if (company.getId() == null) {
//            company.setId(job_portal_system.util.IdGenerator.generate());
//        }
//        compDAO.save(company);
//    }
//
//    /** يحذف شركة */
//    public void deleteCompany(String companyId) throws Exception {
//        compDAO.delete(companyId);
//    }
//}
