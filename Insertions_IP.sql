INSERT INTO customer 
Values
('Subbu','1003D East Brooks Street Norman',1),
('Ghani','C106,Crimson Park,Norman',3),
('Abhinash','250 spring fields, Norman',10),
('Gowtham','brooks st oklahoma',9),
('Maharshi','227 clasen, Norman',6),


('Krishna','227 spring fields,Norman', 3),
('Harsha','vijaywada india',4),
('RC','Hyderabad telangana India',3),
('sabbi','1006 visakhapatnam India',2),
('abhi','62, gachibowli, Telangana',4),
('KV','karnool TG IN',5),
('Akhila','1003C East Brooks Street, Oklahoma',7)






select * FROM customer;
select * from assembly_account;
select * From assembly;


Insert INTO assembly_account
Values
(100,'2019-09-22',200),
(101,'2019-10-01',400),
(102,'2019-01-15',900),
(103,'2019-02-18',800),
(104,'2019-03-06',100),
(105,'2019-04-30',300),
(106,'2019-06-30',500),
(107,'2019-07-19',230),
(108,'2019-08-03',250),
(109,'2019-06-03',250)



Insert INTO assembly(assembly_id,date_ordered,assembly_details,c_name,account_no)
Values
(1000,'2019-05-12','New assembly 1','Subbu',100),
(1001,'2019-09-22','New assembly 2','Ghani',101),
(1002,'2019-01-15','New assembly 4','Abhinash',102),
(1003,'2019-10-01','New assembly 3','Gowtham',103),
(1004,'2019-02-18','New assembly 5','Maharshi',104),
(1005,'2019-03-06','New assembly 6','Maharshi',105),
(1006,'2019-04-30','New assembly 7','Abhinash',106),
(1007,'2019-06-30','New assembly 8','Gowtham ',107),
(1008,'2019-07-19','New assembly 9','Subbu',108),
(1009,'2019-04-11','New Assembly 10','Subbu',109)

select * from department_account;
select * from Department;

Insert INTO department_account
Values
(200,'2019-06-12',120),
(201,'2019-11-02',300),
(202,'2019-04-13',400),
(203,'2019-03-13',500),
(204,'2019-05-21',400)

/*(205,'2019-04-04',600),
(206,'2019-05-21',400),
(207,'2019-05-12',600),
(208,'2019-07-11',730),
(209,'2019-06-17',150)*/

Insert INTO Department(department_number,department_data,account_no)
Values
(2000,'This is a new department',200),
(2001,'Department 2',201),
(2002,'Department related to others',202),
(2003,'Department',203),
(2004,'New Department',204),




(2005,'New Department',204),
(2006,'New Department',203),
(2007,'New Department',206),
(2008,'New Department',209)



select * from process_account;
select * from process;

Insert INTO process_account
Values
(301,'2019-04-12',120),
(302,'2019-03-02',600),
(303,'2019-09-13',700),
(304,'2019-07-13',530),
(305,'2019-08-04',660),
(306,'2019-05-21',470),
(307,'2019-07-12',625),
(308,'2019-04-11',755),
(309,'2019-06-17',160),
(310,'2019-11-13',512)

Insert INTO Process(process_id,department_number,process_data,account_no)
Values
(3001,2000,'New Process 1',301),
(3002,2000,'New Process 2',302),
(3003,2002,'New Process 3',303),
(3004,2000,'New Process 4',304),
(3005,2004,'New Process 5',305),
(3006,2002,'New Process 6',306),
(3007,2000,'New Process 7',307),
(3008,2004,'New Process 8',308),
(3009,2003,'New Process 9',309),
(3010,2003,'New Process 10',310)

select * from Process; 
select * from paint_process;
select * from fit_process;
select * from cut_process;

Insert INTO paint_process
Values
(3001,'Gloss Paint','Underpainting'),
(3002,'Satin Finish','Blocking in'),
(3007,'Flat Paints','Dry brushing')

Insert INTO fit_process
Values
(3003,'fitting1'),
(3008,'fit over the top'),
(3005,'Fitting flat')

Insert INTO cut_process
Values
(3004,'Sawing','Underpainting'),
(3006,'Broaching','Blocking in'),
(3009,'Drillings','Dry brushing'),
(3010,'Drill','Dry ')




select * from assembly;
select * from process;

select * from job;
select * from paint_job;
select * from fit_job;
select * from cut_job;
INSERT INTO job 
Values
(5001,'2019-05-11','2019-05-17',1000,3001),
(5002,'2019-05-11','2019-05-17',1000,3004),
(5003,'2019-05-10','2019-05-17',1000,3007),
(5004,'2019-05-10','2019-05-17',1002,3002),
(5005,'2019-05-14','2019-05-16',1002,3003),
(5006,'2019-05-13','2019-05-16',1002,3006),
(5007,'2019-05-09','2019-05-11',1003,3009),
(5008,'2019-05-03','2019-05-11',1003,3010),
(5009,'2019-05-04','2019-05-16',1001,3005),
(5010,'2019-05-11','2019-05-15',1001,3008)

Insert INTO paint_job
Values
(5001,'blue',3,12.5),
(5002,'green',3,12),
(5003,'red',3,12)

Insert INTO fit_job
Values
(5004,12.5),
(5005,13),
(5006,12),
(5007,15)

Insert INTO cut_job
Values
(5008,'Sawing',12,'Steel',10),
(5009,'Broaching',12,'cast iron',12),
(5010,'Drilling',12,'metal ',12)


select * from cost_transactions;
--select * from paint_job;
select * from job;

select * from customer;

Select * from assembly;
select * from department;

select * from cost_transactions;
select * from department_account;
select * from process_account;
select * from assembly_account;

select * from process_account;

INSERT INTO cost_transactions
VALUES
(9001,5001,50,100,200,301),
(9002,5002,60,100,200,304),
(9003,5003,70,100,200,307),
(9004,5004,120,102,200,302),
(9005,5005,50,102,202,303),
(9006,5006,30,102,202,306),
(9007,5007,50,103,203,309),
(9008,5008,40,103,203,310),
(9009,5009,60,101,204,305),
(9010,5010,100,101,204,308)
