DROP DATABASE IF EXISTS JOB;
CREATE DATABASE job;
USE job;

		--  Create users table & MAKE THE NAME ATTRIBUTE Composite BY SHAHAD --
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `Fname` varchar(20) NOT NULL,
  `Lname` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_role` enum('Student','Company','Admin','Profossor') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

		-- Insert data into students by joud ali alshehri until end --
        
INSERT INTO `users` (`user_id`, `Fname`, `Lname`, `email`, `password`, `user_role`) VALUES
(1, 'Ahmed', 'Al-Shehri', 'ahmed.shehri@student.edu', '482c811da5d5b4bc6d497ffa98491e38', 'Student'),
(2, 'Lina', 'Hassan', 'lina.hassan@student.edu', '482c811da5d5b4bc6d497ffa98491e38', 'Student'),
(3, 'Yousef', 'Qahtani', 'yousef.qahtani@student.edu', '482c811da5d5b4bc6d497ffa98491e38', 'Student'),
(4, 'Reem', 'Sudairi', 'reem.sudairi@student.edu', '482c811da5d5b4bc6d497ffa98491e38', 'Student'),
(5, 'Omar', 'Amri', 'omar.amri@student.edu', '482c811da5d5b4bc6d497ffa98491e38', 'Student'),
(6, 'Fatima', 'Al-Fahad', 'fatima.fahad@student.edu', '482c811da5d5b4bc6d497ffa98491e38', 'Student'),
(9, 'Hala', 'Investments', 'contact@halainvest.com', '482c811da5d5b4bc6d497ffa98491e38', 'Company'),
(10, 'Tech', 'Innovators', 'hr@techinnovators.com', '482c811da5d5b4bc6d497ffa98491e38', 'Company'),
(11, 'Super', 'Admin', 'admin@jobportal.com', '698d51a19d8a121ce581499d7b701668', 'Admin'),
(28, '111', '', '111', '698d51a19d8a121ce581499d7b701668', 'Student'),
(30, '1111', '', '1111', '698d51a19d8a121ce581499d7b701668', 'Admin'),
(31, '11113333', '', '1111133', '698d51a19d8a121ce581499d7b701668', 'Profossor'),
(32, '66', '', '66', '3295c76acbf4caaed33c36b1b5fc2cb1', 'Profossor'),
(33, '55', '', '55', 'b53b3a3d6ab90ce0268229151c9bde11', 'Company'),
(51, '666', '', '6666', '3295c76acbf4caaed33c36b1b5fc2cb1', 'Student'),
(50, '88', '', '88', '2a38a4a9316c49e5a833517c45d31070', 'Profossor'),
(34, 'EduTech', 'Arabia', 'support@edutech.com', 'dummyhash', 'Company'),
(35, 'GreenPower', 'Co.', 'hello@greenpower.com', 'dummyhash', 'Company'),
(36, 'Foodie', 'Brands', 'care@foodiebrands.com', 'dummyhash', 'Company'),
(37, 'NextGen', 'Media', 'contact@nextgenmedia.com', 'dummyhash', 'Company'),
(38, 'AutoLogix', '', 'jobs@autologix.com', 'dummyhash', 'Company'),
(39, 'CyberShield', 'Ltd.', 'info@cybershield.com', 'dummyhash', 'Company'),
(40, 'Baytak', 'Real Estate', 'sales@baytak.com', 'dummyhash', 'Company'),
(41, 'AquaLife', 'Group', 'aqualife@group.com', 'dummyhash', 'Company'),
(42, 'SmartThings', 'Arabia', 'iot@smartthings.sa', 'dummyhash', 'Company'),
(43, 'HealthBridge', '', 'contact@healthbridge.com', 'dummyhash', 'Company'),
(44, 'DesertSolar', 'Energy', 'desert@solarenergy.com', 'dummyhash', 'Company'),
(70, 'Nourah', 'Alghamdi', 'nourah70@student.edu', 'dummyhash', 'Student'),
(71, 'Salman', 'Fahad', 'salman71@student.edu', 'dummyhash', 'Student'),
(72, 'Aisha', 'Alotaibi', 'aisha72@student.edu', 'dummyhash', 'Student'),
(73, 'Rakan', 'Alshehri', 'rakan73@student.edu', 'dummyhash', 'Student'),
(74, 'Dalal', 'Almutairi', 'dalal74@student.edu', 'dummyhash', 'Student'),
(75, 'Rashed', 'Alsaeed', 'rashed75@student.edu', 'dummyhash', 'Student'),
(76, 'Mona', 'Alharbi', 'mona76@student.edu', 'dummyhash', 'Student'),
(77, 'Faisal', 'Alzahrani', 'faisal77@student.edu', 'dummyhash', 'Student'),
(78, 'Lujain', 'Alsuwailem', 'lujain78@student.edu', 'dummyhash', 'Student'),
(79, 'Yousef', 'Alqahtani', 'yousef79@student.edu', 'dummyhash', 'Student');

		-- Create students table BY Saeedah --
        
DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `user_id` int NOT NULL,
  `major` varchar(100) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `gpa` int DEFAULT NULL,
  `resume_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

		-- Insert data into students by joud ali alshehri until end --

