//Importing the necessary Packages
import java.util.Scanner;
import java.sql.Connection; 
import java.sql.Statement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.DriverManager;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class individual_project{
	public static void main(String[] args) throws SQLException, IOException { 
		// Connect to database 
		final String hostName = "hostname"; 
		final String dbName = "databasename"; 
		final String user = "username"; 
		final String password = "password"; 
		final String url =
String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host "
+ "NameInCertificate=*.database.windows.net;loginTimeout=30;",
		hostName, dbName, user, password);
	
		try (final Connection connection = DriverManager.getConnection(url)) {
			final String schema = connection.getSchema();
			Statement statement = connection.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Successful connection to Job-Shop Accounting DataBase:" + schema); 
			System.out.println("WELCOME TO Job-Shop Accounting DataBase");
			 
			
			
			// initializing Scanner object
			Scanner myScan = new Scanner(System.in);
			int Choice = 0;
			while(Choice != 18) 
			{
			
			// printing out the available choices for the User to choose.
			// It is assumed that user will have prior knowledge of the problem	
			System.out.println("====================================You have the Following Options to Choose:====================================");
			System.out.println("1. Enter a new customer"); 
			System.out.println("2. Enter a new department "); 
			System.out.println("3. Enter a new assembly with its customer-name, assembly-details, assembly-id, and dateordered");
			System.out.println("4. Enter a new process-id and its department together with its type and information relevant to the type"); 
			System.out.println("5. Create a new account and associate it with the process, assembly, or department to which it is applicable "); 
			System.out.println("6. Enter a new job, given its job-no, assembly-id, process-id, and date the job commenced");
			System.out.println("7. At the completion of a job, enter the date it completed and the information relevant to the type of job "); 
			System.out.println("8. Enter a transaction-no and its sup-cost and update all the costs (details) of the affected accounts by adding sup-cost to their current values of details"); 
			System.out.println("9. Retrieve the cost incurred on an assembly-id");
			System.out.println("10. Retrieve the total labor time within a department for jobs completed in the department during a given date ");
			System.out.println("11. Retrieve the processes through which a given assembly-id has passed so far (in datecommenced order) and the department responsible for each process "); 
			System.out.println("12. Retrieve the jobs (together with their type information and assembly-id) completed during a given date in a given department  "); 
			System.out.println("13. Retrieve the customers (in name order) whose category is in a given range ");
			System.out.println("14. Delete all cut-jobs whose job-no is in a given range  "); 
			System.out.println("15. Change the color of a given paint job "); 
			System.out.println("16. Import: enter new customers from a data file until the file is empty"); 
			System.out.println("17. Export: Retrieve the customers (in name order) whose category is in a given range and output them to a data file instead of screen "); 
			System.out.println("18. QUIT"); 
			System.out.println("=========================================");
			
			//reading the input given by the user 
			Choice = myScan.nextInt();
			
			//Depending on the choice made by the user, we are defining the operations to be done
			
			if (Choice == 1) {
				//Enter a new customer in to the Data Base
				
				//asking user to enter the customer name and reading the value
				System.out.println("Enter the customer Name ");
				String name = br.readLine();
				
				
				//reading the customer's address from the user
				System.out.println("Enter the customer's address ");
				String address = br.readLine();
				
				
			    
				//reading the customer's category value given by user
				System.out.println("Enter the customer's category- values from 1 to 10"); 
				int category = Integer.parseInt(br.readLine());
				
				//Executing the query 1
	
				final String query1 = "INSERT INTO customer values('" + name + "','" + address + "','" + category + "')";
				
						statement.executeUpdate(query1);
					
						System.out.println("New Customer record inserted successfully.");
						System.out.println("=========================================");
				
			}
			
			if (Choice == 2) {
				
				// Enter a new department
					
				//asking user to enter the department number and reading the value
				System.out.println("Enter the Unique department number ");
				int department_number = Integer.parseInt(br.readLine());
					
					
				//reading the department data as given by the user
				System.out.println("Enter the department data");
				String data = br.readLine();
					
				//Executing the query 2
		
				final String query2 = "INSERT INTO Department(department_number,department_data) values('" + department_number + "','" + data + "')";
					
				statement.executeUpdate(query2);
				
				//showing successful running of query
				System.out.println("New Deparment inserted successfully.");
				System.out.println("=========================================");
			}
		
			if (Choice == 3) {
				//Enter a new assembly with its customer-name, assembly-details, assembly-id, and dateordered


				//asking user to enter the assembly and reading the value
				System.out.println("Enter the Unique Assembly ID ");
				int assembly_id = Integer.parseInt(br.readLine());
					
				//reading the ordered date from the user
				System.out.println("Enter the ordered date - in the form of YYYY-MM-DD:");
				String date = br.readLine();
				
				//reading the assembly details from the user
				System.out.println("Enter the assembly details");
				String data = br.readLine();
				
				//reading the customer name from the user
				System.out.println("Enter the Customer's name who ordered the assembly");
				String cname = br.readLine();
									
				//Executing the query 3
		
				final String query3 = "INSERT INTO Assembly(assembly_id,date_ordered,assembly_details,c_name) values('" + assembly_id + "','" + date + "','" + data + "','" +                                 cname + "')";
					
				statement.executeUpdate(query3);
					
				System.out.println("New Assembly record inserted successfully.");
				System.out.println("=========================================");
			}
				
				 
			if (Choice == 4) {
				
				//Enter a new process-id and its department together with its type and information relevant to the type
				

					//asking user to enter the process ID and reading the value
					System.out.println("Enter the Process ID ");
					int process_id = Integer.parseInt(br.readLine());
					
					//reading the ordered date from the user
					System.out.println("Enter the Department Number that supervises this process");
					int department_number = Integer.parseInt(br.readLine());
					
					//reading the customer name from the user
					System.out.println("Enter Process Data");						
					String process_data = br.readLine();
					
					//reading the customer name from the user
					System.out.println("Enter the Type of Process - paint, fit or cut ");						
					String type = br.readLine();
					
					//if the type entered by the user is paint then asking for paint process information
					if(type.equals("paint")) {
							
						//reading the paint type
						System.out.println("Enter the paint type ");
						
						String paint_type = br.readLine();
						
						//reading the paint Method
						System.out.println("Enter the painting Method");
						
						String p_method = br.readLine();
						
						//Executing the query 4
						
						final String query4 = "INSERT INTO Process(process_id,department_number,process_data) values('" + process_id + "','" + department_number +                                                 "','" + process_data + "')";							
							
						statement.executeUpdate(query4); 
							
						//inserting values into Paint_process table	
						final String query4_1 = "INSERT INTO paint_process values('" + process_id + "','" + paint_type + "','" + p_method + "')";
							
						statement.executeUpdate(query4_1);
							
						System.out.println(" New Process record and paint_process record are inserted successfully.");
						System.out.println(" ====================================");
							
					}
					//if the type entered by the user is fit then asking for fit process information
					else if(type.equals("fit")) {
						
						//reading the fit type
						System.out.println("Enter the fit type ");
							
						String fit_type = br.readLine();
							
						
						//Executing the query 4
						
						//inserting values into Process table
						final String query4 = "INSERT INTO Process(process_id,department_number,process_data) values('" + process_id + "','" + department_number +                                                 "','" + process_data + "')";							
						
						statement.executeUpdate(query4); 
							
						//inserting values into fit_process table	
						final String query4_1 = "INSERT INTO fit_process values('" + process_id + "','" + fit_type + "')";
							
						statement.executeUpdate(query4_1);
							
						System.out.println(" New Process record and  fit_process record are inserted successfully.");
						System.out.println(" ====================================");
					}	
					
					////if the type entered by the user is cut then asking for cut process information
					else if(type.equals("cut")) {
						
						//reading cutting type 
						System.out.println("Enter the cutting type ");
							
						String cut_type = br.readLine();
						
						//reading machine type from user
						System.out.println("Enter the Machine type");
							
						String m_type = br.readLine();
							
						//Executing the query 4
						//inserting values into Process table
						
						final String query4 = "INSERT INTO Process(process_id,department_number,process_data) values('" + process_id + "','" + department_number +                                                 "','" + process_data + "')";							
						
						statement.executeUpdate(query4); 
							
						//inserting values into paint_process table	
						final String query4_1 = "INSERT INTO cut__process values('" + process_id + "','" + cut_type + "','" + m_type + "')";
							
						statement.executeUpdate(query4_1);
							
						System.out.println(" New Process record and cut_process record are inserted successfully.");
						System.out.println(" ====================================");
							
					}
					//if the type entered by the user is not valid then asking  user about the type again!!
					else {
						System.out.println("please enter correct type - Is it paint or fit or cut ??");
					}
					 
			}
			
			if (Choice == 5) {
				//Create a new account and associate it with the process, assembly, or department to which it is applicable
				//Executing the query5
				//Asking for account type  so that we could insert them into the respective account Table
				System.out.println("Enter Type Of Account (Department or  Assembly or Process ):");
				String account_type = br.readLine();
				
				//Depending on the type of account, asking user for details of the account
				
				//considering when Type of account is Department
				if(account_type.equals("Department")) {
					
					
					//asking user to enter the department number and reading the value
					System.out.println("Enter the department number you will be tracking with this account ");
					String department_no = br.readLine();
					
					//asking user to enter the account number and reading the value
					System.out.println("Enter the account number ");
					String account_no = br.readLine();
					
					//reading the established_date from the user
					System.out.println("Enter the established_date - in the form of YYYY-MM-DD:");
					String date = br.readLine();
					
					//reading the department_costs value given by user
					System.out.println("Enter the department costs"); 
					int costs = Integer.parseInt(br.readLine());
					
					//Executing the query 5
					
					//Inserting into department account
					final String query5 = "INSERT INTO department_account values('" + account_no + "','" + date + "','" + costs + "')";
					
					statement.executeUpdate(query5);
					
					// Updating the department account as per the department number number given
					final String query5_1= "UPDATE department SET account_no = '" + account_no + "' WHERE  department_number = '" + department_no + "'";
					
					statement.executeUpdate(query5_1);
						
					System.out.println("Deparment Account record inserted successfully.");
					System.out.println("=========================================");
					}
				//considering when Type of account is Assembly
				else if(account_type.equals("Assembly")) {
					
					//asking user to enter the assembly id and reading the value
					System.out.println("Enter the Assembly ID you will be tracking with this account ");
					String assembly_id = br.readLine();
					

					//asking user to enter the account and reading the value
					System.out.println("Enter the account number ");
					String account_no = br.readLine();
					
					
					//reading the established_date from the user
					System.out.println("Enter the established_date - in the form of YYYY-MM-DD:");
					String date = br.readLine();
					
					
				    
					//reading the assembly costs value given by user
					System.out.println("Enter the Assembly costs"); 
					int costs = Integer.parseInt(br.readLine());
					
					//Executing the query 5
					//Inserting the values assembly account
		
					final String query5 = "INSERT INTO assembly_account values('" + account_no + "','" + date + "','" + costs + "')";
					
					statement.executeUpdate(query5);
					
					final String query5_1= "UPDATE assembly SET account_no = '" + account_no + "' WHERE  assembly_id = '" + assembly_id + "'";
					
					statement.executeUpdate(query5_1);
						
					System.out.println("Assembly Account record inserted successfully.");
					System.out.println("=========================================");
					}
				
				//considering when Type of account is Process
				else if(account_type.equals("Process")) {
					
					//asking the process ID from User and reading the value
					System.out.println("Enter the process ID you will be tracking with this account ");
					String process_id = br.readLine();
					

					//asking user to enter the account and reading the value
					System.out.println("Enter the account number ");
					String account_no = br.readLine();
					
					
					//reading the established_date from the user
					System.out.println("Enter the established_date - in the form of YYYY-MM-DD:");
					String date = br.readLine();
					
					
				    
					//reading the process costs value given by user
					System.out.println("Enter the Process costs"); 
					int costs = Integer.parseInt(br.readLine());
					
					//Executing the query 5
		
					final String query5 = "INSERT INTO process_account values('" + account_no + "','" + date + "','" + costs + "')";
					
					statement.executeUpdate(query5);
					
					final String query5_1= "UPDATE process SET account_no = '" + account_no + "' WHERE  process_id = '" + process_id + "'";
					
					statement.executeUpdate(query5_1);
						
					System.out.println("Process Account record inserted successfully.");
					System.out.println("=========================================");
					}
				else {
					System.out.println("please enter- Department or Assembly or Process ");
					
				}
				
			
			}
			if(Choice == 6) {
				//Enter a new job, given its job-no, assembly-id, process-id, and date the job commenced
				
				//asking user to enter the job number and reading the value
				System.out.println("Enter the Job Number");
				int job_number = Integer.parseInt(br.readLine());
				
				//Reading the commencement date
				System.out.println("Enter the Job Commencement date - in the form of YYYY-MM-DD:");
				String date = br.readLine();
				
				//reading the assembly ID value given by user
				System.out.println("Enter the Assembly ID"); 
				int assembly_id = Integer.parseInt(br.readLine());
				
				
				//reading the process ID value given by user
				System.out.println("Enter the process ID"); 
				int process_id = Integer.parseInt(br.readLine());
				
				//Executing the query 6
				
				//Inserting the values into Job table
				final String query6 = "INSERT INTO job(job_no,commence_date,assembly_id,process_id) values('" + job_number + "','" + date + "','" + assembly_id + "','" +                                 process_id + "')";
				
				statement.executeUpdate(query6);
					
				System.out.println("New Job record inserted successfully.");
				System.out.println("=========================================");
				
			}
			if(Choice == 7) {
				//At the completion of a job, enter the date it completed and the information relevant to the type of job 
				
				//asking the user for the job number and reading it
				System.out.println("Enter the Job number which got completed");
				int job_no = Integer.parseInt(br.readLine());
				
				//Reading the completion date
				System.out.println("Enter the Job Completion date - in the form of YYYY-MM-DD:");
				String completion_date = br.readLine();
				
				
				//asking user for the type of job
				System.out.println("Enter the type of Job - paint or fit or cut");
				String type = br.readLine();
				
				//considering when type is paint
				if(type.equals("paint")) {
					
					//reading the paint color
					System.out.println("Enter the color ");
					String color = br.readLine();
					
					//reading the paint volume
					System.out.println("Enter the volume"); 
					float volume = Float.valueOf(br.readLine()).floatValue();
					
					//reading the labor time from the user for this job
					System.out.println("Enter the labor time"); 
					float labor_time = Float.valueOf(br.readLine()).floatValue();
					
					//Executing the query 7
					
					//updating the job table as per the completion date given
					final String query7 = "UPDATE job SET completion_date = '" + completion_date + "' WHERE  job_no = '" + job_no + "'";
					
					statement.executeUpdate(query7);
					
					//inserting the values of Paint Job 
					final String query7_1 = "INSERT INTO paint_job values('" + job_no + "','" + color + "','" + volume + "','" + labor_time + "')";
					
					statement.executeUpdate(query7_1);
					
					System.out.println(" Completion date has been updated and paint job record is inserted");
					System.out.println(" ====================================");
					
				}
				
				//considering when job type is fit
				else if(type.equals("fit")) {
					
					//asking user for the labor time and reading it
					System.out.println("Enter the labor time"); 
					float labor_time = Float.valueOf(br.readLine()).floatValue();
					
					//Executing the query 7
					
					//updating the job table as per the completion date given
					final String query7 = "UPDATE job SET completion_date = '" + completion_date + "' WHERE  job_no = '" + job_no + "'";
					
					statement.executeUpdate(query7);
					
					//inserting the values of fit Job 
					final String query7_1 = "INSERT INTO fit_job values('" + job_no + "','" + labor_time + "')";
					
					statement.executeUpdate(query7_1);
					
					System.out.println(" Completion date has been updated and paint job record is inserted");
					System.out.println(" ====================================");
				}	
				else if(type.equals("cut")) {
					
					//reading the machine  Type
					System.out.println("Enter the type of Machine used ");
					String machine_type = br.readLine();
					
					//reading the time the machine used
					System.out.println("Enter the amount of time machine was used(in hours)"); 
					float time = Float.valueOf(br.readLine()).floatValue();
					
					//asking user abou the material used
					System.out.println("Enter the Material Used ");
					String material = br.readLine();
					
					//asking user for the labor time and reading it
					System.out.println("Enter the labor time"); 
					float labor_time = Float.valueOf(br.readLine()).floatValue();
					
					//Executing the query 7
					//updating the job table as per the completion date given
					final String query7 = "UPDATE job SET completion_date = '" + completion_date + "' WHERE  job_no = '" + job_no + "'";
					
					statement.executeUpdate(query7);
					
					//inserting the values of cut Job 
					final String query7_1 = "INSERT INTO cut_job values('" + job_no + "','" + machine_type + "','" + time + "','" + material + "','" + labor_time + "')";
					
					statement.executeUpdate(query7_1);
					
					System.out.println(" Completion date has been updated and paint job record is inserted");
					System.out.println(" ====================================");
					
				}
				else {
					System.out.println("please enter correct type - Is it paint or fit or cut ??");
				}
			
				
			}
			
			
			if(Choice == 8) {
				
				// Enter a transaction-no and its sup-cost and update all the costs (details) of the affected accounts by adding sup-cost to their current values of details
				
				//asking user to enter the transaction number and reading it
				System.out.println("Enter the transaction Number");
				int trans_no= Integer.parseInt(br.readLine());
				
				//reading JOb Number on which this transaction is recoded
				System.out.println("Enter the job Number on which this transaction is recoded");
				int job_no= Integer.parseInt(br.readLine());
				
				//reading the sup-cost from the user
				System.out.println("Enter the sup-cost");
				float sup_cost = Float.valueOf(br.readLine()).floatValue();
				
				//Executing the query 8
	
				// inserting the values into the cost transactions table
				final String query8 = "INSERT INTO cost_transactions(transaction_no,job_no,sup_cost) values('" + trans_no + "','"+ job_no + "','" + sup_cost + "')";
				
				statement.executeUpdate(query8);
				
				//updating cost_transcaions with the specific assembly account as per the given job number
				final String query8_1 = "UPDATE cost_transactions  SET asse_account_no  = (SELECT DISTINCT assembly.account_no FROM cost_transactions,job,assembly "
						+ "WHERE job.job_no = '"+ job_no + "' AND job.assembly_id = assembly.assembly_id ) "
								+ "WHERE job_no = '"+ job_no + "'";
				
				
				statement.executeUpdate(query8_1);
				
				//updating cost_transcaions with the specific process account as per the given job number
				final String query8_2 ="UPDATE cost_transactions  SET pro_account_no  = (SELECT DISTINCT process.account_no FROM cost_transactions,job,process "
						+ "WHERE job.job_no = '"+ job_no + "' AND job.process_id = process.process_id ) "
						+ "WHERE job_no = '"+ job_no + "'";
				
				statement.executeUpdate(query8_2);
				
				//updating cost_transcaions with the specific department account as per the given job number
				final String query8_3 = "UPDATE cost_transactions SET dep_account_no  = (SELECT DISTINCT department.account_no FROM cost_transactions,job,process,department "
						+ "WHERE job.job_no = '"+ job_no + "' AND job.process_id = process.process_id AND process.department_number = department.department_number)"
						+ "WHERE job_no = '"+ job_no + "'";
						
				statement.executeUpdate(query8_3);
				
				// Updating the assembly account by adding the sup -costs to already available assembly_costs
				final String query8_4 ="UPDATE assembly_account SET assembly_costs = assembly_costs + (select sup_cost FROM cost_transactions,assembly_account WHERE \r\n" + 
						"                                                    cost_transactions.asse_account_no = assembly_account.account_no \r\n" + 
						"                                                    AND job_no = '"+ job_no + "') "
								+ "WHERE account_no = (select asse_account_no FROM cost_transactions WHERE job_no = '"+ job_no + "')";
				
				statement.executeUpdate(query8_4);
				
				// Updating the process account by adding the sup -costs to already available process_costs
				final String query8_5 = "UPDATE process_account SET process_costs = process_costs +  (select sup_cost FROM cost_transactions,process_account WHERE \r\n" + 
				"                                                    cost_transactions.pro_account_no = process_account.account_no \r\n" + 
				"                                                    AND job_no = '"+ job_no + "') where account_no = (select pro_account_no FROM cost_transactions WHERE                                                                                                                                       job_no = '"+ job_no + "')";
				
				
				statement.executeUpdate(query8_5);
				
				// Updating the department account by adding the sup -costs to already available department_costs
				final String query8_6 = "UPDATE department_account SET department_costs = department_costs +  (select sup_cost FROM cost_transactions,department_account                                                                   WHERE \r\n" + 
						"                 cost_transactions.dep_account_no = department_account.account_no \r\n" + 
						"                  AND job_no = '"+ job_no + "') where account_no = (select dep_account_no FROM cost_transactions WHERE job_no = '"+ job_no +                                    "')";
				
				statement.executeUpdate(query8_6);
				
				System.out.println("Transaction number is Inserted and All the affected Accounts costs are upated");		
				System.out.println("=========================================");
					
			
			}
			
			if (Choice == 9) {
				//Retrieve the cost incurred on an assembly-id
				
				//asking user to enter the assembly ID and reading the value
				System.out.println("Enter the assembly ID on which you want to retrive the costs ");
				
				int assembly_id = Integer.parseInt(br.readLine());
				
				
				//Executing the query 9
	
				//Retrieving the assembly_costs
				final String query9 = "SELECT assembly_costs FROM assembly_account WHERE account_no IN (SELECT account_no FROM assembly WHERE assembly_id = '" + assembly_id + "')";
				
				ResultSet rs = statement.executeQuery(query9);
				
				//since it is a result set, printing all the values
				while (rs.next()) { 
					System.out.println(rs.getString(1)); }
					
				System.out.println("Costs Incurred on the given Assembly ID are retrieved");		
				System.out.println("=========================================");
				
			}
			
			if(Choice == 10) {
				
				//asking department number from user and reading it
				System.out.println("Enter the Department Number");
				int department_no= Integer.parseInt(br.readLine());
				//Asking user to enter the completion date	
				System.out.println("Enter the completion Date - in the form of YYYY-MM-DD:");
				String date = br.readLine();
				final String query10 ="EXEC query10 @department_number = '"+department_no+"' , @completion_date = '"+date+"';";
				ResultSet rs = statement.executeQuery(query10);
				System.out.println("Total Labor Hours");
				
				//since it is a result set, printing all the values
				while (rs.next()) { 
					System.out.println(rs.getInt(1)); }
				
			}
			
			if(Choice == 11) {
				
			//Retrieve the processes through which a given assembly-id has passed so far (in datecommenced order) and the department responsible for each process	
			
			//Asking user to enter the assembly ID	
			System.out.println("Enter the Assembly ID");
			int assembly_id= Integer.parseInt(br.readLine());
			
			final String query11 = "SELECT process.process_id,process.department_number FROM process, department,job "
					+ "WHERE job.assembly_id = '" + assembly_id +  "' and department.department_number = process.department_number "
							+ "and job.process_id = process.process_id ORDER BY job.commence_date";
			
			
			//since it is a result set, printing all the values
			ResultSet rs = statement.executeQuery(query11);
			
			System.out.println("Process ID | Department No");
			
			while (rs.next()) { 
				System.out.println(String.format("%s       |  %s ",
						rs.getInt(1), 
						rs.getInt(2))); 
				}
			
			System.out.println("=========================================");
				
				
				
			}
			
			if(Choice == 12) {
				
				//Retrieve the jobs (together with their type information and assembly-id) completed during a given date in a given department 	
				
				//Asking user to enter the department Number	
				System.out.println("Enter the Department Number");
				int department_no= Integer.parseInt(br.readLine());
				//Asking user to enter the completion date	
				System.out.println("Enter the completion Date");
				String date = br.readLine();
				
				final String query12_1 = "SELECT job.job_no, job.commence_date, completion_date, cut_job.type_of_machine, cut_job.time_used, cut_job.material_used, labor_time, assembly_id\r\n" + 
						"			    FROM job, process, cut_job \r\n" + 
						"			    WHERE job.completion_date='" + date +  "' AND "
								+ "job.process_id=process.process_id AND job.job_no=cut_job.cut_job_no AND department_number='" + department_no +  "'";
				
				ResultSet rs = statement.executeQuery(query12_1);
				//since it is a result set, printing all the values
				while (rs.next()) { 
					System.out.println(String.format("  %s  |  %s  |  %s  |  %s  |  %s  |  %s  |  %s  |  %s ",
							rs.getInt(1), 
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getFloat(5),
							rs.getString(6),
							rs.getInt(7),
							rs.getString(8))); 
				
				}
				//since it is a result set, printing all the values
				
				final String query12_2 ="SELECT job.job_no, job.commence_date, completion_date, labor_time, assembly_id\r\n" + 
						"    FROM job, process, fit_job \r\n" + 
						"    WHERE job.completion_date='" + date +  "' AND "
						+ "job.process_id=process.process_id AND job.job_no=fit_job.fit_job_no AND department_number='" + department_no + "'";
						
				ResultSet rs1 = statement.executeQuery(query12_2);
				
				//System.out.println("job_no | commence_date | completion_date | labor_time | assembly_id  ");
				//since it is a result set, printing all the values
				while (rs1.next()) { 
					System.out.println(String.format("  %s  |  %s  |  %s  |  %s  |  %s  ",
							rs1.getInt(1), 
							rs1.getString(2),
							rs1.getString(3),
							rs1.getInt(4),
							rs1.getString(5))); 
					
				}
				
				final String query12_3 = "SELECT job.job_no, job.commence_date, completion_date, paint_job.color, paint_job.volume,paint_job.labor_time, assembly_id\r\n" + 
						"    FROM job, process, paint_job \r\n" + 
						"    WHERE job.completion_date='" + date +  "' AND "
						+ "job.process_id=process.process_id AND job.job_no=paint_job.paint_job_no AND department_number= '" + department_no + "'";
						;
				
				ResultSet rs2 = statement.executeQuery(query12_3);
				//since it is a result set, printing all the values		
				while (rs2.next()) { 
							System.out.println(String.format("  %s  |  %s  |  %s  |  %s  |  %s  |  %s  |  %s ",
									rs2.getInt(1), 
									rs2.getString(2),
									rs2.getString(3),
									rs2.getString(4),
									rs2.getFloat(5),
									rs2.getFloat(6),
									rs2.getString(7)));
				}
				
				System.out.println("=========================================");
			
			}
			
			if(Choice == 13) {
				
				// Retrieve the customers (in name order) whose category is in a given range
				
				//asking user to enter the range
				System.out.println("Enter the category range");
				//asking user for the minimum value in the range
				System.out.println("Minimum category value(category has values from 1 to 10)");
				int min_cat= Integer.parseInt(br.readLine());
				
				//asking user to enter the maximum value in the range in the range
				System.out.println("Maximum category value(category has values from 1 to 10)");
				int max_cat = Integer.parseInt(br.readLine());
				
				//Executing the query 13
	
				
				final String query13 = "SELECT * FROM customer WHERE category BETWEEN '" + min_cat + "' and '" + max_cat + "'";
				
				ResultSet rs1 = statement.executeQuery(query13);
				System.out.println("Name    | Address                             | Category");
				//since it is a result set, printing all the values
				
				while (rs1.next()) {
					System.out.println(String.format("%s   |  %s    | %s ",
							rs1.getString(1),
							rs1.getString(2),
							rs1.getInt(3)));
					
				}
				System.out.println("Retrieved the customers (in name order) whose category is in a given range");		
				System.out.println("=========================================");
					
				
			}
			
			if(Choice == 14) {
				// Delete all cut-jobs whose job-no is in a given range
				
				//asking user to enter the range
				System.out.println("Enter the Job Number range");
				//asking the starting value on the range
				
				System.out.println("Enter the First job number in the range ");
				int first_job= Integer.parseInt(br.readLine());
				//asking the last value in the range
				
				System.out.println("Enter the Last job number in the range");
				int last_job = Integer.parseInt(br.readLine());
				
				//Executing the query 14
	
				
				final String query14 = "DELETE FROM cut_job WHERE cut_job_no BETWEEN '" + first_job + "' and '" + last_job + "'";
				
				statement.executeUpdate(query14);
					
				System.out.println("All the cut_jobs in the given range are Deleted");		
				System.out.println("=========================================");
						
			}
		    
			if(Choice == 15) {
				
				// Change the color of a given paint job 
				
				//asking user to enter the Job Number
				System.out.println("Enter the Job Number of the Paint Job you want to change the color for");
				int first_job= Integer.parseInt(br.readLine());
				
				//reading the color that user want to change the existing cut color to
				System.out.println("which color do you want to change it to?");
				String color = br.readLine();
				
				//Executing the query 15
	
				
				final String query15 = "UPDATE paint_job SET color = '" + color + "' WHERE  paint_job_no = '" + first_job + "'";
				
				statement.executeUpdate(query15);
					
				System.out.println("Color of a given paint job is changed");		
				System.out.println("=========================================");
				
			}
			
			
			if(Choice == 16) {
				
			String file_name;
			//Import: Enter new customers from a data file until the file is empty
			//asking user to enter the name of the file that is to be imported

			System.out.println("Enter the file name: ");

			file_name = myScan.next();
			
			//path where the filename is searched

			FileInputStream fstream = new FileInputStream("/Users/dvsnv/Desktop/" + file_name); 

			DataInputStream i = new DataInputStream(fstream);
			BufferedReader br1 = new BufferedReader(new InputStreamReader( i ));
 
			String Line;
			//Importing each row until the file is empty

			while ((Line = br1.readLine()) != null) { 
			String x[] = Line.split(",");
			String name = x[0];
			String address = x[1];
			String category=x[2];

			statement.executeUpdate("INSERT INTO customer values('" + name + "','" + address + "','"+ category +"')");

			System.out.println("row inserted succesfully");
			 
			}
			System.out.println("File imported succesfully!!!"); 
	
			}
			
			if(Choice == 17) {
				
			String out_file;
			 //Export: Retrieve the customers (in name order) whose category is in a given range and output them to a data file instead of screen 
			
			
			//asking user to enter the range
			System.out.println("Enter the category range");
			
			//reading minimum value in the range
			System.out.println("Minimum category value(category has values from 1 to 10)");
			int min_cat= Integer.parseInt(br.readLine());
			
			//reading the maximum value in the range
			System.out.println("Maximum category value(category has values from 1 to 10)");
			int max_cat = Integer.parseInt(br.readLine());

			final String query13 = "SELECT * FROM customer WHERE category BETWEEN '" + min_cat + "' and '" + max_cat + "'";
			
			ResultSet rs = statement.executeQuery(query13);
			String string = null;

			System.out.println("Enter output file name: ");
			out_file = br.readLine();

			BufferedWriter export = new BufferedWriter(new FileWriter("/Users/dvsnv/Desktop/" + out_file));
			
			//reading each row and exporting it to the file
			while (rs.next()) {
			string = rs.getString("name") + " " + rs.getString("address") + " " + rs.getString("category"); 
			export.write("\n");
			export.write(string);
			export.write("\n"); 

			System.out.println(" Row Exported succesfully!"); } 

			System.out.println(" File exported succesfully!!!"); 

			export.close();

			}
			
			if (Choice == 18)
				//Choice 18 will exit the program
				System.out.println("Thanks... Bye...");
		}
			
			

	  		}
		}
}