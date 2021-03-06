import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class EmpMain extends EmpService {

	public static void main(String[] args) throws IOException, NoIdException {
		// TODO Auto-generated method stub
		HashMap<Integer,Employee> emplist = new HashMap<>(); 
		emplist.put(1,new Employee(1,"Shreya",22,"GBS","engineer","India"));
		emplist.put(2,new Employee(2,"Shipra",19,"GBS","engineer","USA"));
		emplist.put(3,new Employee(3,"Madhur",20,"GBC","CEO","India"));
		
		int option = 0;
		
		while(option!=6) {
		System.out.println("Menu -");
		System.out.println("1- Add Employee\n2- View Employee\n3- Update Employee\n4- Delete Employee\n5- View All Employees");
		System.out.print("6- Exit\nEnter Your Option-");
		System.out.println("\n\n");
		Scanner sc = new Scanner(System.in);
		option = sc.nextInt();
		
		if(option==1) {
			add(emplist);
		}
		
		if(option==2) {
			System.out.print("Enter the empId-");
			int id = sc.nextInt();
			view(id,emplist);
		}
		
		if(option==3) {
			System.out.print("Enter the empId-");
			int id = sc.nextInt();
			update(id,emplist);
		}
		
		if(option==4) {
			delete(emplist);
		}
		
		if(option==5) {
			viewAll(emplist);
		}
		if(option==6) {
			break;
		}
		if(option==7) {
			importEmployee(emplist);
		}
		if(option==8) {
			exportEmployee(emplist);
		}

	}
}
}
