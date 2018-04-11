package inheritence;

public class ExceptionDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericException g = new GenericException();
		
		
		try{
			g.exceptionThrow();
		}
		catch(ArithmeticException e){
			
		}
		
		System.out.println();
		
		GenericException g1 = new OverridenException();
		
		try{
			g1.exceptionThrow();
		}
		catch(ArithmeticException e){
			
		}
		
	}

}
