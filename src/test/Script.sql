# ====================================================================
# ========= MASTER SCRIPT OF EDUTRACK TABLES RELATIONSHIPS ===========
# ====================================================================
#

DROP TABLE IF EXISTS SubjectMast;
DROP TABLE IF EXISTS GradeMast;
DROP TABLE IF EXISTS SchoolMast;
DROP TABLE IF EXISTS SchoolCourse;
DROP TABLE IF EXISTS SchoolSubjects;
DROP TABLE IF EXISTS SchoolGrades;
DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS StudentCourseMarks;


CREATE TABLE SubjectMast
(
  ID          INT PRIMARY KEY AUTO_INCREMENT,
  SubjectCode CHAR(5) NOT NULL,
  SubjectName VARCHAR(100)
);

CREATE TABLE GradeMast
(
  ID        INT PRIMARY KEY AUTO_INCREMENT,
  GradeCode CHAR(5) NOT NULL,
  Grade     INT     NOT NULL
);

# --------------------------------------------------------------------
# -------------------------- SCHOOL TABLES ---------------------------
# --------------------------------------------------------------------
CREATE TABLE SchoolMast
(
  ID         INT PRIMARY KEY AUTO_INCREMENT,
  SchoolName VARCHAR(255) NOT NULL
);

CREATE TABLE SchoolGrades
(
  ID        INT PRIMARY KEY AUTO_INCREMENT,
  ClassCode CHAR(5) NOT NULL,
  school_id INT     NOT NULL,
  grade_id  INT     NOT NULL,
  CONSTRAINT SchoolGrade_FK FOREIGN KEY (school_id) REFERENCES SchoolMast (ID),
  CONSTRAINT SchoolGradeMast_FK FOREIGN KEY (grade_id) REFERENCES GradeMast (ID)
);

CREATE TABLE SchoolCourse
(
  ID         INT PRIMARY KEY AUTO_INCREMENT,
  CourseName VARCHAR(255) NOT NULL,
  Grade_id  INT          NOT NULL,
  CONSTRAINT SchoolCourseGrades_FK FOREIGN KEY (Grade_id) REFERENCES SchoolGrades (ID)
);

CREATE TABLE SchoolSubjects
(
  ID              INT PRIMARY KEY AUTO_INCREMENT,
  SubjectType     VARCHAR(50) NOT NULL,
  SubjectTypeCode CHAR(5)     NOT NULL,
  Course_id       INT         NOT NULL,
  Subject_id      INT         NOT NULL,
  CONSTRAINT SchoolCourseSubjects_FK FOREIGN KEY (Course_id) REFERENCES SchoolCourse (ID),
  CONSTRAINT SubjectMastSubjects_FK FOREIGN KEY (Subject_id) REFERENCES SubjectMast (ID)# <-- Subject_id from SubjectMast table
);



# --------------------------------------------------------------------
# -------------------------- STUDENT TABLES --------------------------
# --------------------------------------------------------------------

CREATE TABLE Students
(
  ID              INT PRIMARY KEY AUTO_INCREMENT,
  StudentName     VARCHAR(255) NOT NULL,
  StudentLastName VARCHAR(255) NOT NULL
);

CREATE TABLE StudentCourseMarks
(
  ID         INT PRIMARY KEY AUTO_INCREMENT,
  Remarks    VARCHAR(50) NOT NULL,
  Term       INT         NOT NULL,
  Mark       INT         NOT NULL,
  TotalMark  INT         NOT NULL,
  student_id INT         NOT NULL,
  school_id  INT         NOT NULL,
  course_id  INT         NOT NULL,
  subject_id INT         NOT NULL,
  grade_id   INT         NOT NULL,
  CONSTRAINT student_fk FOREIGN KEY (student_id) REFERENCES Students (ID),
  CONSTRAINT student_school_fk FOREIGN KEY (school_id) REFERENCES SchoolMast (ID),
  CONSTRAINT student_subject_fk FOREIGN KEY (subject_id) REFERENCES SchoolSubjects (ID),
  CONSTRAINT student_course_fk FOREIGN KEY (course_id) REFERENCES SchoolCourse (ID),
  CONSTRAINT student_grade_fk FOREIGN KEY (grade_id) REFERENCES SchoolGrades (ID)

);

# --------------------------------------------------------------------
# ------------------------ INSERT INTO TABLES ------------------------
# --------------------------------------------------------------------

INSERT INTO subjectmast (ID, SubjectCode, SubjectName)
VALUES (NULL, 'ENG', 'English'),
       (NULL, 'LFS', 'Life Sciences');

INSERT INTO grademast (ID, GradeCode, Grade)
VALUES (NULL, 'Grd8', '8'),
       (NULL, 'Grd9', '9'),
       (NULL, 'Grd10', '10'),
       (NULL, 'Grd11', '11'),
       (NULL, 'Grd12', '12');

INSERT INTO schoolmast (ID, SchoolName)
VALUES (NULL, 'School Name One'),
       (NULL, 'School Name Two');

INSERT INTO schoolcourse (ID, CourseName, School_id)
VALUES (NULL, 'Sciences', '1'),
       (NULL, 'Drama', '2'),
       (NULL, 'Language', '1');

INSERT INTO schoolsubjects (ID, SubjectType, SubjectTypeCode, Course_id, Subject_id)
VALUES (NULL, 'Home Language', 'HL', '3', '1'),
       (NULL, 'First Additional Language', 'FAL', '3', '2');

INSERT INTO schoolgrades (ID, ClassCode, school_id, grade_id)
VALUES (NULL, 'A', '1', '1'),
       (NULL, 'B', '1', '1'),
       (NULL, 'C', '1', '1'),
       (NULL, 'A', '2', '1'),
       (NULL, 'B', '2', '1');

INSERT INTO students (ID, StudentName, StudentLastName)
VALUES (NULL, 'StudentMast', 'One'),
       (NULL, 'StudentMast', 'Two');

INSERT INTO studentcoursemarks (ID, Remarks, Term, Mark, TotalMark, student_id, school_id, course_id,
                                subject_id, grade_id)
VALUES (NULL, 'Well done', '1', '50', '50', '1', '1', '3', '2', '1'),
       (NULL, 'Work more on your home language', '1', '40', '45', '1', '1', '3', '1', '1');
