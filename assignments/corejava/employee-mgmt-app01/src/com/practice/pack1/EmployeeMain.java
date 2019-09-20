package com.practice.pack1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EmployeeMain {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		Map<Integer, Employee<Double>> employees = new TreeMap<>();

		employees.put(100, new Employee<Double>(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000.0));
		employees.put(101, new Employee<Double>(101, "Mukesh", 25, "Male", "Developer", "CSE", 20000.0));
		employees.put(102, new Employee<Double>(102, "Jancy", 30, "Female", "Sr.Developer", "IT", 30000.0));
		employees.put(103, new Employee<Double>(103, "John", 28, "Male", "Developer", "ECE", 40000.0));
		employees.put(104, new Employee<Double>(104, "Mathew", 30, "Male", "Developer", "IT", 60000.0));
		employees.put(105, new Employee<Double>(105, "Mary", 27, "Female", "Sr.Developer", "CSE", 70000.0));
		
		System.out.println("1: add an employee");
		System.out.println("2: view an employee ");
		System.out.println("3: delete an employee ");
		System.out.println("4: view all employees ");
		System.out.println("5: update an employee ");
		System.out.println("6: import ");
		System.out.println("7: export ");
		System.out.println("8: exit ");
		
		System.out.println("enter option:");
		
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		int option=myObj.nextInt();
		int id;
		
		switch(option) {
		
		case 1:
			employees.put(106, new Employee<Double>(106, "Anand", 35, "Male", "Sr.Developer", "IT", 50000.0));
			break;
			
		case 2:
			System.out.println("enter employee id of employee to be shown:");
			id=myObj.nextInt();
			System.out.println(employees.get(id));
			break;
			
		case 3:
			System.out.println("enter employee id of employee to be deleted:");
			id=myObj.nextInt();
			employees.remove(id);
			break;
			
		case 4:
			List<Employee<Double>> emp1 = new ArrayList<>(employees.values());
			for (Employee<Double> empl : emp1) {
				System.out.println(empl);
			}
			break;
			
		case 5:
			System.out.println("enter employee id of employee to be updated:");
			id=myObj.nextInt();
			//List<Employee<Double>> emp2 = new ArrayList<>(employees.values());
			System.out.println("enter name:");
			String name=myObj.next();
			Employee e=employees.get(id);
			e.setName(name);
			break;
			
		case 6:
			FileInputStream file = new FileInputStream("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\file.txt");  
			BufferedReader br = new BufferedReader(new InputStreamReader(file));

			String strLine;
			Employee<Double> emp=new Employee<Double>();
            System.out.println("Before import: " + employees.values());
			while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
				System.out.println(strLine);
				String[] data=strLine.split(",");
				int a=(Integer.parseInt(data[0]));
				String b=data[1];
				int c=Integer.parseInt(data[2]);
				String d=data[3];
				String s=data[4];
				String f=data[5];
				Double g=Double.parseDouble(data[6]);
				Employee<Double> emp6=new Employee<Double>(a,b,c,d,s,f,g);
				
				employees.put(a, emp6);

				System.out.println("Importing emp id " + emp.getEmpId());
				
			}
            
			List<Employee<Double>> emp4 = new ArrayList<>(employees.values());
			System.out.println("After import: ");
			for (Employee<Double> empl : emp4) {
				System.out.println(empl);
			}
			break;
			
		case 7:
			
			
			break;
			
	
			
		}
	}

}


