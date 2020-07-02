package factory;

class InMemoryServiceImpl implements Service{

	protected InMemoryServiceImpl() {
    }
	@Override
    public void machWas() {
	    System.out.println("InMemory");
	    
    }

	@Override
    public void machNochEtwas() {
		System.out.println("InMemory");
    }

}
