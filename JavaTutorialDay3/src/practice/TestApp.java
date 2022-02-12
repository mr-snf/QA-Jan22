package practice;

public class TestApp {

	public static void main(String[] args) {

		Person p1 = new Person("This is a test person");

//		p1.setName("Sanish");
//		p1.setAge(999);
//		p1.setPhoneNo(874563456464L);
//		p1.setWeight(999.99f);

		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getWeight());
		System.out.println(p1.getPhoneNo());

	}

}
