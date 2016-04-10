package com.yougal;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 
 * This is was asked in Amazon SDE online test from Hacker rank. 
 * Initech is a company which has CEO Bill and a hierarchy of employees. 
 * Employees can have a list of other employees reporting to them, which can themselves have reports, and so on. 
 * An employee with at least one report is called a manager. 
 * 
 * Please implement the closestCommonManager method to find the closest manager (i.e. farthest from the CEO) to two employees. 
 * You may assume that all employees eventually report up to the CEO. 
 * Tree structure: 
 * 				Bill -> Dom, Samir, Michael 
 * 				Dom -> Bob, Peter, Porter 
 * 				Peter -> Milton, Nina 
 * 
 * 
 * Sample Data: 
 * 				CEO Bill has 3 employees reporting to him: {Dom, Samir, Michael} 
 * 				Dom has three reports { Peter, Bob, Porter} 
 * 				Samir has no reports {} 
 * 				Michael has no reports {} 
 * 				Peter has 2 reports {Milton, Nina} 
 * 				Bob has no reports {} 
 * 				Porter has no reports {} 
 * 				Milton has no reports {} 
 * 				Nina has no reports {} 
 * 
 * 
 * Sample calls: 
 * 				closestCommonManager(Milton, Nina) = Peter 
 * 				closestCommonManager(Nina, Porter) = Dom 
 *				closestCommonManager(Nina, Samir) = Bill 
 *				closestCommonManager(Peter, Nina) = Peter
 * 
 * 
 * 
 * 
 * @author yougal.bisht
 *
 */
public class CommonManager {
	
	public static void main(String[] args) {
		Employee ceo=	constructCompany();
		
		Employee e1 = new Employee("Milton");
		Employee e2 = new Employee("Nina");
		System.out.println("Manager of " + e1 + e2);
		closestCommonManager(e1, e2,ceo);
		
		Employee e3 = new Employee("Porter");
		System.out.println("Manager of " + e2 + e3);
		closestCommonManager(e2, e3,ceo);
		
		Employee e4 = new Employee("Samir");
		System.out.println("Manager of " + e2 + e4);
		closestCommonManager(e2, e4,ceo);
		
		Employee e5 = new Employee("Peter");
		System.out.println("Manager of " + e5 + ", "+e2);
		closestCommonManager(e5, e2,ceo);
	}
	
	static class Result{
		int count;
		Employee employee;
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Result [employee=" + employee + "]";
		}
	}
	
	private static int closestCommonManager(Employee e1,Employee e2, Employee ceo) {
		if(ceo==null){
			return 0;
		}
		if(e1.equals(ceo) || e2.equals(ceo)){
			return 1+ searchEmployeeInReportees(e1,e2,ceo);
		}
		else{
			return searchEmployeeInReportees(e1,e2,ceo);
		}
	}

	private static int searchEmployeeInReportees(Employee e1,Employee e2, Employee ceo) {
		int sum=0;
		if(ceo.reportees!=null){
			for (Employee reportee : ceo.reportees) {
				sum=sum+closestCommonManager(e1, e2, reportee);
				if(sum==2){
					System.out.println(ceo);
					return 0;
				}
			}
		}
		return sum;
	}

	private static Employee constructCompany() {
		Employee ceo = new Employee("Bill");
		
		Employee dom =  new Employee("Dom");
		Employee samir =  new Employee("Samir");
		Employee michael =  new Employee("Michael");
		
		ceo.reportees= new ArrayList<CommonManager.Employee>();
		ceo.reportees.add(dom);
		ceo.reportees.add(samir);
		ceo.reportees.add(michael);
		
		Employee porter =  new Employee("Porter");
		Employee bob =  new Employee("Bob");
		Employee peter =  new Employee("Peter");
		
		dom.reportees= new ArrayList<CommonManager.Employee>();
		dom.reportees.add(porter);
		dom.reportees.add(bob);
		dom.reportees.add(peter);
		
		Employee milton =  new Employee("Milton");
		Employee nina =  new Employee("Nina");
		
		peter.reportees= new ArrayList<CommonManager.Employee>();
		peter.reportees.add(milton);
		peter.reportees.add(nina);
		
		return ceo;
	}

	private static class Employee{
		String name;
		List<Employee> reportees;
		public Employee(String name) {
			super();
			this.name = name;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Employee [name=" + name + "]";
		}
		
	}

}
