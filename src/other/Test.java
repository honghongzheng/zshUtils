package other;

public class Test {
	public static int a = 0;
	static {
		a = 10;
		System.out.println(a);//10
	}

	{
		a = 190;
		System.out.println(a);//8
	}

	public Test() {
		this(Test.a);
		System.out.println(a);//8
		System.out.println(a);//8
	}

	public Test(int n) {
		System.out.println(n);
		System.out.println(a);

	}

	public static void main(String[] args) {
		Test tsc = null;
		tsc = new Test();
	}
	
	/**
	 * 10
8
10
8
8
8
	 */
}
