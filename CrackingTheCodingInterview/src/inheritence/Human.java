package inheritence;

public class Human extends Mammal{

	public Human(){
		
		System.out.println("Human Constructor");
		
	}
	
	public void print(){
		
		System.out.println("Inside Human");
		
	}
	
	public void onlyHuman(){
		
		System.out.println("Not overriden human method");
		
	}
	
	public static void main(String[] args) {
		
		Human h;
		System.out.println("Break");
		h = new Human();
		h.print();
		h.onlyHuman();
		h.onlyMammal();
		
		System.out.println();
		System.out.println("Break");
		
		Mammal m = new Mammal();
		m.print();
		m.onlyMammal();
	
		System.out.println();
		System.out.println("Break");
		Mammal m1 = new Human();
		m1.print();
		m1.onlyMammal();
		//onlyHuman does not exist in Mammal
//		m1.onlyHuman();
		
		
		
	}

}
