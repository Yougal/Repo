package com.yougal;

import java.util.Scanner;

public class Solution1 {
	
	public static void main(String args[] ) throws Exception {
       Scanner sc = null;
       Item root =null;
       try{
	       sc = new Scanner(System.in);
	       int numRow= sc.nextInt();
	        numRow= sc.nextInt();
	       
	       for (int i=0;i<numRow;i++){
	    	   int a = sc.nextInt();
	    	   int b = sc.nextInt();
	    	   int k = sc.nextInt();
	    	   Item item= new Item(a,b,k);
	    	   root = Solution1.addItem(root, item);
	       }
	    }finally{
	    	if(sc!=null){
	    		sc.close();
	    	}
	    System.out.println(Solution1.findMax(root));
	    }
	}
	
	private static int findMax(Item root) {
		int maxValue = 0;
		while(root!=null){
			if(maxValue<root.value){
				maxValue = root.value;
			}
			root=root.nextItem;
		}
		return maxValue;
	}

	public static Item addItem(Item root, Item item){
		Item tempRoot = root;
		if(tempRoot==null){
			tempRoot=item;
			
		}else{
			Item prevItem = null;
			while(item!=null && root!=null){
				
				if(item.higherLimit<root.lowerLimit){
					if(prevItem==null){
						item.nextItem=root;
						tempRoot=item;
						break;
					}else{
						prevItem.nextItem=item;
						item.nextItem=root;
					}
				}else if(root.higherLimit<item.lowerLimit){
					prevItem=root;
					root=root.nextItem;
				}else{
					//split the set overlapping set
					if(root.lowerLimit<item.lowerLimit){
						
						Item left = new Item(root.lowerLimit, item.lowerLimit-1, root.value);
						if(prevItem==null){
							tempRoot=left;
						}else{
							prevItem.nextItem=left;
						}
						if(root.higherLimit<item.higherLimit){
							Item mid = new Item(item.lowerLimit, root.higherLimit, root.value+item.value);
							item = new Item(root.higherLimit+1, item.higherLimit, item.value);
							left.nextItem=mid;
							mid.nextItem=root.nextItem;
							root=root.nextItem;
							prevItem= mid;
							
						}else if(root.higherLimit>item.higherLimit){
							Item mid = new Item(item.lowerLimit, root.higherLimit, root.value+item.value);
							item = new Item(root.higherLimit+1, item.higherLimit, item.value);
							left.nextItem=mid;
							mid.nextItem=item;
							item.nextItem=root.nextItem;
							item=null;
							prevItem= mid;
							
						}else{
							Item mid = new Item(item.lowerLimit, root.higherLimit, root.value+item.value);
							left.nextItem=mid;
							mid.nextItem=root.nextItem;
							item=null;
							prevItem= mid;
						}
						
						
					}else if(root.lowerLimit>item.lowerLimit){
						Item left = new Item(item.lowerLimit, root.lowerLimit-1, item.value);
						if(prevItem==null){
							tempRoot=left;
						}else{
							prevItem.nextItem=left;
						}
						if(root.higherLimit<item.higherLimit){
							Item mid = new Item(root.lowerLimit, root.higherLimit, root.value+item.value);
							item = new Item(root.higherLimit+1, item.higherLimit, item.value);
							left.nextItem=mid;
							mid.nextItem=root.nextItem;
							root=root.nextItem;
							prevItem= mid;
							
						}else if(root.higherLimit>item.higherLimit){
							Item mid = new Item(root.lowerLimit, item.higherLimit, root.value+item.value);
							item = new Item(item.higherLimit+1, root.higherLimit, root.value);
							left.nextItem=mid;
							mid.nextItem=item;
							item.nextItem=root.nextItem;
							item=null;
							prevItem= mid;
							
						}else{
							Item mid = new Item(root.lowerLimit, root.higherLimit, root.value+item.value);
							left.nextItem=mid;
							mid.nextItem=root.nextItem;
							item=null;
							prevItem= mid;
						}
					}else{
						if(root.higherLimit<item.higherLimit){
							Item mid = new Item(item.lowerLimit, root.higherLimit, root.value+item.value);
							item = new Item(root.higherLimit+1, item.higherLimit, item.value);
							if(prevItem==null){
								tempRoot=mid;
							}else{
								prevItem.nextItem=mid;
							}
							mid.nextItem=root.nextItem;
							root=root.nextItem;
							prevItem= mid;
						}else if(root.higherLimit>item.higherLimit){
							Item mid = new Item(item.lowerLimit, item.higherLimit, root.value+item.value);
							item = new Item(item.higherLimit+1, root.higherLimit, root.value);
							if(prevItem==null){
								tempRoot=mid;
							}else{
								prevItem.nextItem=mid;
							}
							mid.nextItem=item;
							item.nextItem=root.nextItem;
							item=null;
							prevItem= mid;
						}else{
							root.value= root.value+item.value;
							item=null;
						}
					}
					
				}
			}
			if(item!=null && root==null){
				prevItem.nextItem = item;
			}
		}
		return tempRoot;
	}
	
	private static class Item{
		
		public Item(int lowerLimit, int higherLimit, int value) {
			super();
			this.lowerLimit = lowerLimit;
			this.higherLimit = higherLimit;
			this.value = value;
		}
		
		int lowerLimit;
		int higherLimit;
		int value;
		
		Item nextItem;

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Item [lowerLimit=" + lowerLimit + ", higherLimit=" + higherLimit + ", value=" + value
					+ ", nextItem=" + nextItem + "]";
		}
		
	}

}