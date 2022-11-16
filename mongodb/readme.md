https://www.javatpoint.com/mariadb-procedure
https://www.inmotionhosting.com/support/server/databases/connecting-heidi-sql-database/
https://www.stackhero.io/en/services/MariaDB/documentations/Troubleshooting/How-to-connect-HeidiSQL-to-MariaDB


MariaDB is a popular, open source, and the community-based project developed by MySQL developers. It is a relational database management technology which provides the same features as MySQL. It is a new replacement for MySQL.
A list of the features of MariaDB:

MariaDB can run on different operating systems and support a wide variety of programming languages.
MariaDB is licensed under GPL, LGPL, or BSD.
MariaDB follows a standard and popular query language.
MariaDB provides Galera cluster technology.
MariaDB provides supports for PHP which is the most popular web development language.
MariaDB includes a wide selection of storage engines, including high-performance storage engines for working with other RDBMS data sources.
MariaDB also offers many operations and commands unavailable in MySQL and eliminates/replaces features impacting performance negatively.
MariaDB's speed is one of its prominent features. It is remarkably scalable and can handle tens of thousands of tables and billions of rows of data.


create database users;

show databases;
use users;

CREATE TABLE Students(  
student_id INT NOT NULL AUTO_INCREMENT,  
student_name VARCHAR(100) NOT NULL,  
student_address VARCHAR(40) NOT NULL,  
admission_date DATE,  
PRIMARY KEY ( student_id ));  

show tables;

drop table students;

INSERT INTO Students  
(student_id, student_name, student_address, admission_date)  
VALUES(1,'Monica','Iasi','2022-11-14 00:00:00');  

INSERT INTO Students  
(student_id, student_name, student_address, admission_date)  
VALUES  
(3,'John','Australia','2016-05-07 00:00:00'),  
(4,'Eve','USA','2016-06-07 00:00:00'),  
(5,'Laura','France','2016-02-07 00:00:00'),  
(6,'Robert','UK','2016-08-07 00:00:00');  
SELECT * FROM students


SELECT student_id, student_name, student_address  
FROM Students  
WHERE student_id <= 7  
ORDER BY student_id DESC  
LIMIT 4;  


__________________________________________________

- create new spring project > maven, Spring Web + Spring Data MongoDB dependencies

- create a package model and add a java class:
- @Document to set the collection name that will be used by the model
- if the collection doesn’t exist, MongoDB will create it


- create a package repository
- create an BookRepository public interface which extends the MongoRepository interface


- create a main class that implements CommandLineRunner (@SpringBootApplication
@EnableMongoRepositories)
- @Autowired
  BookRepository bookRepository;
  
  Create a database/cluster on:
  https://cloud.mongodb.com/v2/63749aaf2ecbb217fb01c691#clusters
  
  Connect your Java application and get the
  
spring.data.mongodb.uri=mongodb+srv://<username>:<password>>@bookscluster.bhtnhl4.mongodb.net/?retryWrites=true&w=majority

