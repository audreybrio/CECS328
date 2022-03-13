import java.math.BigInteger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;
import java.io.*;


public class project2 {
	
	
	

	
public static BigInteger num;
public static int count = 0;
public static BigInteger ggccdd;
public static int total = 0;
public static FileWriter writeOut;



public static int GCD(BigInteger a, BigInteger b, BigInteger div) {
	if(a.compareTo(BigInteger.ZERO)==0 || b.compareTo(BigInteger.ZERO) == 0) {
		return count;
	}
	
	else {
		if(a.mod(div).equals(BigInteger.ZERO) && b.mod(div).equals(BigInteger.ZERO) ) {
			count = count + 2;
			GCD(a.divide(div), b.divide(div), div);
		}
		
		else if(a.mod(div).equals(BigInteger.ZERO) && b.mod(div).compareTo(BigInteger.ZERO) != 0 ) {
			count = count + 1;
			GCD(a.divide(div), b, div);
		}
		
		else if(a.mod(div).compareTo(BigInteger.ZERO) != 0 && b.mod(div).equals(BigInteger.ZERO)){
			count = count +1;
			GCD(a, b.divide(div), div);
		}
	}
	
	return count;
}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("proj2_input1.txt");
		
		try {
	      
	      if (file.createNewFile()) {
	       // System.out.println("File created: " + file.getName());
	      } else {
	        //System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	    	System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	Scanner line = new Scanner(file);
	ArrayList<BigInteger> entries = new ArrayList<>();
	
	while(line.hasNext()) {
		entries.add(line.nextBigInteger());
		
	}
	
	
	num = entries.get(0);
	entries.remove(0);
	ArrayList<BigInteger> divide = new ArrayList<BigInteger>();
	List<SimpleEntry<BigInteger, BigInteger>> gcd = new ArrayList<SimpleEntry<BigInteger, BigInteger>>();
	
	for(BigInteger i = BigInteger.ZERO; i.compareTo(num) == -1; i = i.add(BigInteger.ONE)) {
		divide.add(entries.get(i.intValue()));
		//System.out.println("hello");
	}
	
	for(int i = num.intValue(); i < entries.size()-1; i=i+2) {
		BigInteger a = entries.get(i);
		BigInteger b = entries.get(i+1);
		gcd.add(new SimpleEntry<BigInteger, BigInteger>(a, b));

	}
	
	//BigInteger i = BigInteger.ZERO; i.compareTo(num) == -1; i = i.add(BigInteger.ONE)
	
	
	try {
	       writeOut = new FileWriter("output.txt");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      //e.printStackTrace();
	    }
	
	for(int i = 0; i < divide.size();i++) {
		for(int j = 0; j < gcd.size(); j++) {

			AbstractMap.SimpleEntry<BigInteger, BigInteger> val = gcd.get(j);
			BigInteger a = val.getKey();
			BigInteger b = val.getValue();
			
			//BigInteger h = new BigInteger("2767913");
			BigInteger h = divide.get(i);
			
			
			total = GCD(a,b,h);
			
			
		}
		//System.out.println(divide.get(i) + " " + total);
		writeOut.write(divide.get(i) + " " + total + "\n");
		count = 0;
	}
	
	
	writeOut.close();
		

	
	}
	
	

	
}
