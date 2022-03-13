//Audrey Brio


import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

public class project3 {
	
	
	public static int magnets;

	public static FileWriter writeOut2;
	static int x;
	static int y;
	static int x1,y1;
	public static int count;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	File file = new File("input.txt");
		
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
	
	ArrayList<String> entries = new ArrayList<>();
	
	while(line.hasNext()) {
		entries.add(line.nextLine());
		
	}
	//System.out.print(entries + "\n");
	
	magnets = Integer.parseInt(entries.get(0));
	
	
	
	entries.remove(0);
	
	int sz = entries.get(0).length();
	
	char[][] matrix = new char[2][sz];

	
	
	List<SimpleEntry<Integer, Integer>> result = new ArrayList<SimpleEntry<Integer, Integer>>();
	
	for(int i = 0; i < entries.size(); i++) {
		for(int j =0; j<sz; j++) {
			matrix[i][j] = entries.get(i).charAt(j);
		}
	}
	
	char[][] output = new char[2][sz];
	char[][] og = new char[2][sz];
	
//	

//	

	
	
	for(int i = 0; i < 2; i++) {
		for(int j =0; j < sz; j++) {
			if(matrix[i][j] == '+') {
				output[i][j] = matrix[i][j];
				og[i][j] = matrix[i][j];
				
				if(i == 0) {
					output[1][j] = '-';
					og[1][j] = '-';
					matrix[1][j] = '-';
					
					
					
				}
				else {
					output[0][j] = '-';
					//matrix[0][j] = '-';
					og[0][j] = '-';
					
				}
			}
			
			else if(matrix[i][j] == '-') {
				output[i][j] = matrix[i][j];
				og[i][j] = matrix[i][j];
				
				if(i == 0) {
					output[1][j] = '+';
					og[1][j] = '+';
					matrix[1][j] = '+';
					
					
				}
				else {
					output[0][j] = '+';
					og[0][j] = '+';
					//matrix[0][j] = '+';
					
				}
			}
			
			else {
				og[i][j] = '0';
				if(i ==0) {
					if(j==0) {
						if(matrix[i][j+1] == '+' || matrix[i+1][0] == '+') {
							output[i][j] = '-';
						}
						
						else if(matrix[i][j+1] == '-' || matrix[i+1][0] == '-') {
							output[i][j] = '+';
							
						}
						else {
							output[i][j] = '0';
							//count++;
						}
					}
					
					else if(j < sz -1) {
					
						if(matrix[i][j-1] == '+') {
							if(matrix[i][j+1] == '-') {
								output[i][j]= '0';
							}
							else {
								output[i][j] = '-';
							}
							
						}
						
						else if(matrix[i][j+1] == '+') {
							if(matrix[i][j-1] == '-'){
								output[i][j] = '0';
							}
							else {
								output[i][j] = '-';
							}
							
						}
						
						else if(matrix[i+1][j] == '+') {
							output[i][j] = '-';
							
						}
						
						else if(matrix[i][j-1] == '-') {
							if(matrix[i][j+1] == '+') {
								output[i][j]= '0';
							}
							else {
								output[i][j] = '+';
							}
							
						}
						
						else if(matrix[i][j+1] == '-') {
							if(matrix[i][j-1] == '+'){
								output[i][j] = '0';
							}
							else {
								output[i][j] = '+';
							}
							
							
						}
						
						else if(matrix[i+1][j] == '-') {
							output[i][j] = '+';
							
						}
						else {
						output[i][j] = '0';
						//count++;
					}
				}
					
					else if(j == sz -1){
						if(matrix[i][j-1] == '+' || matrix[1][j] == '+') {
							output[i][j] = '-';
						}
						
						else if(matrix[i][j-1] == '-' || matrix[1][j] == '-') {
							output[i][j] = '+';
							
						}
						else {
							output[i][j] = '0';
							//count++;
						}
					}
					
					
				}
				
				else {
					if(j == 0) {
						if(matrix[i][j+1] == '+' || matrix[i-1][0] == '+') {
							output[i][j] = '-';
						}
						
						else if(matrix[i][j+1] == '-' || matrix[i-1][0] == '-') {
							output[i][j] = '+';
							
						}
						else {
							output[i][j] = '0';
							//count++;
						}
					}
					
					else if (j < sz-1) {
						if(matrix[i][j-1] == '+') {
							if(matrix[i][j+1] == '-' || matrix[0][j-1] == '+'|| matrix[0][j+1] == '+') {
								output[i][j]= '0';
							}
							else {
								output[i][j] = '-';
							}
							
							
						}
						
						else if(matrix[i][j+1] == '+') {
							if(matrix[i][j-1] == '-' ){
								output[i][j] = '0';
							}
							else {
								output[i][j] = '-';
							}
							
						}
						
						else if(matrix[i-1][j] == '+') {
							output[i][j] = '-';
							
							
						}
						
						else if(matrix[i][j-1] == '-') {
							if(matrix[i][j+1] == '+' || matrix[0][j-1] == '-' || matrix[0][j+1] == '-') {
								output[i][j]= '0';
							}
							else {
								output[i][j] = '+';
							}
							
							
						}
						
						else if(matrix[i][j+1] == '-') {
							if(matrix[i][j-1] == '+'){
								output[i][j] = '0';
							}
							else {
								output[i][j] = '+';
							}
							
							
						}
						
						else if(matrix[i-1][j] == '-') {
							output[i][j] = '+';
							//matrix[i][j] = '+';
							
						}
						else {
						output[i][j] = '0';
						//count++;
					}
					}
					
					else if(j==sz-1){
						if(matrix[i][j-1] == '+' || matrix[0][j] == '+') {
							output[i][j] = '-';
						}
						
						else if(matrix[i][j-1] == '-' || matrix[0][j] == '-') {
							output[i][j] = '+';
							
						}
						else {
							output[i][j] = '0';
							//count++;
						}
						
					}
					
				}
				
			}
			
			
		}
	}
	
