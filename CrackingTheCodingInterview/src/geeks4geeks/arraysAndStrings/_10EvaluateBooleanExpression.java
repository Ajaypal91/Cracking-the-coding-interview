package geeks4geeks.arraysAndStrings;

//https://stackoverflow.com/questions/2974402/evaluate-boolean-values-in-java
public class _10EvaluateBooleanExpression {

	public static void main(String[] args) {
		
		String s = ("false || true && true && true || false");
		System.out.println(evaluate2(s));
		
	}
	
	private static boolean evaluate(String s){
		
		boolean result = false;
		
		for(String val : s.split("\\|\\|")){
			boolean b = true;
			for(String i : val.split("&&")){
				b &= Boolean.parseBoolean(i.trim());
			}
			result |= b;
		}
		
		
		return result;
	}
	
	public static boolean evaluate2(String s){
		
		String[] vals = s.split("\\s+");
		
		if(vals.length == 0)
			return false;
		
		boolean result = Boolean.parseBoolean(vals[0]);
		
		int operator = -1;
		for(int i = 1; i < vals.length; i++){
			
			if(vals[i].equals("&&"))
				operator = 0;
			else if(vals[i].equals("||"))
				operator = 1;
			else{
				if(operator == 0)
					result &= Boolean.parseBoolean(vals[i]);
				else
					result |= Boolean.parseBoolean(vals[i]);
			}
			
		}
		
		return result;
	}

}
