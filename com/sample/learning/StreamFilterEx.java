package com.sample.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamFilterEx {

	public static void main(String a[]) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Nataraja G", "Accounts", 8000));
		empList.add(new Employee("Nagesh Y", "Admin", 15000));
		empList.add(new Employee("Vasu V", "Security", 2500));
		empList.add(new Employee("Amar", "Entertinment", 12500));

		// empList.stream().filter(emp->emp.getSalary() >
		// 12000).forEach(System.out::println);

		//empList.stream().sorted((emp1, emp2) -> emp1.getSalary().compareTo(emp2.getSalary()))
		//		.forEach(System.out::println);
		
		
		//sort by salary
		Collections.sort(empList, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});		
		
		empList.stream().forEach(System.out::println);
	}
	
	
}