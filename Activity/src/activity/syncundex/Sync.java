package activity.syncundex;

public class Sync extends Thread {

	private int sekunden;
	private String name;
	
	public Sync(String name, int sekunden) {
		this.name = name;
		this.sekunden = sekunden;
		start();
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Beginne Coutdown");
		Sync s1 = new Sync("Kurz", 2);
		Sync s2 = new Sync("Lang", 4);
		s1.join();
		s2.join();
		System.out.println("Countdown Ende!");
		
	}

	@Override
	public void run() {
		while (sekunden > 0) {
			System.out.println(name+": "+sekunden);
			try {
				sekunden--;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
