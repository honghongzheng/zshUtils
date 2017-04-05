
public class SD {
	public static void main(String[] args) throws InterruptedException {
		long currentSysTime = System.currentTimeMillis();
		Thread.sleep(1000*60);
		long currentSysTime2 = System.currentTimeMillis();
		int o =(int) (currentSysTime2 - currentSysTime);
		System.out.println(o);

	}
}
