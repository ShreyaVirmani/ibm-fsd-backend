package jdbc;

	//STEP 1. Import required packages
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

	public class EmployeeDb {

		public static void main(String[] args) {

			Connection conn = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// STEP 2: Create Datasource instance
				MysqlDataSource dataSource = new MysqlDataSource();
				dataSource.setDatabaseName("jdbctraining");
				dataSource.setUser("training");
				dataSource.setPassword("training");
				dataSource.setServerName("localhost");

				// STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = dataSource.getConnection();
				conn.setAutoCommit(true); // enable transaction

				System.out.println("Connection estabilished: " + conn);

				// STEP 4: Execute a query
				System.out.println("Creating statement...");
				stmt = conn.createStatement();

				// Insertion with Statement
		//String insertQuery = "INSERT INTO EmpNew (name, age, designation, department, country) VALUES ('Anil', 30, 'Developer', 'Admin', 'India')";

create table EmpNew(
		)
				// Insertion with Prepared Statement
				String insertQueryForPrepareStmt = "INSERT INTO Empnew (id,name, age,  department, salary) VALUES (?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
				pstmt.setInt(1,101);
				pstmt.setString(2, "Mathew");
				pstmt.setInt(3, 30);
				pstmt.setString(4, "IT");
				pstmt.setInt(5, 50000);
				int insertCount = pstmt.executeUpdate();
				pstmt.close();
				System.out.println(insertCount + " Employee(s) inserted");


				String selectQuery = "SELECT * FROM employee";
				rs = stmt.executeQuery(selectQuery);

				// STEP 5: Extract data from result set
				// Header
				System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Name", "Age", "Department",
						"Salary");
				while (rs.next()) {
					// Retrieve by column name
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String department = rs.getString("department");
					String salary = rs.getString("salary");

					// Display values
					System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name,  department,salary);
				}

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e) {
				}
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException sqle) {
				}
			} finally {
				// finally block used to close resources
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException se2) {
				}
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("Goodbye!");
		}// end main
	}// end FirstExample

