
package advance.dev;

public class Person {
	
	    private String name;
	    private int age;
	    private String city;
	    private double income;

	    public Person(String name, int age, String city, double income) {
	        this.name = name;
	        this.age = age;
	        this.city = city;
	        this.income = income;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String getCity() {
	        return city;
	    }

	    public double getIncome() {
	        return income;
	    }

	    @Override
	    public String toString() {
	        return "Name: " + name + ", Age: " + age + ", City: " + city + ", Income: " + income;
	    }
	}