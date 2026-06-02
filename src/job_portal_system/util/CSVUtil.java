//package job_portal_system.util;
//
//import job_portal_system.model.Job;
//import job_portal_system.model.Application;
//import job_portal_system.service.JobService;
//import job_portal_system.service.ApplicationService;
//import job_portal_system.model.enums.ApplicationStatus;
//
//import java.io.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
///**
// * أدوات تصدير واستيراد CSV للوظائف وطلبات التقديم.
// */
//public class CSVUtil {
//
//    /**
//     * يصدر كل الوظائف إلى ملف CSV.
//     * @param path مسار الملف للإخراج
//     * @param jobSvc خدمة الوظائف
//     */
//    public static void exportJobs(String path, JobService jobSvc) throws Exception {
//        List<Job> jobs = jobSvc.listJobs();
////        try (var writer = new BufferedWriter(new FileWriter(path))) {
////            writer.write("id,title,description,location,providerId,postedAt\n");
////            for (Job j : jobs) {
////                writer.write(String.join(",",
////                    j.getId(),
////                    escape(j.getTitle()),
////                    escape(j.getDescription()),
////                    escape(j.getLocation()),
////                    j.getProviderId(),
////                    j.getPostedAt().toString()
////                ));
////                writer.write("\n");
////            }
////        }
//    }
//
//    /**
//     * يستورد وظائف من ملف CSV.
//     * @param path مسار ملف CSV
//     * @param jobSvc خدمة الوظائف
//     */
//    public static void importJobs(String path, JobService jobSvc) throws Exception {
////        try (var reader = new BufferedReader(new FileReader(path))) {
////            String line = reader.readLine(); // تخطي الهيدر
////            while ((line = reader.readLine()) != null) {
////                String[] cols = line.split(",", -1);
////                Job j = new Job();
////                j.setId(cols[0]);
////                j.setTitle(unescape(cols[1]));
////                j.setDescription(unescape(cols[2]));
////                j.setLocation(unescape(cols[3]));
////                j.setProviderId(cols[4]);
////                j.setPostedAt(LocalDate.parse(cols[5]));
////                jobSvc.postOrUpdateJob(j);
////            }
////        }
//    }
//
//  
//    public static void exportApplications(String path,
//                                          ApplicationService appSvc,
//                                          String seekerId) throws Exception {
////        List<Application> apps = appSvc.listMyApplications(seekerId);
////        try (var writer = new BufferedWriter(new FileWriter(path))) {
////            writer.write("id,jobId,seekerId,resumePath,status,appliedAt\n");
////            for (Application a : apps) {
////                writer.write(String.join(",",
////                    a.getId(),
////                    a.getJobId(),
////                    a.getSeekerId(),
////                    escape(a.getResumePath()),
////                    a.getStatus().name(),
////                    a.getAppliedAt().toString()
////                ));
////                writer.write("\n");
////            }
////        }
//    }
//
//    /**
//     * يستورد طلبات من ملف CSV (لنفس الطالب).
//     * @param path مسار الملف
//     * @param appSvc خدمة الطلبات
//     * @param seekerId معرف الطالب
//     */
//    public static void importApplications(String path,
//                                          ApplicationService appSvc,
//                                          String seekerId) throws Exception {
////        try (var reader = new BufferedReader(new FileReader(path))) {
////            String line = reader.readLine(); // تخطي الهيدر
////            while ((line = reader.readLine()) != null) {
////                String[] cols = line.split(",", -1);
////                Application a = new Application();
////                a.setId(cols[0]);
////                a.setJobId(cols[1]);
////                a.setSeekerId(seekerId);
////                a.setResumePath(unescape(cols[3]));
////                a.setStatus(ApplicationStatus.valueOf(cols[4]));
////                a.setAppliedAt(LocalDateTime.parse(cols[5]));
////                // نفترض أن التطبيق يدعم حفظ كائنات Application كاملة
////                appSvc.apply(a);
////            }
////        }
//    }
//
//    // يساعد على حماية الفواصل داخل النص
//    private static String escape(String s) {
//        return s.replace("\"", "\"\"").replace(",", "\\,");
//    }
//
//    private static String unescape(String s) {
//        return s.replace("\\,", ",").replace("\"\"", "\"");
//    }
//}
