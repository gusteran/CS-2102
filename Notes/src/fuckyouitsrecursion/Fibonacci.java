package fuckyouitsrecursion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;

public class Fibonacci {
	
	Hashtable<Integer, Long> fib;
	ArrayList<Long> fibo;
	
	
	public Fibonacci() {
		fib = new Hashtable<Integer, Long>();
//		fib.put(0, 0L); fib.put(1, 1L);
		fibo = new ArrayList<Long>();
		fibo.add(0L); fibo.add(1L);
	}
	
	public long getNthFibHashtable(int index) {
		if(index < 1)return 0;
		if(index == 1)return 1;
		if(fib.containsKey(index)) return fib.get(index);
		return getNthFibHashtable(index-2) + getNthFibHashtable(index-1);
	}
	
	public long fuckYouItsFib(int index) {
		ArrayList<Long> frig = new ArrayList<Long>();
		frig.add(0L); frig.add(1L);
		while(frig.size()<=index+1) {
			frig.add(frig.get(frig.size()-1)+frig.get(frig.size()-2));
		}
		if(index <0) return 0;
		return frig.get(index);
	}
	
	public BigInteger fuckYouItsFibTwo(int index) {
		ArrayList<BigInteger> frig = new ArrayList<BigInteger>();
		frig.add(new BigInteger("0")); frig.add(new BigInteger("1"));
		while(frig.size()<=index+1) {
			frig.add(frig.get(frig.size()-1).add(frig.get(frig.size()-2)));
		}
		if(index <0) return new BigInteger("0");
		return frig.get(index);
	}
	
	public int howLongTilFibOverlongs() {
		int index = 1;
//		while(fuckYouItsFibTwo(index++).compareTo(BigInteger.ZERO)>0) {
//			if(index % 1000 == 0) System.out.println("index: "+index+" fuck: "+fuckYouItsFibTwo(index));
//		}
//		return index;
		ArrayList<BigInteger> frig = new ArrayList<BigInteger>();
		frig.add(new BigInteger("0")); frig.add(new BigInteger("1"));
		while(fuckYouItsFibTwo(index++).compareTo(BigInteger.ZERO)>0) {
			frig.add(frig.get(frig.size()-1).add(frig.get(frig.size()-2)));
			if(index % 1000 == 0) System.out.println("index: "+index+" fuck: "+frig.get(index));
		}
		if(index <0) return 0;
		return index;
	}
	
	public int howLongTilZero() {
		int index = 100;
		while(!(Math.abs(fuckYouItsFib(index++))<1000)) {
			if(index % 1000 == 0) System.out.println("index: "+index+" fuck: "+fuckYouItsFib(index));
		}
		return index;
	}
	
	public long getNthFibArray(int index) {
		if(fibo.size()>=index+1) return fibo.get(index);
		return getNthFibArray(index-1) + getNthFibArray(index-2);
	}


	public static void main(String[] SIAKDDM) {
		Fibonacci test = new Fibonacci();
		long large = test.fuckYouItsFib(96);
//		long large = test.getNthFibHashtable(39);
//		long large = test.getNthFibArray(50);
//		System.out.println(large);
		System.out.println(test.howLongTilFibOverlongs());
	}
}
