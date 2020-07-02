package observer;

public class Tester {
    
	public static void main(String[] argv) {
		Counter counter = new Counter(0);
		
		CounterView cv1 = new CounterView("CounterView1", counter);
		CounterView cv2 = new CounterView("CounterView2", counter);
		counter.addObserver(cv1);
		counter.addObserver(cv2);
	}
}
