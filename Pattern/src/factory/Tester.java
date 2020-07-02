package factory;

public class Tester {

	public  static void main (String[] args) {
		Service s = ServiceFactory.createService();
		s.machNochEtwas();
	}
}
