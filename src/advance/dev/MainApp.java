package advance.dev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainApp {
	public static void main(String[] args) {
		String fileName = "input.txt";
		List<Person> people = readPeopleFromFile(fileName);

		// a) Hiển thị danh sách các đối tượng trong tập tin input.txt
		System.out.println("Danh sách các đối tượng:");
		for (Person person : people) {
			System.out.println(person);
		}

		// b) Xắp xếp theo lương tăng dần
		sortPeopleByIncome(people);
		System.out.println("\nDanh sách các đối tượng theo lương tăng dần:");
		for (Person person : people) {
			System.out.println(person);
		}

		// c) Hiển thị lương cao nhất
		double maxIncome = getMaxIncome(people);
		System.out.println("\nLương cao nhất: " + maxIncome);
	}

	private static List<Person> readPeopleFromFile(String fileName) {
		List<Person> people = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(":");
				String name = parts[0].trim();
				int age = Integer.parseInt(parts[1].trim());
				String city = parts[2].trim();
				double income = Double.parseDouble(parts[3].replaceAll("\\.", "").trim());

				Person person = new Person(name, age, city, income);
				people.add(person);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return people;
	}

	private static void sortPeopleByIncome(List<Person> people) {
		Collections.sort(people, Comparator.comparingDouble(Person::getIncome));
	}

	private static double getMaxIncome(List<Person> people) {
		double maxIncome = 0;
		for (Person person : people) {
			if (person.getIncome() > maxIncome) {
				maxIncome = person.getIncome();
			}
		}
		return maxIncome;
	}
}