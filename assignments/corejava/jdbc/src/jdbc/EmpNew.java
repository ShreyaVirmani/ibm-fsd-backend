package jdbc;



	public class EmpNew {

		
		private int id;
		private String name;
		private int age;
		private String department;
		private int salary;

		

		// overloaded custom constructor
		public EmpNew(int id, String name, int age, String department,int salary) {
		
			this.id = id;
			this.name = name;
			this.age=age;
			this.department = department;
			this.salary = salary;
		}

		public int getId() {
			return id;
		}

		public void setid(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}

		public void setage(int age) {
			this.age=age;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

	  @Override
		public String toString() {
			return "Employee [id=" + id+ ", name= "+String.valueOf(this.getName())+", Age="+String.valueOf(this.getAge())+ ", department=" + department + ",salary="+ salary + "]";
		}


	

		

}
