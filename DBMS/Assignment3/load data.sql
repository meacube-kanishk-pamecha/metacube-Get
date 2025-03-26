create DATABASE School;
USE School;
CREATE TABLE student (
id INT NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL);

show variables LIKE 'secure_file_priv';
-- secure-file-priv=""
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/data.txt' 
INTO TABLE student 
FIELDS TERMINATED BY ','  
LINES TERMINATED BY '\n';   
select * from student;