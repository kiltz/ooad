package factory;

class DummyServiceImpl implements Service{

	protected DummyServiceImpl() {
    }

	@Override
    public void machWas() {
	    System.out.println("Dummy");
	    
    }

	@Override
    public void machNochEtwas() {
	    System.out.println("noch ein Dummy");
	    
    }

}
