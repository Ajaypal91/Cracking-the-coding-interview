package arraysAndStrings;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class _1UniqueString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		//using boolean hash table
		System.out.println(isUniqueUsingHashTable(s));
		
		//using bit array
		System.out.println(isUniqueUsingBitArray(s));
		
		sc.close();
	}

	private static boolean isUniqueUsingBitArray(String s) {
		// TODO Auto-generated method stub
		BitSet b = new BitSet(256);
		for (int i = 0 ; i < s.length(); i ++ ) {
			if (b.get((int)s.charAt(i))){
				return false;
			}
			b.set((int)s.charAt(i));
		}
		return true;
	}

	private static boolean isUniqueUsingHashTable(String s) {
		// TODO Auto-generated method stub
		
		boolean[] hashTable = new boolean[256];
		for (int i =0 ; i < s.length(); i ++) {
			int v = s.charAt(i);
			if (hashTable[v]) {
				return false;
			}
			hashTable[v] = true;
		}
		
		return true;
	}

}
