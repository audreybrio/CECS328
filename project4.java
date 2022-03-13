//Audrey Brio


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;


public class project4 {
	
	
	public static int maze, n;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		
		
		File file = new File("input1.txt");
		
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
	ArrayList<Integer> please = new ArrayList<>();
	
	while(line.hasNext()) {
		entries.add(line.nextLine());
		
	}
	
	
	System.out.print(entries + "\n");
	
	maze = Integer.parseInt(entries.get(0));
	
	n = Integer.parseInt(entries.get(1));
	
	System.out.print(maze + "\n");
	
	
	System.out.print(n + "\n");
	
	String[][] matrix = new String[n][n];
	
	entries.remove(0);
	entries.remove(0);
	
	
	int sz = entries.get(0).length();
	
	for(int i = 0; i < entries.size(); i++) {
		if(entries.get(i).isBlank()) {
			entries.remove(i);
		}
	}
	
	System.out.print(entries + "\n");

	
	
//	for(int i = 0; i < entries.size(); i= i+n) {
//		String add = "";
//		for(int j = 0; j < n; j++) {
//			add = add + entries.get(j);
//		}
//		please.add(add);
//	}
//	
//	System.out.print(please + "\n");
	int count = 0;
	int he = 0;
	for(int g = 0; g < entries.size(); g = g+0) {
		for(int i = 0; i < n; i++) {
			int k = 0;
			for(int j = 0; j < sz; j=j+4) {
			
				char add = entries.get(i).charAt(j);
				char b = entries.get(i).charAt(j+1);
				char c = entries.get(i).charAt(j+2);
				char d = entries.get(i).charAt(j+3);
			
				String a = String.valueOf(add);
				a = a +String.valueOf(b);
				a = a +String.valueOf(c);
				a = a +String.valueOf(d);
			
				matrix[i][k] = a;
				k++;
			}
		
		}
	//count++;
	//System.out.print(g); 
		
		
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			
			System.out.print(matrix[i][j] + " "); 
		}
		System.out.print("\n"); 
	
	}
	System.out.print("\n"); 
	
	
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			
			String ream = matrix[i][j];
			int bee = ream.length();
			for(int k = 0; k < bee; k++) {
				if(ream.charAt(k) == '0') {
					please.add(k);
					if(i==0) {
						if(k == 0) {
							
						}
						else if (k == 1) {
							
						}
						else if (k ==2) {
							
						}
						else if (k==3) {
							
						}
					}
				}
			}
			
		}
		System.out.print("\n"); 
	
	}
	System.out.print("\n"); 
	//System.out.print("hello" +"\n"); 
	
	while(count< n) {
		entries.remove(0);
		count++;
	}
	count = 0;
	
	
}
	
	System.out.print(please); 
	
	}

}

