
/* SQL query for option 1 */
--Enter a new customer

 
 select * from customer;

 -- Delete rows from table '[customer]' in schema '[dbo]'
 DELETE FROM customer WHERE name = 'Abstoer_check'/* add search conditions here */
 GO

/* SQL query for option 2 */
--Enter a new department
select * FROM department;




INSERT INTO department
VALUES
(2010,'this department',208)

/* SQL query for option 3 */
--Enter a new assembly with its customer-name, assembly-details, assembly-id, and dateordered 

select * from assembly;




INSERT INTO assembly
VALUES
(1010,'2019-05-11','belons to shasi','Shasi',NULL)

/* SQL query for option 4 */
--Enter a new process-id and its department together with its type and information relevant to the type 
select * FROM process;
Select * from paint_process;
select * from fit_process;
select * from cut_process;


/* SQL query for option 5 */
--Create a new account and associate it with the process, assembly, or department to which it is applicable 
select * from assembly_account;
select * from department_account;
select * from process_account;

-- Delete rows from table '[department_account]' in schema '[dbo]'
DELETE FROM [dbo].[process_account]
WHERE account_no BETWEEN 301 AND 303 /* add search conditions here */
GO

/* SQL query for option 6 */
--Enter a new job, given its job-no, assembly-id, process-id, and date the job commenced

select * from job;

DELETE FROM [dbo].[job]
WHERE job_no BETWEEN 5001 AND 5003 /* add search conditions here */
GO

/* SQL query for option 7 */
--At the completion of a job, enter the date it completed and the information relevant to the type of job 

select * from job;
select * from paint_job;
select * from fit_job;
select * from cut_job;



DELETE FROM [dbo].[paint_job]
WHERE paint_job_no BETWEEN 5001 AND 5003 /* add search conditions here */
GO

/* SQL query for option 8 */
--Enter a transaction-no and its sup-cost and update all the costs (details) of the affected accounts by adding sup-cost to their current values of details 


select * from cost_transactions;



INSERT INTO cost_transactions(transaction_no,job_no,sup_cost) values(9001,5001,60);

UPDATE cost_transactions  SET asse_account_no  = (SELECT DISTINCT assembly.account_no FROM cost_transactions,job,assembly WHERE job.job_no = 5005 AND
                                                   job.assembly_id = assembly.assembly_id ) WHERE job_no = 5005;




UPDATE cost_transactions SET pro_account_no  = (SELECT DISTINCT process.account_no FROM cost_transactions,job,process WHERE job.job_no = 5005 AND
 job.process_id = process.process_id) WHERE job_no = 5005;
    
                                                                                                                                                

UPDATE cost_transactions SET dep_account_no  = (SELECT DISTINCT department.account_no FROM cost_transactions,job,process,department WHERE 
                                                job.job_no = 5005 AND
                                                   job.process_id = process.process_id AND process.department_number = department.department_number) 
                                                   WHERE job_no = 5005;  



UPDATE assembly_account SET assembly_costs = assembly_costs + (select sup_cost FROM cost_transactions,assembly_account WHERE 
                                                    cost_transactions.asse_account_no = assembly_account.account_no 
                                                    AND job_no = 5000) where account_no = (select asse_account_no FROM cost_transactions WHERE job_no = 5000) ;


UPDATE process_account SET process_costs = process_costs +  (select sup_cost FROM cost_transactions,process_account WHERE 
                                                    cost_transactions.pro_account_no = process_account.account_no 
                                                    AND job_no = 5000) where account_no = (select pro_account_no FROM cost_transactions WHERE job_no = 5000) ;                                                  


UPDATE department_account SET department_costs = department_costs +  (select sup_cost FROM cost_transactions,department_account WHERE 
                                                    cost_transactions.dep_account_no = department_account.account_no 
                                                    AND job_no = 5000) where account_no = (select dep_account_no FROM cost_transactions WHERE job_no = 5000) ; 

select sup_cost FROM cost_transactions,assembly_account WHERE cost_transactions.asse_account_no = assembly_account.account_no AND job_no = 5000;
                                                                
/* SQL query for option 9 */
--Retrieve the cost incurred on an assembly-id 

select * from assembly;
select * from assembly_account;

SELECT assembly_costs 
FROM assembly_account
WHERE account_no IN (SELECT account_no FROM assembly WHERE assembly_id = '1000');



/* SQL query for option 10 */
--Retrieve the total labor time within a department for jobs completed in the department during a given date





DROP PROCEDURE query10


EXEC query10  @department_number = 2000 , @completion_date = '2019-05-17'

SELECT * FROM job ,cut_job WHERE job.job_no=cut_job.cut_job_no AND process_id in (SELECT process_id from process WHERE department_number=2000) AND job.completion_date='2019-05-17';

SELECT * FROM job ,fit_job WHERE job.job_no=fit_job.fit_job_no AND process_id in (SELECT process_id from process WHERE department_number=2000) AND job.completion_date='2019-05-17';

SELECT * FROM job ,paint_job WHERE job.job_no=paint_job.paint_job_no AND process_id in (SELECT process_id from process WHERE department_number=2000) AND job.completion_date='2019-05-17';


/* SQL query for option 11 */
--Retrieve the processes through which a given assembly-id has passed so far (in datecommenced order) and the department responsible for each process

select * from process;
select * from job;
select * from department;


select process.process_id,process.department_number
FROM process,department,job
WHERE job.assembly_id = 1000 and department.department_number = process.department_number and job.process_id = process.process_id ORDER BY job.commence_date;

/* SQL query for option 12 */
--Retrieve the jobs (together with their type information and assembly-id) completed during a given date in a given department (20/day)


/*select *
FROM job,department
--(select * from process) as p1
WHERE job.completion_date = '2019-05-17' AND department.department_number = 2001

Select * from cut_job where job_no IN(select job_no
FROM job,department
--(select * from process) as p1
WHERE job.completion_date = '2019-05-17' AND department.department_number = 2001) 

Select * from fit_job where job_no IN(select job_no
FROM job,department
--(select * from process) as p1
WHERE job.completion_date = '2019-05-18' AND department.department_number = 2001)

Select * from paint_job where job_no IN(select job_no
FROM job,department
--(select * from process) as p1
WHERE job.completion_date = '2019-05-17' AND department.department_number = 2001)

*/

SELECT job.job_no, job.commence_date, completion_date, cut_job.type_of_machine, cut_job.time_used, cut_job.material_used, labor_time, assembly_id
    FROM job, process, cut_job 
    WHERE job.completion_date='2019-05-17'AND job.process_id=process.process_id AND job.job_no=cut_job.cut_job_no AND department_number=2000;

SELECT job.job_no, job.commence_date, completion_date, labor_time, assembly_id
    FROM job, process, fit_job 
    WHERE job.completion_date='2019-05-17'AND job.process_id=process.process_id AND job.job_no=fit_job.fit_job_no AND department_number=2000;

SELECT job.job_no, job.commence_date, completion_date, paint_job.color, paint_job.volume,paint_job.labor_time, assembly_id
    FROM job, process, paint_job 
    WHERE job.completion_date='2019-05-17'AND job.process_id=process.process_id AND job.job_no=paint_job.paint_job_no AND department_number=2000;




/* SQL query for option 13 */
--retrieve the customers (in name order) whose category is in a given range



Select * FROM customer



where category between 1 and 3;




/* SQL query for option 14 */
--Delete all cut-jobs whose job-no is in a given range 


DELETE FROM cut_job WHERE job_no BETWEEN 5006 and 5008;



select * from cut_job;

/* SQL query for option 15 */
--Change the color of a given paint job 


select * from Paint_job;


