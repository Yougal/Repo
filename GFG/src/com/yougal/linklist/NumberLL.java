package com.yougal.linklist;

import com.yougal.linklist.LinkListUtils.Node;

public class NumberLL {
	
	public static int convertListToNumber(Node number){
		if(number==null){
			return 0;
		}else{
			return convertListToNumber(number.next)*10+number.value;
		}
	}

}
