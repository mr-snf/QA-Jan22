package operators;

public class AssigmentOperators {

	public static void main(String[] args) {
		int a = 10, b = 20;
		a = b - a;
		System.out.println(a);
		a = a + b;
		System.out.println(a);
		a += b; // a = a+b;
		System.out.println(a);
		a -= b; // a = a-b;
		System.out.println(a);
		a *= b; // a = a*b;
		System.out.println(a);
		a /= b; // a = a/b;
		System.out.println(a);
		a %= b; // a = a%b;
		System.out.println(a);
		System.out.println();
		a <<= 3; // a = a<<3; 0101 0000
		System.out.println(a);
		a >>= 4; // a = a>>4; 0000 0101 0001 0100
		System.out.println(a);
		a &= b; // a = a&b;
		System.out.println(a);
		a ^= b; // a = a ^ b;
		System.out.println(a);
		a |= b; // a= a | b;
		System.out.println(a);

		int c = 0, d = 15;

		c = ++d; // d = d+1; c=d;
		System.out.println(c);
		System.out.println(d);
		c = d++; // c=d; d= d+1;
		System.out.println(c);
		System.out.println(d);
		c = --d;
		System.out.println(c);
		System.out.println(d);
		c = d--;
		System.out.println(c);
		System.out.println(d);


	}

}
