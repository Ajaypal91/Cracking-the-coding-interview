package bitManipulation;

//java has no unsigned integer
public class HelperMethods {
	
	public static void printBits(int n){
		int msk = 1;
		if (n < 0)
			System.out.print("1");
		else
			System.out.print("0");
		for (int i = 30;i >=0; i--){
			msk = 1;
			msk = (msk<<i);
			if ((msk & n) > 0)
				System.out.print("1");
			else
				System.out.print("0");
		}
		System.out.println();
	}

}
