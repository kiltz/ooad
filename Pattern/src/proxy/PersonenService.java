package proxy;

import java.util.List;

public interface PersonenService {

	List<Person> suche(String such);
	Person neu(String personAlsSting);
}
