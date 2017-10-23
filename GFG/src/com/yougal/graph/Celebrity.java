package com.yougal.graph;

import java.util.Stack;

/**
 * 
 * In a party of N people, only one person is known to everyone. 
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. 
 * We can only ask questions like “does A know B? “. 
 * Find the stranger (celebrity) in minimum number of questions.
 * @author yougal.bisht
 *
 */
public class Celebrity {

	static int MATRIX[][] = { 
								{ 0, 0, 0, 0 }, 
								{ 1, 0, 0, 0 },
					            { 1, 0, 0, 0 },
					            { 1, 0, 0, 0 } 
            
							};
	
	public static void main(String[] args){
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) 
        {
            System.out.println("No Celebrity");
        } 
        else
            System.out.println("Celebrity ID " + result);
    }

	private static int findCelebrity(int n) {
		Stack<Integer> stck = new Stack<>();
		for (int i = 0; i < n; i++) {
			stck.push(i);
		}
		int c = -1;
		while(stck.size()>1){
			int a = stck.pop();
			int b = stck.pop();
			if(isKnown(a,b)){
				stck.push(b);
			}else{
				stck.push(a);
			}
		}
		c = stck.pop();
		for(int i = 0; i < n; i++){
			if(c!=i && !(MATRIX[c][i]==0 && MATRIX[i][c]==1)){
				return -1;
			}
		}
		
		return c;
	}

	private static boolean isKnown(int a, int b) {
		return MATRIX[a][b]==1? true:false;
	}
}
