package com.venkat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeManagement {

	private String dash = "***************************************";

	public void oldestEmployeeDetails() {
		System.out.println(dash);
		System.out.println("Oldest Employee Details");
		List<Employee> employeeList = getEmployeeList();
		Optional<Employee> oe = employeeList.stream()
				.max(Comparator.comparingInt(Employee::getAge));
		Employee employee = oe.get();
		System.out.println(employee.getName());
		System.out.println(employee.getAge());
		System.out.println(employee.getGender());
		System.out.println(employee.getDepartment());

		System.out.println("Youngest Employee Details");
		employee = employeeList.stream()
				.min(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println(employee.getName());
		System.out.println(employee.getAge());
		System.out.println(employee.getGender());
		System.out.println(employee.getDepartment());
		System.out.println(dash);
	}
	
	public void getHighestPaidEmploee() {
		System.out.println(dash);
		System.out.println("Highest Paid Employee Details");
		List<Employee> employeeList = getEmployeeList();
		Employee employee = employeeList.stream()
			.max(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(employee.getName());
		System.out.println(employee.getDepartment());
		System.out.println(employee.getSalary());
		
		System.out.println("Lowest Paid Employee Details");
		employee = employeeList.stream()
				.min(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(employee.getName());
		System.out.println(employee.getDepartment());
		System.out.println(employee.getSalary());
		System.out.println(dash);
	}

	public void productDevelopmentDepartment() {
		System.out.println(dash);
		System.out.println("Youngest Male in Product Development Department");
		List<Employee> employeeList = getEmployeeList();
		Employee employee = employeeList.stream()
				.filter(e -> e.getDepartment() == "Product Development")
				.filter(e -> e.getGender() == "Male")
				.min(Comparator.comparingInt(Employee::getAge)).get();
		
		System.out.println(employee.getName());
		System.out.println(employee.getDepartment());
		System.out.println(employee.getGender());
		System.out.println(dash);
		
		System.out.println("Oldest Fe-male in Product Development Department");
		employee = employeeList.stream()
				.filter(e -> e.getDepartment() == "Product Development")
				.filter(e -> e.getGender() == "Female")
				.max(Comparator.comparingInt(Employee::getAge)).get();
		
		System.out.println(employee.getName());
		System.out.println(employee.getDepartment());
		System.out.println(employee.getGender());
		
		employeeList.stream()
			.filter(e -> e.getAge() > 30)
			.sorted(Comparator.comparing(Employee::getName))
			.forEach(System.out::println);
	}
	
	public void totalMaleFemale() {
		System.out.println(dash);
		System.out.println("Male Female Count in the Organization");
		List<Employee> employeeList = getEmployeeList();
		Map<String,Long> map = employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getGender , Collectors.counting()));
		System.out.println(map);
		System.out.println(dash);
	}
	
	public void departmentMemberCount() {
		System.out.println(dash);
		System.out.println("Total members in each department");
		List<Employee> employeeList = getEmployeeList();
		Map<String, Long> map = employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(map);
		System.out.println(dash);
	}
	
	public void averageAgeOfGender() {
		System.out.println(dash);
		System.out.println("Average Age of male and female employees in the organization");
		List<Employee> employeeList = getEmployeeList();
		Map<String, Double> map = employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		
		System.out.println(map);
		System.out.println(dash);
	}
	
	public void averageSalarayOfDepartment() {
		System.out.println(dash);
		System.out.println("Average Salary of employees in the organization");
		List<Employee> employeeList = getEmployeeList();
		Map<String, Double> map = employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(map);
		System.out.println(dash);
	}
	
	public void employeesInEachDepartment() {
		System.out.println(dash);
		System.out.println("List of employees in each Department");
		List<Employee> employeeList = getEmployeeList();
		Map<String, List<Employee>> map = employeeList.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(map);
		System.out.println(dash);
	}
	
	public void mostExperiencedEmployee() {
		System.out.println(dash);
		System.out.println("Most experienced employee in the Organization");
		List<Employee> employeeList = getEmployeeList();
		Employee employee = employeeList.stream()
			.min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
		System.out.println(employee);
		
		System.out.println("Using sorted::findFirst Operation");
		employee = employeeList.stream()
			.sorted(Comparator.comparingInt(Employee::getYearOfJoining))
			.findFirst().get();
		System.out.println(employee);
		
		System.out.println("Least experienced employee in the Organization");
		employee = employeeList.stream()
			.max(Comparator.comparingInt(Employee::getYearOfJoining)).get();
		System.out.println(employee);
		System.out.println("Using sorted::findFirst Operation");
		employee = employeeList.stream()
			.sorted(Comparator.comparingInt(Employee::getYearOfJoining))
			.findFirst().get();
		System.out.println(employee);
		
		System.out.println(dash);
	}
	
	public void salarySummary() {
		System.out.println(dash);
		System.out.println("Most experienced employee in the Organization");
		List<Employee> employeeList = getEmployeeList();
		DoubleSummaryStatistics stats = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Avg salary ::: " + stats.getAverage());
		System.out.println("Sum salary :::" + stats.getSum());
		System.out.println("Max salary :::" + stats.getMax());
		System.out.println("Min salary :::" + stats.getMin());
		System.out.println(dash);
	}
	
	public void partitionEmployee() {
		System.out.println(dash);
		System.out.println("Partition employees over age above 25 years");
		List<Employee> employeeList = getEmployeeList();
		Map<Boolean,List<Employee>> map = employeeList.stream()
			.collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		
		
		map.entrySet().stream().forEach(es -> {
			if(es.getKey()) {
				System.out.println("Employee above 25 years age");
				es.getValue().stream()
					.map(Employee::getName)
					.forEach(System.out::println);
			}else {
				System.out.println("Employee below 25 years age");
				es.getValue().stream()
					.map(Employee::getName)
					.forEach(System.out::println);
			}
		});
		System.out.println(dash);
	}
	
	public void getDepartments() {
		System.out.println(dash);
		System.out.println("Departments in the Organization");
		List<Employee> employeeList = getEmployeeList();
		
		employeeList.stream()
			.map(Employee::getDepartment)
			.distinct()
			.forEach(System.out::println);
		System.out.println(dash);
	}
	
	public void employeeJoinedAfter2015() {
		System.out.println(dash);
		System.out.println("Employees Joined After 2015");
		
		List<Employee> employeeList = getEmployeeList();
		employeeList.stream()
			.filter(e -> e.getYearOfJoining() > 2015 )
			.map(Employee::getName)
			.forEach(System.out::println);
		
		System.out.println(dash);
	}
	

	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		return employeeList;
	}

}
