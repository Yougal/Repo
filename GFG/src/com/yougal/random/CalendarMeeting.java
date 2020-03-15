package com.yougal.random;

import java.util.ArrayList;
import java.util.List;

public class CalendarMeeting {
	
	
	public static void main(String[] args) {
		
		Calendar person1 = new Calendar(new String[][] {
			{"09:00","10:30"},
			{"12:00","13:00"},
			{"16:00","18:00"},
			
			}, new String[] {"9:00","20:00"});
		Calendar person2 = new Calendar(new String[][] {
			{"10:00","11:30"},
			{"12:30","14:00"},
			{"14:30","15:00"},
			{"16:00","17:00"},
			}, new String[] {"10:00","18:30"});
		System.out.println(person1);
		System.out.println(person2);
		
		Calendar merge = Calendar.merge(person1, person2);
		System.out.println(merge);
	}
	
	
	
	

	private static class Time implements Comparable<Time>{
		
		int hour;
		int min;
		
		public Time(int hour, int min) {
			super();
			this.hour = hour;
			this.min = min;
		}

		@Override
		public int compareTo(Time o1) {
			int value1=o1.hour*60 + o1.min;
			int value2=this.hour*60 + this.min;
			if(value1>value2) {
				return -1;
			}else if(value1<value2) {
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return hour + ":" + min;
		}
		
		
		
		
	}
	
	private static class Calendar{
		
		List<Slot> slots = new ArrayList<Slot>();
		
		public Calendar(){
			
		}
		
		public Calendar(String [][] cslots,String bounds[]) {
			String time[] = bounds[0].split(":");
			slots.add(new Slot(
												new  Time(0, 0), 
												new  Time(Integer.valueOf(time[0]), Integer.valueOf(time[1]))
												));
			for(int i=0;i<cslots.length;i++) {
				String timeLower[] = cslots[i][0].split(":");
				String timeupper[] = cslots[i][1].split(":");
				slots.add(new Slot(
										new Time(Integer.valueOf(timeLower[0]), Integer.valueOf(timeLower[1])),
										new Time(Integer.valueOf(timeupper[0]), Integer.valueOf(timeupper[1]))
										));
			}
			time = bounds[1].split(":");
			slots.add(new Slot(
												new  Time(Integer.valueOf(time[0]), Integer.valueOf(time[1])), 
												new  Time(24, 0)
												));
		}
		
		public static Calendar merge(Calendar calendar1, Calendar calendar2){
			
			Calendar mergedCal = new Calendar();
			List<Slot> slots1 = calendar1.slots;
			List<Slot> slots2 = calendar2.slots;
			int i=0,j=0;
			while(i<slots1.size() && j<slots2.size()) {
				Slot slot1 = slots1.get(i);
				Slot slot2 = slots2.get(j);
				if(mergedCal.slots.isEmpty()) {
					if(slot1.lower.compareTo(slot2.lower)<0) {
						mergedCal.slots.add(slot1);
						i++;
					}else {
						mergedCal.slots.add(slot2);
						j++;
					}
				}else {
					Slot lastAddedSlot = mergedCal.slots.get(mergedCal.slots.size()-1);
					if(slot1.lower.compareTo(slot2.lower)<0) {
						Slot smallerValue = slot1;
						if(smallerValue.lower.compareTo(lastAddedSlot.upper)<=0) {
							if(smallerValue.upper.compareTo(lastAddedSlot.upper)>0){
								lastAddedSlot.upper.hour=smallerValue.upper.hour;
								lastAddedSlot.upper.min=smallerValue.upper.min;
							}
						}else {
							mergedCal.slots.add(smallerValue);
						}
						i++;
					}else {
						Slot smallerValue = slot2;
						if(smallerValue.lower.compareTo(lastAddedSlot.upper)<=0) {
							if(smallerValue.upper.compareTo(lastAddedSlot.upper)>0){
								lastAddedSlot.upper.hour=smallerValue.upper.hour;
								lastAddedSlot.upper.min=smallerValue.upper.min;
							}
						}else if(smallerValue.lower.compareTo(lastAddedSlot.upper)>0){
							mergedCal.slots.add(smallerValue);
						}
						j++;
					}
					
				}
			}
			while(i<slots1.size()) {
				Slot lastAddedSlot = mergedCal.slots.get(mergedCal.slots.size()-1);
				Slot smallerValue =  slots1.get(i);
				if(smallerValue.lower.compareTo(lastAddedSlot.upper)<=0) {
					if(smallerValue.upper.compareTo(lastAddedSlot.upper)>0){
						lastAddedSlot.upper.hour=smallerValue.upper.hour;
						lastAddedSlot.upper.min=smallerValue.upper.min;
					}
				}else if(smallerValue.lower.compareTo(lastAddedSlot.upper)>0){
					mergedCal.slots.add(smallerValue);
				}
				i++;
			}
			
			while(j<slots2.size()) {
				Slot lastAddedSlot = mergedCal.slots.get(mergedCal.slots.size()-1);
				Slot smallerValue =  slots2.get(j);
				if(smallerValue.lower.compareTo(lastAddedSlot.upper)<=0) {
					if(smallerValue.upper.compareTo(lastAddedSlot.upper)>0){
						lastAddedSlot.upper.hour=smallerValue.upper.hour;
						lastAddedSlot.upper.min=smallerValue.upper.min;
					}
				}else if(smallerValue.lower.compareTo(lastAddedSlot.upper)>0){
					mergedCal.slots.add(smallerValue);
				}
				j++;
			}
			return mergedCal;
			
		}

		@Override
		public String toString() {
			return "Calendar [slots=" + slots + "]";
		}
		
		
	}
	
	private static class Slot{
		Time upper;
		Time lower;
		public Slot(Time lower, Time upper) {
			super();
			this.upper = upper;
			this.lower = lower;
		}
		@Override
		public String toString() {
			return "[" + lower + " - " + upper + "]";
		}
		
	}
	
	
	
}
