package proxy;

import java.util.List;

public class PersonenServiceImpl implements PersonenService {

	@Override
	public List<Person> suche(String such) {
		System.out.println("Suche: "+such);
		return null;
	}

	@Override
	public Person neu(String personAlsSting) {
		System.out.println("Neu: "+personAlsSting);
		return null;
	}

}
