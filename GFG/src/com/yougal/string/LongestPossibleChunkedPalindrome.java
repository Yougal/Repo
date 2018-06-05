package com.yougal.string;

public class LongestPossibleChunkedPalindrome {
	
	public static void main(String[] args){
		
        System.out.println("V : " + LPC("V"));
        System.out.println("VOLVO : " + LPC("VOLVO"));
        System.out.println("VOLVOV : " + LPC("VOLVOV"));
        System.out.println("ghiabcdefhelloadamhelloabcdefghi : " +
                        LPC("ghiabcdefhelloadamhelloabcdefghi"));
 
        System.out.println("ghiabcdefhelloadamhelloabcdefghik : " +
                        LPC("ghiabcdefhelloadamhelloabcdefghik"));
 
        System.out.println("antaprezatepzapreanta : " +
                        LPC("antaprezatepzapreanta")); 
        
        System.out.println("merchant : " +
                LPC("merchant")); 
        
        System.out.println("geeksforgeeks : " +
                LPC("geeksforgeeks")); 
    }
	
    public static int LPC(String str)
    {
        return LPCRec(str, 1);
    }

	private static int LPCRec(String str, int i) {
		if(str==null || str.length()==0) {
			return 0;
		}
		if(str.length()==i) {
			return 1;
		}else {
			int n = str.length();
			if(str.substring(0, i).equals(str.substring(n-i, n))) {
				return 2 + LPCRec(str.substring(i, n-i), 1);
			}
		}
		return LPCRec(str,i+1);
	}
}
