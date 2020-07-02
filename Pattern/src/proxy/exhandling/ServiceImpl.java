package proxy.exhandling;

public class ServiceImpl implements Service {

	@Override
	public String ping(String txt) {
		
		return txt.toUpperCase();
	}

}
