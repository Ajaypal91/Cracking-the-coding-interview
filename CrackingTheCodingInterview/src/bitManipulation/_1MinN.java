package bitManipulation;

public class _1MinN {

	public static void main(String[] args) {
		
		int n = 65;
		int m = 19;
		HelperMethods.printBits(n);
		HelperMethods.printBits(m);
		
		int i = 2; int j = 6;
		int msk = (int)Math.pow(2, j-i+1)-1;
		msk = (~msk)<<i; //shift msk by i bits
		// add 1s to the right side
		msk = msk | ((int)Math.pow(2, i)-1);
		HelperMethods.printBits(msk);
		HelperMethods.printBits( (n&msk)|(m<<i)); //reset the bits through these position and the or with m
	}

}