INSERT INTO `students` (`user_id`, `major`, `year`, `gpa`, `resume_path`) VALUES
(1, 'Information Systems', 2, 4, '/resumes/ahmed_shehri.pdf'),
(2, 'Information Technology', 3, 3, '/resumes/lina_hassan.pdf'),
(3, 'Mechanical Engineering', 4, 3, '/resumes/yousef_qahtani.pdf'),
(4, 'Business Administration', 1, 4, '/resumes/reem_sudairi.pdf'),
(5, 'Computer Science', 3, 4, '/resumes/omar_amri.pdf'),
(6, 'Finance', 2, 4, '/resumes/fatima_fahad.pdf'),
(28, 'Computer Science', 4, 3, '/resumes/extra.pdf'),
(70, 'Software Engineering', 1, 3, '/resumes/student_70.pdf'),
(71, 'Cybersecurity', 2, 4, '/resumes/student_71.pdf'),
(72, 'Artificial Intelligence', 3, 2, '/resumes/student_72.pdf'),
(73, 'Data Science', 4, 3, '/resumes/student_73.pdf'),
(74, 'Information Technology', 1, 4, '/resumes/student_74.pdf'),
(75, 'Computer Engineering', 2, 3, '/resumes/student_75.pdf'),
(76, 'Business Analytics', 3, 4, '/resumes/student_76.pdf'),
(77, 'Economics', 4, 2, '/resumes/student_77.pdf'),
(78, 'Digital Media', 2, 3, '/resumes/student_78.pdf'),
(79, 'Biomedical Informatics', 1, 4, '/resumes/student_79.pdf');


		-- Create companies table by joud ali alshehri until end --
        
