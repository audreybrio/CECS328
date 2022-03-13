//Audrey Brio


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class project5 {
	
	
	public static BigInteger start = BigInteger.ONE;
	public static BigInteger count = BigInteger.ONE;
	public static BigInteger maxx, minn;
	public static FileWriter writeOut2;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("input3.txt");
		
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
	ArrayList<BigInteger> max = new ArrayList<>();
	ArrayList<BigInteger> min = new ArrayList<>();
	ArrayList<BigInteger> hobbit = new ArrayList<>();
	
	while(line.hasNext()) {
		entries.add(line.nextBigInteger());
		
	}

	System.out.println(entries);
	//System.out.println(max);
	
	
	
	BigInteger m = BigInteger.ZERO;
	//BigInteger gcd;
	
	for(int i = 0; i < entries.size(); i++) {
		BigInteger in = BigInteger.ONE;
		BigInteger out = BigInteger.ONE;
		int effort= 0;
		int more = 0;
		for(int j = 0; j < entries.size(); j++) {
			if(entries.get(i).compareTo(entries.get(j)) == -1) {
				more++;
				
				BigInteger gcd = entries.get(i).gcd(entries.get(j));

				in = in.multiply(gcd);
//				System.out.println("i: " + entries.get(i));
//				System.out.println("in: " + in);
				
//				if(i == entries.size() -1 && in.compareTo(BigInteger.ONE) == 0 ) {
//					if(max.contains(entries.get(i)) == false) {
//						System.out.println("add ples: " + entries.get(i));
//						max.add(entries.get(i));
//					}
//					
//				}
				
//				if(in.compareTo(BigInteger.ONE) == 0 && j == entries.size()-1){
//					System.out.println("add no: " + entries.get(i));
//					max.add(entries.get(i));
//				}
				
			}
			
			else if(entries.get(i).compareTo(entries.get(j)) == 1) {
				effort++;
				
				BigInteger gg = entries.get(i).gcd(entries.get(j));
				
				out = out.multiply(gg);
				
//				if(out.compareTo(BigInteger.ONE) == 0 && j == entries.size()-1) {
//					if(min.contains(entries.get(i)) == false) {
//						min.add(entries.get(i));
//					}
//				}
			}
		}
		
		if(entries.size() -1 == effort) {
			if(max.contains(entries.get(i)) == false) {
				
				max.add(entries.get(i));
			}
		}
		
		if(in.compareTo(BigInteger.ONE) == 0) {
			if(max.contains(entries.get(i)) == false) {
				
				max.add(entries.get(i));
			}
			
		}
		
		if(entries.size()-1 == more) {
			if(min.contains(entries.get(i)) == false) {
				min.add(entries.get(i));
			}
		}
		
		if(out.compareTo(BigInteger.ONE) == 0) {
			if(min.contains(entries.get(i)) == false) {
				min.add(entries.get(i));
			}
			
		}
		
		}
	
//	//min.add(entries.get(entries.size()-1));
	System.out.println(max);
	System.out.println(min);

	
	for(int i = 0; i < entries.size(); i++) {
		
		if(min.contains(entries.get(i))) {
			
			for(int j = 0; j <entries.size(); j++) {
				
				if(entries.get(i).compareTo(entries.get(j)) != 0) {
					
					BigInteger hello = entries.get(i).gcd(entries.get(j));
					
					
					boolean help = false;
					if((entries.get(i).compareTo(BigInteger.ZERO) == 0 || entries.get(j).compareTo(BigInteger.ZERO) == 0) ) {
						help = true;
					}
					
					if(hello.compareTo(BigInteger.ONE) != 0 &&  help == false) {
						if(entries.get(i).compareTo(entries.get(j)) == -1) {
						
						//System.out.println("hello");
							hobbit.add(entries.get(i));
							entries.set(i, BigInteger.ZERO);
						
						
							if(max.contains(entries.get(j))) {
								hobbit.add(entries.get(j));
								entries.set(j, BigInteger.ZERO);
								break;
							
							}
							else {
								hobbit.add(entries.get(j));
								i = entries.indexOf(entries.get(j))-1;
								break;
							
							
						}
					}
					}
					
					else if(hello.compareTo(BigInteger.ONE) == 0 && max.contains(entries.get(i)) == true) {
						hobbit.add(entries.get(i));
						entries.set(i, BigInteger.ZERO);
					}
					
				}
				System.out.println("bobbit: "+ hobbit);
			
		}
			
		}
		
		else if(min.contains(entries.get(i))== false) {
			
			if(hobbit.size() > 0 && max.contains(hobbit.get(hobbit.size()-1)) == false) {
			//System.out.println("hello");
			
				for(int j = 0; j < entries.size(); j++) {
				

					
					if(entries.get(i).compareTo(entries.get(j)) != 0) {
					
						BigInteger hello = entries.get(i).gcd(entries.get(j));
					
						boolean help = false;
						if((entries.get(i).compareTo(BigInteger.ZERO) == 0 || entries.get(j).compareTo(BigInteger.ZERO) == 0) ) {
						help = true;
						}
								
						if(hello.compareTo(BigInteger.ONE) != 0 && help == false) {
						
							if (entries.get(i).compareTo(entries.get(j)) == -1) {
								
								//hobbit.add(entries.get(i));
								entries.set(i, BigInteger.ZERO);
						
						
								if(max.contains(entries.get(j))) {
									hobbit.add(entries.get(j));
									entries.set(j, BigInteger.ZERO);
									break;
							
								}
								else {
									hobbit.add(entries.get(j));
									i = entries.indexOf(entries.get(j))-1;
									break;
							
							
						}
					}
					}
						else if(hello.compareTo(BigInteger.ONE) == 0 && max.contains(entries.get(i)) == true) {
							hobbit.add(entries.get(i));
							entries.set(i, BigInteger.ZERO);
					}
					
				}
				
					System.out.println("bhjbj: "+ hobbit);
		}
		}
		}
		
		if(i == entries.size()-1) {
			if(max.contains(entries.get(i)) && hobbit.contains(entries.get(i)) == false) {
				hobbit.add(entries.get(i));
				entries.set(i, BigInteger.ZERO);
		
			}
		}
		
		
	}
	
	
	
	for(int i = 0; i < entries.size(); i++) {
		if(max.contains(entries.get(i)) && hobbit.contains(entries.get(i)) == false){
			hobbit.add(entries.get(i));
		}
	}
	
	
	
//	
	System.out.println(entries);
	System.out.println(hobbit);
	
	
	
	try {
	      writeOut2 = new FileWriter("output.txt");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      //e.printStackTrace();
	    }

	hobbit.add(0, BigInteger.ONE);
	for(int i = 0; i < hobbit.size(); i++) {
		if(max.contains(hobbit.get(i)) && i != hobbit.size()-1) {
			hobbit.add(hobbit.indexOf(hobbit.get(i)) + 1, BigInteger.ONE);
			hobbit.add(hobbit.indexOf(hobbit.get(i)) + 1, BigInteger.ZERO);
			//writeOut2.write(" hi" + "\n");
			}
		}
	
	for(int i = 0; i < hobbit.size(); i++) {
		if(hobbit.get(i).compareTo(BigInteger.ZERO) != 0) {
			writeOut2.write(hobbit.get(i) + " ");
		}
		
		else {
			writeOut2.write("\n");
		}
		
	}
		
		
		
	
	System.out.println(hobbit);
	

	
writeOut2.close();
	
	
	}

}
