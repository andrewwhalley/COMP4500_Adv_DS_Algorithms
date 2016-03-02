package stringTransformation;

import java.util.ArrayList;
import java.util.List;

import stringTransformation.TransElement.TransCode;

public class DynamicStringTransformation { 

    private String x; // Source string
    private String y; // Target string
    
    public DynamicStringTransformation( String x, String y ) {
        super();
        this.x = x;
        this.y = y;
    }
       
    /** Dynamic programming implementation of string transformation function
     * @return the minimal cost over all transformations that transform
     *   string x to string y 
     */
    int[][] table;
    TransElement[][] trans;
    public int numberOfIterations;
    
    public int stringTransformation() {
        numberOfIterations = 0;
        computeLCS();
        backtrack();
        int cost = 0;
        /*
        int j = 0;
        for (int i = 0; i < this.x.length() ; i++) {
        	// the minimum cost is a copy
        	if (this.x.charAt(i) == this.y.charAt(j)) {
        		cost += TransCode.Copy.getCost();
        		j++;
        		continue;
        	}
        	
        }*/
        return cost;
    }
    
    /**
     * computeLCS fills in the variable 'table' with the
     * lowest common subsequence between 
     */
    public void computeLCS() {
    	// Set the first row and first column of the table to contain only 0's
    	table = new int[this.x.length() + 1][this.y.length() + 1];
    	System.out.println(this.x);
    	System.out.println(this.y);
    	for (int i = 0; i <= this.x.length(); i++) {
    		table[i][0] = 0;
    	}
    	for (int j = 0; j <= this.y.length(); j++) {
    		table[0][j] = 0;
    	}
    	for (int i = 0; i < this.x.length(); i++) {
    		for (int j = 0; j < this.y.length(); j++) {
    			if (this.x.charAt(i) == this.y.charAt(j)) {
    				table[i+1][j+1] = table[i][j] + 1;
    			} else {
    				table[i+1][j+1] = Math.max(table[i+1][j], table[i][j+1]);
    			}
    		}
    	}
    	System.out.println("-----------------");
    	for (int i = 0; i <= this.x.length(); i++) {
    		for (int j = 0; j <= this.y.length(); j++) {
    			System.out.print(table[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println("-----------------");
    }
    
    /**
     * backtrack finds the LCS in table and prints it to stdout
     */
    public void backtrack() {
    	int i = this.x.length(),j = this.y.length();
    	StringBuilder s = new StringBuilder();
    	while (i >= 0 && j >= 0) {
    		if (this.x.charAt(i) == this.y.charAt(j)) {
    			s.append(x.charAt(i));
    			i++;
    			j++;
    		} else if (table[i+1][j] >= table[i][j+1]) {
    			i++;
    		} else {
    			j++;
    		}
    		System.out.println("i: " + i + ", j: " + j);
    	}
    	System.out.println(s.toString());
    }
    
    
    /**
     * @requires that the stringTransformation function has been called to 
     *  calculate the minimum cost and set up the matrices from which the 
     *  list of transformations is extracted
     * @return list of transformations to convert x to y
     */
    public List<TransElement> getTransList() {
        List<TransElement> transList = new ArrayList<TransElement>();
        //TODO
        return transList;
    }
}
