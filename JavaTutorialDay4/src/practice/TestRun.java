package practice;

public class TestRun {

	public static void main(String[] args) {

		BasicDataTypes bdt = new BasicDataTypes();

		bdt.setBoolVar(true);
		bdt.setByteVar((byte) -128);
		bdt.setCharVar('A');
		bdt.setDoubleVar(5445646464684.15646486464);
		bdt.setFloatVar(454364354.3543446f);
		bdt.setIntVar(-564131351);
		bdt.setLongVar(53454643441641643L);
		bdt.setShortVar((short) -554641);
		bdt.setStringVar("8\bghidy fygu 98y h89dy fdhasf8 \"\n\n \t\r \" \' \b8uyf dosfjs");

//		bdt.setIntVar(0x4435AF); //this is a hexadecimal value stored in an integer, starts with 0x
//		bdt.setIntVar(0144);  //this is an octal value stored in an integer, starts with 0

		System.out.println(bdt.getCharVar());
		System.out.println(bdt.getDoubleVar());
		System.out.println(bdt.getFloatVar());
		System.out.println(bdt.getIntVar());
		System.out.println(bdt.getLongVar());
		System.out.println(bdt.getStringVar());
		System.out.println(bdt.getByteVar());
		System.out.println(bdt.getShortVar());
		System.out.println(bdt.isBoolVar());

	}

}