DROP TABLE IF EXISTS `companies`;
CREATE TABLE IF NOT EXISTS `companies` (
  `user_id` int NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `sector` varchar(100) DEFAULT NULL,
  `industry` varchar(100) DEFAULT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

		-- Insert data into companies by joud ali alshehri until end --
        
INSERT INTO companies (user_id, company_name, sector, industry, contact_email) VALUES
(9,  'Hala Investments',     'Finance',    'Investment',           'contact@halainvest.com'),
(10, 'Tech Innovators',      'Technology', 'Software Development', 'hr@techinnovators.com'),
(31, 'Gulf Holdings',        'Energy',     'Oil & Gas',            'info@gulfholdings.com'),
(33, 'Vision Future',        'Consulting', 'Business Strategy',    'future@vision.com'),
(34, 'EduTech Arabia',       'Education',  'E-learning',           'support@edutech.com'),
(35, 'GreenPower Co.',       'Energy',     'Renewables',           'hello@greenpower.com'),
(36, 'Foodie Brands',        'Retail',     'Food & Beverage',      'care@foodiebrands.com'),
(37, 'NextGen Media',        'Media',      'Content Creation',     'contact@nextgenmedia.com'),
(38, 'AutoLogix',            'Transport',  'Logistics',            'jobs@autologix.com'),
(39, 'CyberShield Ltd.',     'Security',   'Cybersecurity',        'info@cybershield.com'),
(40, 'Baytak Real Estate',   'Real Estate','Development',          'sales@baytak.com'),
(41, 'AquaLife Group',       'Health',     'Water Purification',   'aqualife@group.com'),
(42, 'SmartThings Arabia',   'Tech',       'IoT Solutions',        'iot@smartthings.sa'),
(43, 'HealthBridge',         'Healthcare', 'Medical Equipment',    'contact@healthbridge.com'),
(44, 'DesertSolar Energy',   'Energy',     'Solar Power',          'desert@solarenergy.com');

		-- Create company_locations table by shahad until end --
        
CREATE TABLE company_locations (
  company_id INT NOT NULL,
  location VARCHAR(255) NOT NULL,
  FOREIGN KEY (company_id) REFERENCES companies(user_id) ON DELETE CASCADE
);

		-- Insert data into company_locations by joud ali alshehri until end --
        
INSERT INTO company_locations (company_id, location) VALUES
(9,  'Riyadh'),
(10, 'Jeddah'),
(10, 'Khobar'),
(31, 'Dammam'),
(33, 'Khobar'),
(33, 'Riyadh'),
(34, 'Riyadh'),
(34, 'Jeddah'),
(35, 'Jubail'),
(35, 'Yanbu'),
(36, 'Jeddah'),
(37, 'Riyadh'),
(38, 'Dammam'),
(38, 'Jeddah'),
(39, 'Khobar'),
(40, 'Jeddah'),
(40, 'Makkah'),
(41, 'Yanbu'),
(42, 'Riyadh'),
(43, 'Makkah'),
(44, 'AlUla'),
(44, 'Tabuk');

		-- Create jobs table BY Saeedah --
        
DROP TABLE IF EXISTS `jobs`;
CREATE TABLE IF NOT EXISTS `jobs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `description` text,
  `posted_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `provider_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `provider_id` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

		-- Insert data into jobs by joud ali alshehri until end --

INSERT INTO `jobs` (`id`, `title`, `location`, `description`, `posted_at`, `provider_id`) VALUES
(1, 'Full Stack Developer', 'Riyadh', 'Develop full stack apps.', '2025-04-17 09:00:00', 9),
(2, 'Data Analyst', 'Jeddah', 'Analyze datasets and prepare reports.', '2025-04-17 09:15:00', 9),
(3, 'Project Manager', 'Dammam', 'Oversee project lifecycle.', '2025-04-17 09:30:00', 10),
(4, 'UI/UX Designer', 'Makkah', 'Design user interfaces and experiences.', '2025-04-17 09:45:00', 10),
(5, 'Financial Controller', 'Khobar', 'Manage company finances and budgets.', '2025-04-17 10:00:00', 9),
(6, 'Software Tester', 'Riyadh', 'Write and execute test plans.', '2025-04-17 10:15:00', 9),
(7, 'Marketing Spec.', 'Jeddah', 'Develop marketing strategies.', '2025-04-17 10:30:00', 10),
(8, 'Network Engineer', 'Dammam', 'Maintain network infrastructure.', '2025-04-17 10:45:00', 9),
(9, 'HR Coordinator', 'Makkah', 'Coordinate HR activities.', '2025-04-17 11:00:00', 10),
(10, 'AI Research Intern', 'Abha', 'Support AI research projects.', '2025-04-17 11:15:00', 10),
(11, 'Full Stack Developer', 'Riyadh', 'Develop web apps', '2025-04-20 04:27:49', 30);

		-- Create applications table & MAKE IT WEEK ENTITY LAYAN ALHARBI--
        
DROP TABLE IF EXISTS `applications`;
CREATE TABLE IF NOT EXISTS `applications` (
  `job_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  `app_status` VARCHAR(20) DEFAULT NULL,
  `applied_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`job_id`, `student_id`),
  FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`) ON DELETE CASCADE,
  FOREIGN KEY (`student_id`) REFERENCES `students` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

		-- Insert data into applications by joud ali alshehri until end --
        
