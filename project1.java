

import java.util.*
;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

import java.io.*;

import java.util.ArrayList;
import java.lang.*;
import java.math.BigInteger;



public class project1 {
	
	//public static HashMap<Integer, Integer> val = new HashMap<Integer, Integer>();

	//public static AbstractMap.SimpleEntry<Integer, Integer> work = new AbstractMap.SimpleEntry<Integer, Integer>(null, null);
	
	public static BigInteger m;
	public static BigInteger n;
	public static BigInteger a;
	public static BigInteger b; //9 8
	
	public static long startTime, endTime, elaspsedTime;
	
//	public static ArrayList hell(int abba) {
//	
//		
//		return null;
//		
//	
//		
//	}
	
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
			File file = new File("input1.txt");
		
			try {
		      
		      if (file.createNewFile()) {
		        //System.out.println("File created: " + file.getName());
		      } else {
		        //System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      //System.out.println("An error occurred.");
		     // e.printStackTrace();
		    }
		Scanner line = new Scanner(file);
		ArrayList<BigInteger> entries = new ArrayList<>();
		
		while(line.hasNext()) {
			entries.add(line.nextBigInteger());
		}

		
		m = entries.get(0);
		n = entries.get(1);
		

		List<SimpleEntry<BigInteger, BigInteger>> see = new ArrayList<SimpleEntry<BigInteger, BigInteger>>();
		see.add(new AbstractMap.SimpleEntry(BigInteger.ZERO, BigInteger.ONE));
		see.add(new AbstractMap.SimpleEntry(BigInteger.ONE, BigInteger.ZERO));
		ArrayList<SimpleEntry<BigInteger, BigInteger>> odd = new ArrayList<SimpleEntry<BigInteger, BigInteger>>();
		
		
		boolean flag = false;
		int trythis = 0;
		int l = 17;
		boolean save =false;
		if (m.compareTo(n) == 1) {
			save = true;
		}
		
		startTime = System.nanoTime();
		
		//while(flag == false) {
		for(int j = 0; flag == false; j = j) {
			
			
			for(int i=0; i <see.size() -1; i=i+2) {
				
				
				

				AbstractMap.SimpleEntry<BigInteger, BigInteger> val1 = see.get(i);
				AbstractMap.SimpleEntry<BigInteger, BigInteger> val2 = see.get(i+1);

				//Integer d = i;
					a = val1.getKey().add(val2.getKey());
					b = val1.getValue().add(val2.getValue());

				see.add(i+1, new SimpleEntry<BigInteger, BigInteger>(a, b));	
			
	
					
					
						//continue;
					odd.add(see.get(i+1));
					if(i+1 >= Math.pow(2, l) +1) {
							
					if(save == true && a.compareTo(b) == 1) { //goes to the right
						
					
//							AbstractMap.SimpleEntry<BigInteger, BigInteger> trial = see.get(i+1);
//							odd.add(trial);
//							a = trial.getKey();
//							b = trial.getValue();
						
							startTime = System.nanoTime();
								BigInteger help = (n.multiply(a).multiply(a)).subtract((m.multiply(b).multiply(b)));
								BigInteger absval = help.abs();
								
								endTime = System.nanoTime();
								long timeElaspsed = endTime - startTime;
								System.out.println(timeElaspsed);
						

								if(absval.compareTo(b) == -1) {
//									System.out.println("a: " + a);
//									System.out.println("b: " + b);
//									System.out.println(i+1);
									flag = true;
									break;								}
						
						
						//l=l+1;
								
									
						}
					
				
					else { //goes to the left
						
					
						
							BigInteger help = (n.multiply(a).multiply(a)).subtract((m.multiply(b).multiply(b)));
							BigInteger absval = help.abs();

							if(absval.compareTo(b) == -1) {
//								System.out.println("a: " + a);
//								System.out.println("b: " + b);
								flag = true;
								break;
							}
							
						
						//}
					}
					
					
					
						
			}
				
			}
			 
			
			//System.out.println(l);
			// l= l+1;
//			for(int i = 0; i < see.size(); i++) {
//				if(i % 2 == 1) {
//					AbstractMap.SimpleEntry<BigInteger, BigInteger> help = see.get(i);
//					BigInteger t1 = help.getKey();
//					BigInteger t2 = help.getValue();
//					if(m.compareTo(n) == 1 && t1.compareTo(t2) == 1) { //goes to the right
//						odd.add(help);
//						}
//					else if(m.compareTo(n) == -1 && t1.compareTo(t2) == -1) { //goes to the left
//						odd.add(help);
//						}
//						
//				}
//		
//			}
			
	//System.out.println(odd.size());
			//if (odd.size() > 1028531) {
				
//			
//			for(int i = (int) (Math.pow(2, l) +1); i < odd.size(); i++) {
//				AbstractMap.SimpleEntry<BigInteger, BigInteger> trial = odd.get(i);
//				a = trial.getKey();
//				b = trial.getValue();
//				
//					BigInteger help = (n.multiply(a).multiply(a)).subtract((m.multiply(b).multiply(b)));
//					BigInteger absval = help.abs();
//
//					if(absval.compareTo(b) == -1) {
//						System.out.println("a: " + a);
//						System.out.println("b: " + b);
//						flag = true;
//						break;
//					}
////				
////
//			}
			//}
			trythis++;
			//System.out.println(trythis);
			
			if(flag == true) {
				break;
			}
		
		
		}
		endTime = System.nanoTime();
		long timeElaspsed = endTime - startTime;
		System.out.println(timeElaspsed);
		System.out.println(trythis);	
////		
//			for(int i = 0; i < odd.size(); i++) {
//			System.out.println(odd.get(i));
//		}
//	
		
	
		//File output = new File("output.txt");
		
		
		
		try {
		      FileWriter writeOut = new FileWriter("output.txt");
		      writeOut.write(a.toString()+"\n");
		      writeOut.write(b.toString());
		      writeOut.close();
		      //System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      //e.printStackTrace();
		    }
	
	
	
	
	}
	
	

}
