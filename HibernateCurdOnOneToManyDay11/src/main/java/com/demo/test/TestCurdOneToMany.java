package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.DepartmentService;
import com.demo.service.DepartmentServicesImpl;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestCurdOneToMany {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeService emp=new EmployeeServiceImpl();
		DepartmentService dept=new DepartmentServicesImpl();
		int choices=0;
		do {
			System.out.println("1. Add new Employee\n2. Add new Department\n");
			System.out.println("3. delete employee\n4. delete Department\n");
			System.out.println("5. modify employee\n6. modify Department\n");
			System.out.println("7. display  employee by id\n8. display Department by id\n");
			System.out.println("9. display all employee\n10. display all Department\n");
			System.out.println("11. display all employee in sorted order\n12. exit\nchoice :");
			choices=sc.nextInt();
			switch(choices) {
			case 1:
				emp.addnewEmployee();
				break;
			case 2:
				dept.addnewDept();
				break;
			case 3:
				System.out.println("enetr id");
				int eid=sc.nextInt();
				boolean status=emp.deleteById(eid);
				if(status) {
					System.out.println("deleted successfully");
				}else {
					System.out.println("not found");
				}
			
				break;
			case 4:
				break;
			case 5:
				System.out.println("eneter id");
				eid=sc.nextInt();
				System.out.println("enetr name");
				String name=sc.next();
				System.out.println("enetr sal");
				double sal=sc.nextDouble();
				System.out.println("enetr deptid");
				int deptid=sc.nextInt();
				status=emp.modifyById(eid,name,sal,deptid);
				if(status) {
					System.out.println("updated successfully");
				}else {
					System.out.println("not found");
				}
				break;
			case 6:
				break;
				
			case 7:
				System.out.println("eneter id");
				eid=sc.nextInt();
				Employee e=emp.findById(eid);
				if(e!=null) {
					System.out.println(e);
				}else {
					System.out.println("not found");
				}
				break;
			case 8:
				break;
			case 9:
				List<Employee> elist=emp.findAll();
				elist.forEach(System.out::println);
				break;
				
			case 10:
				break;
			case 11:
				elist=emp.sortBySal();
				elist.forEach(System.out::println);
				break;
			case 12:
				break;
			default:
				break;
				
			}
			
		}while(choices!=12);

	}

}
