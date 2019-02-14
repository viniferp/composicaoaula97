package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department´s name:");
		String department = scanner.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.println("Name: ");
		String name= scanner.nextLine();
		
		System.out.println("Level:");
		String workerLevel= scanner.nextLine();
		
		System.out.println("Base salary:");
		double base_Salary = scanner.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), base_Salary, new Department(department));
		
		System.out.println("How many contracts to this worker:");
		int contracts = scanner.nextInt();
		
		for (int i = 1; i <= contracts; i++) {
			System.out.println("Enter contracts #" + i + "data:");
			System.out.println("Date (DD/MM/YYYY):");
			Date date = sdf.parse(scanner.next());

			System.out.println("Value per hour:");
			double valueHour = scanner.nextDouble();
			
			System.out.println("Duration (hours):");
			int duration = scanner.nextInt();
			
			HourContract hr = new HourContract(date, valueHour, duration);
			
			worker.addContract(hr);
		}
		
		
		System.out.println(" Enter month and year to calculate income (MM/YYYY):");
		String monthYear = scanner.next();
		int month = Integer.parseInt(monthYear.substring(0, 2));
		int year= Integer.parseInt(monthYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income: " + String.format("%.2f", worker.income(year, month)));
		
		
		
		
		
		scanner.close();
	}

}
