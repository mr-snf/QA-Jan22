package practice;

public class Person {

	String name;
	int age;
	float weight;
	long phoneNo;

	public Person(String val) {
//		name = "test";
		name = val;
		age = 100;
		weight = 111.1111f;
		phoneNo = 8643541341646L;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getWeight() {
		return weight;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setName(String value) {
		name = value;
	}

	public void setAge(int value) {
		age = value;
	}

	public void setWeight(float value) {
		weight = value;
	}

	public void setPhoneNo(long value) {
		phoneNo = value;
	}
}
