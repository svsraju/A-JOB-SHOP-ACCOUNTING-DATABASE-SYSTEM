# A-JOB-SHOP-ACCOUNTING-DATABASE-SYSTEM
A job-shop accounting system is part of an organization that manufactures special-purpose assemblies for customers

![picture alt](https://image.shutterstock.com/image-illustration/database-icon-on-computer-keyboard-260nw-366917666.jpg)


## Database requirements
A customer has a unique name, an address, and a category (an integer number from 1-10). Acustomer can order several assemblies. Each assembly is identified by a unique assembly-id, and has a date-ordered, and assembly-details. To manufacture assemblies, the organization contains a number of processes, each of which is identified by a unique process-id and is supervised by one department. Each department has its own department number and department-data. Each process also has process-data. Processes are classified into three types: paint, fit, and cut. The following information is kept about each type of process: 
* Fit: fit-type 
* Paint: paint-type, painting-method 
* Cut: cutting-type, machine-type

During manufacture an assembly can pass through any sequence of processes in any order; it may pass through the same process more than once.


A job is assigned every time a process begins on an assembly. Information recorded about a
job includes a unique job-no, a date the job commenced, and a date the job completed as well as additional information that depends on the type of job. Jobs are classified into three job types: cutjob, paint-job, and fit-job. Information stored about particular job types is: 
* Cut-job: type of machine used, amount of time the machine used, material used, and labor time.
* Pain-job: color, volume, and labor time. 
* Fit-job: labor time.



An account is maintained by the organization to keep track of expenditure for each process,
each assembly, and each department. For each account, the database stores its unique account number and the date the account established. Three types of accounts are maintained:
* Assembly-account to record costs (details-1) for assemblies. 
* Department-account to record costs (details-2) for departments. 
* Process-account to record costs (details-3) for processes.


As a job proceeds, cost transactions can be recorded against it. Each such transaction is
identified by a unique transaction number, and is for a given cost (sup-cost). Each transaction of necessity updates three accounts: 
* A process account 
* An assembly account 
* A department account

The updated process account is for the process used by a job. The updated department account is for the department that manages that process. The updated assembly account is for the assembly that requires the job.


### On-line queries and their frequencies for the job-shop accounting system:

1. Enter a new customer (30/day). 
2. Enter a new department (infrequent). 
3. Enter a new assembly with its customer-name, assembly-details, assembly-id, and dateordered (40/day).
4. Enter a new process-id and its department together with its type and information relevant to the type (infrequent).
5. Create a new account and associate it with the process, assembly, or department to which it is applicable (10/day).
6. Enter a new job, given its job-no, assembly-id, process-id, and date the job commenced (50/day).
7. At the completion of a job, enter the date it completed and the information relevant to the type of job (50/day).
8. Enter a transaction-no and its sup-cost and update all the costs (details) of the affected accounts by adding sup-cost to their current values of details (50/day).
9. Retrieve the cost incurred on an assembly-id (200/day). 10. Retrieve the total labor time within a department for jobs completed in the department during a given date (20/day).
11. Retrieve the processes through which a given assembly-id has passed so far (in datecommenced order) and the department responsible for each process (100/day).
12. Retrieve the jobs (together with their type information and assembly-id) completed during a given date in a given department (20/day).
13. Retrieve the customers (in name order) whose category is in a given range (100/day). 14. Delete all cut-jobs whose job-no is in a given range (1/month). 15. Change the color of a given paint job (1/week).

### TASKS PERFORMED
#### Task 1 
Designed an ER diagram and a relational database to represent the Job-Shop Accounting database defined above.ER Diagrams are most often used to design or debug relational databases.they use a defined set of symbols such as rectangles, diamonds, ovals and connecting lines to depict the interconnectedness of entities, relationships and their attributes. They mirror grammatical structure, with entities as nouns and relationships as verbs.This is the final Designed ER diagram

![image](https://user-images.githubusercontent.com/46058709/73490966-3522e200-4373-11ea-9cf0-8bf3798d47fd.png)


#### Relational Schema for tables/relations:

`Customer(name,address,category(1-10))`

`Assembly(assembly_id, date_ordered, assembly_details, name,account_no)`

`Department(department_number, department_data, account_no)`

`Process(process_id, process_data,department_number,account_no)`

`paint_process(process_id,paint_type,painting_method)`

`Fit_process(process_id,fit_type)`

`Cut_process(process_id,cutting_type,machine_type)`

`Job(job_no, commence_date, completion_date, assembly_id, process_id )`

`Paint_job(paint_job_no,color,volume,labor_time)`

`Fit_job(fit_job_no,labor_time)`

`Cut_job(cut_job_no,type_of_machine,time_used,material_used,labor_time)`

`Cost_transactions(transaction_no, job_no,given_cost, asse_account_no,dep_account_no, pro_account_no)`

`Assembly_account(account_no, established_date,assembly_costs)`

`Department_account(account_no, established_date,department_costs)`

`Process_account(account_no, established_date, process_costs)`

`Assigned_job(job_no, commence_date, completion_date, assembly_id, date_ordered, assembly_details, process_id, process_data)`


#### Task 2 
Provided a Data Element Dictionary that lists the names, types, and sizes (in bytes) of all attributes and associated constraints for each table.

You can check the table in the above report


#### Task 3
I have Discussed the choices of appropriate storage structures for each relational table assuming that all types of storage structures discussed in are available. For each table, I have identified the queries (from the list of the given queries) that access the table, the type of each of those queries (insertion, deletion, random search, or range search), the search keys (if any) involved in each of those queries, the frequency of each of those queries, my choice of the file organization for the table, and my justifications.

I have implemented the database in <b> Azure SQL Database <b>


#### Task 4
Constructed SQL statements to create tables and implement them on Azure SQL Database. All Create statements are included with appropriate constraints as defined in Task 2. 
For each table, you must include SQL statements that create the same storage structure as the one i had selected for Azure SQL Database implementation.


#### Task1 





#### Task1 



#### Task1 