INSERT INTO `applications` (`job_id`, `student_id`, `app_status`, `applied_at`) VALUES
(1, 1, 'PENDING', '2025-04-17 09:30:00'),
(2, 2, 'ACCEPTED', '2025-04-17 09:45:00'),
(3, 3, 'PENDING', '2025-04-17 10:00:00'),
(4, 4, 'REJECTED', '2025-04-17 10:10:00'),
(5, 5, 'PENDING', '2025-04-17 10:20:00'),
(6, 6, 'ACCEPTED', '2025-04-17 10:30:00'),
(7, 1, 'PENDING', '2025-04-17 10:40:00'),
(8, 2, 'PENDING', '2025-04-17 10:50:00'),
(9, 3, 'REJECTED', '2025-04-17 11:00:00'),
(10, 4, 'PENDING', '2025-04-17 11:10:00'),
(11, 5, 'PENDING', '2025-04-17 11:20:00'),
(5, 6, 'ACCEPTED', '2025-04-17 11:30:00'),
(7, 28, 'PENDING', '2025-04-20 02:53:27'),
(3, 28, 'ACCEPTED', '2025-04-20 02:58:47');

		-- Create professors table & MAKE IT Recursive RELATIONSHEP BY JOUD ALI ALSHEHRI + LAYAN ALHARBI --
        
