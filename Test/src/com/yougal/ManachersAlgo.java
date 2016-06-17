package com.yougal;

import java.util.Arrays;

public class ManachersAlgo {

	
	public static void main(String[] args) {
		//String text="abaxabaxabb";
		String text="abaxabaxabybaxabyb";
		int auxArray[] = findLengthOfLargestPallindrom(text);
		System.out.println(Arrays.toString(auxArray));
	}

	private static int[] findLengthOfLargestPallindrom(String text) {
		int auxArray[] = new int[text.length()];
		int center =0 ;
		while(true){
			int p=center-1;
			int q = center+1;
			int size = 1;
			while(p>=0 && q<text.length() && text.charAt(p) == text.charAt(q)){
				size++;size++;
				p--;
				q++;
			}
			auxArray[center] = size;
			
			//Stop if current pallindrom expands till the end.
			if(q>=text.length()){
				break;
			}
			
			//identify the new center
			int newCenter = center+size/2;
			if(newCenter-center>1){
				newCenter = center+1;
				int w=1;
				//Skip Totally contained in current pallindrom.
				//Pick character as center whose pallindrom expands till the end current pallindrom from the current center
				
				
				while(newCenter<q){
					int pallindromAroundMirrorLowerLimit = (center-w)-(auxArray[center-w]/2);
					
					int pallindromAroundLowerLimit =newCenter-(auxArray[center-w]/2);
					int pallindromAroundHighLimit = newCenter+(auxArray[center-w]/2);
					//Skip Totally contained in current pallindrom.
					if(p+1<pallindromAroundLowerLimit&& q-1>pallindromAroundHighLimit){
						auxArray[newCenter]=auxArray[center-w];
					}else if(q-1==pallindromAroundHighLimit){
						break;
					}else if(p+1>=pallindromAroundMirrorLowerLimit){
						//Skip the character whose pallindrom extends more than left of current pallindrom.
						auxArray[newCenter]=((q-newCenter-1)*2)+1;
					}
					newCenter++;
					w++;
				}
				center= newCenter;
			}else{
				center++;
			}
			
		 
		}
		return auxArray;
	}
	
}
