package singleton;

import java.text.DateFormat;

import org.junit.Assert;
import org.junit.Test;

public class Tester {

	@Test
	public void testeSingleton() {
		
		EinSingleton instanz1 = EinSingleton.getInstance();
		EinSingleton instanz2 = EinSingleton.getInstance();
		
		Assert.assertTrue(instanz1 == instanz2);

		// nicht m�glich!
		// EinSingleton instanz3 = new EinSingleton();
		
		// Singleton f�r eine Konfiguration
		DateFormat df = DateFormat.getInstance();
		
	}


}
