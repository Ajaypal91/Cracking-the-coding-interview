package inheritence;


//https://docstore.mik.ua/orelly/java/langref/ch09_04.htm
public class OverridenException extends GenericException{

	public OverridenException(){
		System.out.println("Inside Overridden Exception Constructor");
	}
	
	//exceptions belonging to same level can be thrown
	public void exceptionThrow() throws IllegalThreadStateException{
		
		System.out.println("Overridden Exception methid throws Generic Exception");
		
	}
	
//	public void exceptionThrow() throws Exception{
//		
//		System.out.println("Overridden Exception methid throws Generic Exception");
//		
//	}
}
