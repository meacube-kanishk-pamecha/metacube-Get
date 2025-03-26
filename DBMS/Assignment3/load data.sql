create DATABASE School;
USE School;
CREATE TABLE student (
id INT ,
first_name VARCHAR(50) ,
last_name VARCHAR(50) );


LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/data.txt' 
INTO TABLE student 
FIELDS TERMINATED BY ','  
LINES TERMINATED BY '\n';   
select * from student;

ALTER TABLE Student
ADD CONSTRAINT PK_Person PRIMARY KEY (id);
ALTER TABLE student
modify COLUMN id int NOT NULL;

-- ALTER TABLE 
-- ADD FOREIGN KEY () REFERENCES xyz();

ALTER TABLE student
ADD CONSTRAINT UC_Person UNIQUE (ID); 

ALTER TABLE student AUTO_INCREMENT=100;