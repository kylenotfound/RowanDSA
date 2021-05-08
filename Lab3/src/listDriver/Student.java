package listDriver;

/**
 * A class to represent a student with an Id and Name
 * Kyle Evangelisto Feb 2021
 */
public class Student {

	private String name;
	private int id;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) {
			return false;
		}
		
		Student temp = (Student) obj;
		return temp.getId() == this.getId();
	}
	
	public String toString() {
		return "[" + getName() + ", " + getId() + "]";
	}
}
