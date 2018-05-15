package com.yougal.impl;

import java.util.ArrayList;
import java.util.List;

import com.yougal.ActionItem;

class LiftActionQueue{
	
	private List<ActionItem> actionItems = new ArrayList<ActionItem>();
	
	private boolean isAllowedToAcceptAction=true;
	
	public void addAction(ActionItem actionItem){
		if(isAllowedToAcceptAction){
			actionItems.add(actionItem);
		}
	}
	
	public ActionItem getAction(){
		return actionItems.get(0);
	}
	
	public boolean hasItems(){
		return actionItems.size()>0;
	}
	
	public void doNotAcceptAnyAction(){
		this.isAllowedToAcceptAction=true;
	}

	/**
	 * @return the actionItems
	 */
	public List<ActionItem> getActionItems() {
		return actionItems;
	}
	
	
}