DROP TABLE IF EXISTS `professors`;
CREATE TABLE IF NOT EXISTS `professors` (
  `user_id` INT NOT NULL,
  `department` VARCHAR(100) DEFAULT NULL,
  `research_area` VARCHAR(255) DEFAULT NULL,
  `supervisor_id` INT DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  FOREIGN KEY (`supervisor_id`) REFERENCES `professors`(`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

		-- Insert data into professors by joud ali alshehri until end --

INSERT INTO professors (user_id, department, research_area, supervisor_id) VALUES
(28, 'cs', 'CYS', NULL),
(32, 'AI', 'ML', 28),
(36, 'CIS', 'BUS', 28),
(60, 'Computer Science', 'AI', NULL),
(61, 'Business', 'Entrepreneurship', 60),
(62, 'Engineering', 'Control Systems', 60),
(63, 'Law', 'Human Rights', NULL),
(64, 'IT', 'Cybersecurity', NULL),
(65, 'Marketing', 'Digital Ads', NULL),
(66, 'Education', 'E-learning', 64),
(67, 'Finance', 'FinTech', 64),
(68, 'Health', 'Telemedicine', NULL),
(69, 'Media', 'Mass Communication', NULL);

		-- Create ratings table BY Saeedah  --
        
DROP TABLE IF EXISTS `ratings`;
CREATE TABLE IF NOT EXISTS `ratings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `company_id` int NOT NULL,
  `rating` tinyint UNSIGNED DEFAULT NULL,
  `comment` text,
  `applied_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `company_id` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


		-- Insert data into ratings by joud ali alshehri until end --
        
INSERT INTO `ratings` (`id`, `student_id`, `company_id`, `rating`, `comment`, `applied_at`) VALUES
(1, 1, 9, 5, 'Excellent opportunity and support.', '2025-04-17 12:00:00'),
(2, 2, 9, 4, 'Good team but long hours.', '2025-04-17 12:10:00'),
(3, 3, 10, 3, 'Average interview process.', '2025-04-17 12:20:00'),
(4, 4, 10, 5, 'Great mentoring and feedback.', '2025-04-17 12:30:00'),
(5, 5, 9, 4, 'Informative and concise.', '2025-04-17 12:40:00'),
(6, 6, 9, 2, 'Slow communication.', '2025-04-17 12:50:00'),
(7, 1, 10, 5, 'Loved the culture.', '2025-04-17 13:00:00'),
(8, 2, 10, 4, 'Challenging but rewarding.', '2025-04-17 13:10:00'),
(9, 3, 9, 3, 'Needs clearer guidelines.', '2025-04-17 13:20:00'),
(10, 4, 10, 5, 'Exceptional training provided.', '2025-04-17 13:30:00');

		-- Add foreign key constraints BY Saeedah --
ALTER TABLE `companies`
  ADD CONSTRAINT `companies_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

ALTER TABLE `jobs`
  ADD CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

ALTER TABLE `ratings`
  ADD CONSTRAINT `ratings_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `ratings_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `companies` (`user_id`) ON DELETE CASCADE;

ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;


		-- Select all data from all tables BY JOUD ALI ALSHEHRI --
        
SELECT * FROM users;
SELECT * FROM students;
SELECT * FROM companies;
SELECT * FROM company_locations;
SELECT * FROM jobs;
SELECT * FROM applications;
SELECT * FROM professors;
SELECT * FROM ratings;

			-- by joud ali alshehri until end -- abrar did some in the oid virsion --
            
-- Update GPA for a specific student who improved
UPDATE students
SET gpa = 4
WHERE user_id = 2;

SELECT user_id, gpa FROM students;

-- Find student emails
SELECT user_id, email FROM users
WHERE email LIKE '%@student.edu';

-- Students with GPA between 3 and 4
SELECT students.user_id, CONCAT(users.Fname, ' ', users.Lname) AS name, students.gpa
FROM users
JOIN students ON users.user_id = students.user_id
WHERE students.gpa BETWEEN 3 AND 4;


-- Get job titles for certain job IDs
SELECT id, title FROM jobs
WHERE id IN (1, 3, 5);

-- Company ratings from highest to lowest
SELECT id, company_id, rating FROM ratings
ORDER BY rating DESC;

-- Companies missing contact email
SELECT user_id, company_name FROM companies
WHERE contact_email IS NULL;

-- All IDs for students and professors
SELECT user_id, 'Student' AS role FROM students
UNION
SELECT user_id, 'Professor' AS role FROM professors;

-- Students who also exist in users table
SELECT user_id, major FROM students
WHERE user_id IN (SELECT user_id FROM users);

-- Students who did not apply for any job
SELECT user_id, major FROM students
WHERE user_id NOT IN (SELECT student_id FROM applications);

-- Majors with more than one student
SELECT major, COUNT(*) AS student_count
FROM students
GROUP BY major
HAVING COUNT(*) > 1;

-- Application info with job title
SELECT applications.job_id, applications.student_id, jobs.title
FROM applications
JOIN jobs ON applications.job_id = jobs.id;


-- Students and their applied jobs (if any)
SELECT s.user_id, CONCAT(u.Fname, ' ', u.Lname) AS name, a.job_id
FROM students s
JOIN users u ON s.user_id = u.user_id
LEFT JOIN applications a ON s.user_id = a.student_id;

-- Show all students if there's one with GPA ≠ 4
SELECT user_id, gpa FROM students
WHERE EXISTS (
  SELECT  user_id, gpa FROM students WHERE gpa <> 4
);

-- Students who applied to 'Full Stack Developer'
SELECT s.user_id, CONCAT(u.Fname, ' ', u.Lname) AS name
FROM students s
JOIN users u ON s.user_id = u.user_id
WHERE s.user_id IN (
  SELECT student_id FROM applications
  WHERE job_id IN (
    SELECT id FROM jobs WHERE title = 'Full Stack Developer'
  )
);


-- Return GPA for student ID
DROP FUNCTION IF EXISTS get_student_gpa;

DELIMITER //
CREATE FUNCTION get_student_gpa(s_id INT)
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE gpa_val INT;
  SELECT gpa INTO gpa_val FROM students WHERE user_id = s_id;
  RETURN gpa_val;
END;
//
DELIMITER ;
SELECT get_student_gpa(1);

-- Procedure to return accepted applications
DROP PROCEDURE IF EXISTS GetAcceptedApplications;

DELIMITER //
CREATE PROCEDURE GetAcceptedApplications()
BEGIN
  SELECT job_id, student_id FROM applications WHERE app_status = 'ACCEPTED';
END;
//
DELIMITER ;
CALL GetAcceptedApplications();


-- Capitalize status before insert
DROP TRIGGER IF EXISTS before_insert_application;

DELIMITER //
CREATE TRIGGER before_insert_application
BEFORE INSERT ON applications
FOR EACH ROW
BEGIN
  SET NEW.app_status = UPPER(NEW.app_status);
END;
//
DELIMITER ;

INSERT INTO applications (job_id, student_id, app_status)
VALUES (1, 2, 'pending');

SELECT job_id, student_id, app_status FROM applications;


-- View accepted apps with student name & job title
CREATE OR REPLACE VIEW accepted_applications_view AS
SELECT 
  a.job_id AS application_id,
  a.student_id,
  CONCAT(u.Fname, ' ', u.Lname) AS student_name,
  j.title AS job_title
FROM applications a
JOIN students s ON a.student_id = s.user_id
JOIN users u ON s.user_id = u.user_id
JOIN jobs j ON a.job_id = j.id
WHERE a.app_status = 'ACCEPTED';

SELECT application_id, student_name, job_title FROM accepted_applications_view;