	for(int i = 0; i < 2; i++) {
		for(int j = 0; j < sz; j++) {
			if(output[i][j] == '0') {
				count++;
			}
		}
		
	}
	
	
	if(sz == magnets) {
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < sz; j++) {
				if(output[i][j] == '0') {
					//if(i == 0) {
						if(j == 0) {
							if(output[i][j+1] == '+' ) {
								output[i][j] = '-';
							}
							else if(output[i][j+1] == '-'){
								output[i][j] = '+';
							}
							//else {
							else if(output[i][j+2] == '+' || output[i][j+3] == '-') {
									output[i][j] = '+';
								}
							else if (output[i][j+2] == '-' || output[i][j+3] == '+') {
									output[i][j] = '-';
								}
								
							else {
								if (sz % 2 == 0) {
									if(output[i][sz-1] == '+') {
										output[i][j] = '-';
									}
									
									else if(output[i][sz-1] == '-'){
										output[i][j] = '+';
									}
								}
								
								else {
									if(output[i][sz-1] == '+') {
										output[i][j] = '+';
									}
									
									else if(output[i][sz-1] == '-'){
										output[i][j] = '-';
									}
								}
							}
						}
						
						else if(j < sz-1){
							if(output[i][j+1] == '+' || output[i][j-1] == '+'){
								output[i][j] = '-';
								
							}
							else if (output[i][j+1] == '-' || output[i][j-1] == '-'){
								output[i][j] = '+';
							}
							else if(j > 2){
								if(output[i][j-2] == '+' || output[i][j+2] == '+') {
									output[i][j] = '+';
								}
								
								else if (output[i][j-2] == '-' ||  output[i][j+2] == '-') {
									output[i][j] = '-';
								}
							}
							else if (j < 2) {
								if(sz % 2 == 0) {
									if(output[i][sz-1] == '+' || output[i][sz-2] == '-'|| output[i][sz-3] == '+') {
									output[i][j] = '+';
								}
									else if(output[i][sz-1] == '-' || output[i][sz-2] == '+' || output[i][sz-3] == '-' ) {
									output[i][j] = '-';
								}
								}
								else {
									if(output[i][sz-1] == '-' || output[i][sz-2] == '+'|| output[i][sz-3] == '-') {
										output[i][j] = '+';
									}
									else if(output[i][sz-1] == '+' || output[i][sz-2] == '-' || output[i][sz-3] == '+' ) {
										output[i][j] = '-';
									}
								}
							}
						}
						
						else if (j == sz-1){
							if(output[i][j-1] == '+' ) {
								output[i][j] = '-';
							}
							else if(output[i][j-1] == '-'){
								output[i][j] = '+';
							}
							else {
								if(output[i][j-2] == '+' || output[i][j-3] == '-') {
									output[i][j] = '+';
								}
								else if (output[i][j-2] == '-' || output[i][j-3] == '+') {
									output[i][j] = '-';
								}
							}
						}
					//}
					
				}
			}
		}
	}
		

	
	if(sz != magnets) {
		for(int i = 0; i < 2; i++) {
			for(int j =0; j< sz;j++) {
				if(count < (sz - magnets)*2) {
					break;
				}
				else {
					
					if(count >= (sz-magnets)*2) {
						//System.out.println("hello");
						if(output[i][j] == '0') {
							//if(i == 0) {
								if(j == 0) {
									if(output[i][j+1] == '+' ) {
										if(output[i][j+1] == '-' ) {
											output[i][j] = '0';
										}
										else {
										output[i][j] = '-';
										}
									}
									else if(output[i][j+1] == '-'){
										if(output[i][j+1] == '+') {
											output[i][j] = '0';
										}
										else {
										output[i][j] = '+';
										}
									}
									//else {
									else if(output[i][j+2] == '+' || output[i][j+3] == '-') {
										if(output[i][j+2] == '-' || output[i][j+3] == '+') {
											output[i][j] = '-';
										}
										else {
											output[i][j] = '+';
											}
										}
									else if (output[i][j+2] == '-' || output[i][j+3] == '+') {
										if(output[i][j+2] == '+' || output[i][j+3] == '-') {
											output[i][j] = '+';
										}
										else {
											output[i][j] = '-';
									}
										}
										
									else {
										if (sz % 2 == 0) {
											if(output[i][sz-1] == '+') {
												output[i][j] = '-';
											}
											
											else if(output[i][sz-1] == '-'){
												output[i][j] = '+';
											}
										}
										
										else {
											if(output[i][sz-1] == '+') {
												output[i][j] = '+';
											}
											
											else if(output[i][sz-1] == '-'){
												output[i][j] = '-';
											}
										}
									}
								}
								
								else if(j < sz-1){
									if(output[i][j+1] == '+' || output[i][j-1] == '+'){
										if(output[i][j+1] == '-' || output[i][j-1] == '-') {
											output[i][j] = '0';
										}
										else {
											output[i][j] = '-';
										}
										
									}
									else if (output[i][j+1] == '-' || output[i][j-1] == '-'){
										if(output[i][j+1] == '+' || output[i][j-1] == '+') {
											output[i][j] = '0';
										}
										else {
										output[i][j] = '+';
										}
									}
									else if(j > 2){
										if(output[i][j-2] == '+' || output[i][j+2] == '+') {
											output[i][j] = '+';
										}
										
										else if (output[i][j-2] == '-' ||  output[i][j+2] == '-') {
											output[i][j] = '-';
										}
									}
									else if (j < 2) {
										if(sz % 2 == 0) {
											if(output[i][sz-1] == '+' || output[i][sz-2] == '-'|| output[i][sz-3] == '+') {
											output[i][j] = '+';
										}
											else if(output[i][sz-1] == '-' || output[i][sz-2] == '+' || output[i][sz-3] == '-' ) {
											output[i][j] = '-';
										}
										}
										else {
											if(output[i][sz-1] == '-' || output[i][sz-2] == '+'|| output[i][sz-3] == '-') {
												output[i][j] = '+';
											}
											else if(output[i][sz-1] == '+' || output[i][sz-2] == '-' || output[i][sz-3] == '+' ) {
												output[i][j] = '-';
											}
										}
									}
								}
								
								else if (j == sz-1){
									if(output[i][j-1] == '+' ) {
										if(output[i][j-1] == '-') {
											output[i][j] = '0';
										}
										else {
											output[i][j] = '-';
										}
										
									}
									else if(output[i][j-1] == '-'){
										if( output[i][j-1] == '+') {
											output[i][j] = '0';
										}
										else {
										output[i][j] = '+';
										}
									}
									else {
										if(output[i][j-2] == '+' || output[i][j-3] == '-') {
											output[i][j] = '+';
										}
										else if (output[i][j-2] == '-' || output[i][j-3] == '+') {
											output[i][j] = '-';
										}
									}
								}
							//}
							
						}
						else if (output[i][j] == '+' && og[i][j] == '0') {
							
							if(j == 0) {
								if(output[i][j+1] == '+') {
									output[i][j] = '0';
								}
							}
							else if(j < sz -1) {
								if (output[i][j+1] == '+' || output[i][j-1] == '+') {
									output[i][j] = '0';
								}
							}
							else if (j == sz -1) {
								if(output[i][j-1] == '+') {
									output[i][j] = '0';
								}
							}
							
							if(i == 0) {
								
								if(output[1][j] == '+') {
									output[i][j] = '0';
								}
							}
							else if(i ==1) {
								if(output[0][j] == '+') {
									output[i][j] = '0';
								}
							}
						}
						
						else if (output[i][j] == '-' && og[i][j] == '0') {
							if(j == 0) {
								if(output[i][j+1] == '-') {
									output[i][j] = '0';
								}
							}
							else if(j < sz -1) {
								if (output[i][j+1] == '-' || output[i][j-1] == '-') {
									output[i][j] = '0';
								}
							}
							else if (j == sz -1) {
								if(output[i][j-1] == '-') {
									output[i][j] = '0';
								}
							}
							if(i == 0) {
								if(output[1][j] == '-') {
									output[i][j] = '0';
								}
							}
							else if(i ==1) {
								if(output[0][j] == '-') {
									output[i][j] = '0';
								}
							}
						}
					}
				}
			}
		}
	}

	for(int i = 0; i < 2; i++) {
		for(int j = 0; j< sz; j++) {
			if(og[i][j] == '+') {
				if(i == 0) {
					result.add(new SimpleEntry<Integer, Integer>(i,j));
					result.add(new SimpleEntry<Integer, Integer>(1,j));
					output[i][j] = '0';
					output[1][j] = '0';
				}
			}
			
			
			else if(og[i][j] == '-') {
				if(i == 0) {
					result.add(new SimpleEntry<Integer, Integer>(1,j));
					result.add(new SimpleEntry<Integer, Integer>(i,j));
					output[i][j] = '0';
					output[1][j] = '0';
			
			}
			}
		}
	}
	
	
	for(int i = 0; i < 2; i++) {
		for(int j = 0; j< sz; j++) {

	//		else {
				if(result.size()/2 < magnets) {
					
					if(i == 0) {
						if(output[i][j] == '+') {
							if(output[1][j] == '-') {
								result.add(new SimpleEntry<Integer, Integer>(i,j));
								result.add(new SimpleEntry<Integer, Integer>(1,j));
								output[i][j] = '0';
								output[1][j] = '0';
							}
							
							else if (j < sz -1) { 
								if( output[i][j+1] == '-') {
								result.add(new SimpleEntry<Integer, Integer>(i,j));
								result.add(new SimpleEntry<Integer, Integer>(i,j+1));
								output[i][j] = '0';
								output[i][j+1] = '0';
							}
							}
							else if(j > 0) { 
								if( output[i][j-1] == '-') {
								result.add(new SimpleEntry<Integer, Integer>(i,j));
								result.add(new SimpleEntry<Integer, Integer>(i,j-1));
								output[i][j] = '0';
								output[i][j-1] = '0';
							}
							}
							
						}
						else if(output[i][j] == '-'){
							if(output[1][j] == '+') {
								result.add(new SimpleEntry<Integer, Integer>(1,j));
								result.add(new SimpleEntry<Integer, Integer>(i,j));
								output[i][j] = '0';
								output[1][j] = '0';
							}
							
							else if(output[i][j+1] == '+') {
								result.add(new SimpleEntry<Integer, Integer>(i,j+1));
								result.add(new SimpleEntry<Integer, Integer>(i,j));
								output[i][j] = '0';
								output[i][j+1] = '0';
							}
							
							else if( output[i][j-1] == '+') {
								result.add(new SimpleEntry<Integer, Integer>(i,j-1));
								result.add(new SimpleEntry<Integer, Integer>(i,j));
								output[i][j] = '0';
								output[i][j-1] = '0';
							}
						}
						
						else {
							if(j==0) {
								if(output[1][j] == '+') {
									if( output[1][j+1] == '-') {
										result.add(new SimpleEntry<Integer, Integer>(1,j));
										result.add(new SimpleEntry<Integer, Integer>(1,j+1));
										output[1][j] = '0';
										output[1][j+1] = '0';
									}
									
								}
								
								else if (output[1][j] == '-') {
									if(output[1][j+1] == '+') {
										result.add(new SimpleEntry<Integer, Integer>(1,j+1));
										result.add(new SimpleEntry<Integer, Integer>(1,j));
										output[1][j] = '0';
										output[1][j+1] = '0';
									}
									
								
								}
							}
							
							else if (j < sz-1) {
								if(output[1][j] == '+') {
									if( output[1][j+1] == '-') {
										result.add(new SimpleEntry<Integer, Integer>(1,j));
										result.add(new SimpleEntry<Integer, Integer>(1,j+1));
										output[1][j] = '0';
										output[1][j+1] = '0';
									}
									
									else if(output[1][j-1] == '-') {
										result.add(new SimpleEntry<Integer, Integer>(1,j));
										result.add(new SimpleEntry<Integer, Integer>(1,j-1));
										output[1][j] = '0';
										output[1][j-1] = '0';
									}
								}
								
								else if (output[1][j] == '-') {
									if(output[1][j+1] == '+') {
										result.add(new SimpleEntry<Integer, Integer>(1,j+1));
										result.add(new SimpleEntry<Integer, Integer>(1,j));
										output[1][j] = '0';
										output[1][j+1] = '0';
									}
									
									else if(output[1][j-1] == '+') {
										result.add(new SimpleEntry<Integer, Integer>(1,j-1));
										result.add(new SimpleEntry<Integer, Integer>(1,j));
										output[1][j] = '0';
										output[1][j-1] = '0';
									}
								}
								
							}
							
							else if (j == sz-1) {
								if(output[1][j] == '+') {
									 if(output[1][j-1] == '-') {
										result.add(new SimpleEntry<Integer, Integer>(1,j));
										result.add(new SimpleEntry<Integer, Integer>(1,j-1));
										output[1][j] = '0';
										output[1][j-1] = '0';
									}
								}
								
								else if (output[1][j] == '-') {
									if(output[1][j-1] == '+') {
										result.add(new SimpleEntry<Integer, Integer>(1,j-1));
										result.add(new SimpleEntry<Integer, Integer>(1,j));
										output[1][j] = '0';
										output[1][j-1] = '0';
									}
								}
							}
						
							
						}
					}

				}
				
			//}
		}
	}
	

	try {
	      writeOut2 = new FileWriter("output.txt");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      //e.printStackTrace();
	    }
	
	for(int i = 0; i < result.size(); i = i+2) {
		AbstractMap.SimpleEntry<Integer, Integer> boo = result.get(i);
		AbstractMap.SimpleEntry<Integer, Integer> yay = result.get(i+1);
		
		x = boo.getKey();
		y = boo.getValue();
		x1 = yay.getKey();
		y1 = yay.getValue();
		
		//System.out.println(x + " " + y + " " + x1 +" " + y1 + "\n");
		writeOut2.write(x + " " + y + " " + x1 +" " + y1 + "\n");
	}

	
	//System.out.println(result);
	
writeOut2.close();
	
	}

}
