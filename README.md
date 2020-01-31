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

I have implemented the database in <b> Azure SQL Database </b>


#### Task 4

Constructed SQL statements to create tables and implement them on Azure SQL Database. All Create statements are included with appropriate constraints as defined in Task 2. 
For each table, I have included SQL statements that create the same storage structure as the one I had selected for Azure SQL Database implementation.

You can see the <i>create_Table.sql</i> which has the sql statements for creation of tables and <i>Insertions_IP.sql</i> has the insertion statements for inserting the information in to the tables.


#### Task 5 

I have Written SQL statements for all queries (1-15) above. 

I have also Developed a Java application program that uses JDBC and Azure SQL Database to implement all SQL queries (options 1-15), two additional queries for import and export (options 16-17), and the “Quit” option (option 18) were added to make the things easy for the user. 

The program will stop execution only when the user chooses the “Quit” option; otherwise all options will be available for the user to choose at all times.

Available options to the user:

```
=========================================
1. Enter a new customer
2. Enter a new department 
3. Enter a new assembly with its customer-name, assembly-details, assembly-id, and dateordered
4. Enter a new process-id and its department together with its type and information relevant to the type
5. Create a new account and associate it with the process, assembly, or department to which it is applicable 
6. Enter a new job, given its job-no, assembly-id, process-id, and date the job commenced
7. At the completion of a job, enter the date it completed and the information relevant to the type of job 
8. Enter a transaction-no and its sup-cost and update all the costs (details) of the affected accounts by adding sup-cost to their current values of details
9. Retrieve the cost incurred on an assembly-id
10. Retrieve the total labor time within a department for jobs completed in the department during a given date 
11. Retrieve the processes through which a given assembly-id has passed so far (in datecommenced order) and the department responsible for each process 
12. Retrieve the jobs (together with their type information and assembly-id) completed during a given date in a given department  
13. Retrieve the customers (in name order) whose category is in a given range 
14. Delete all cut-jobs whose job-no is in a given range  
15. Change the color of a given paint job 
16. Import: enter new customers from a data file until the file is empty
17. Export: Retrieve the customers (in name order) whose category is in a given range and output them to a data file instead of screen 
18. QUIT
=========================================
```

I have written the java program in eclipse work space. You can see the code in the <i>Java_program for Accounting Database.java</i>

Data manipulation and error checking is done by Azure SQL Database.My program is only to create the menu, accept choices, form queries, submit them to Azure SQL Database for execution, and display results or error messages.

I have run the program created for to test its correctness. To populate the database, I perform 5 queries for each type (1, 2) and 10 queries for each type (3, 4, 5, 6, 7, 8) and showed the contents of the affected tables after the 5 queries of each type (1, 2) are completed and after the 10 queries for each type (3, 4, 5, 6, 7, 8) are completed. To show database access is possible, I performed 3 queries for each type (9, 10, 11, 12, 13, 14, 15). 

To show the import and export facilities are available, run each option (16-17) once. To show the Quit option is available, run option (18) at least once. To demonstrate that Azure SQL Database can detect errors, I also need to performed 3 queries of different types that contain some errors.

All the screenshots can be found in the Project report pdf file.



#### Task 6 

I have written a Web database application using Azure SQL Database and JSP which provides the Web pages for query 1 and query 13. Since both queries take the input data from the user, there are two Web pages for each query as follows: 

For query 1, one Web page to allow the user to enter the input data and one to display a message confirming the successful execution of the insertion; 

For query 13, there is one Web page to allow the user to enter the input data and one to display the retrieval results with appropriate headings. To show that our Web application works correctly, I ran the Web application so that queries 1 and 13 were  executed in this order: first query 13, then query 1, and then query 13 again, making sure that the results of query 1 will change the results of query 13 that follow query 1.


This is a project to show how a complete database is designed and can be used by users.
