package com.yougal.random;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlignCar {

	public static void main(String[] args) {
		int N = 3, F = 4, A = 11, B = 23;
	    int cars[] = { 10, 11, 30 };
	    int end = B - N * F;
	    System.out.println(getMinPetrol(cars, N, F, A, end));
	 
	    N = 3; F = 6; A = 12; B = 30;
	    int cars2[] = { 10, 20, 30 };
	    end = B - N * F;
	    System.out.println(getMinPetrol(cars2, N, F, A, end));
	}

	private static int  getMinPetrol(int[] cars, int n, int f, int a, int end) {
		int minPetrol =0 ;
		int location = a;
		List<Integer> carList = Arrays.stream(cars).boxed().collect(Collectors.toList());
		while(carList.size()>0){
			int index = searchCarAtMinDistance(carList, location);
			minPetrol+=Math.abs(location-carList.get(index));
			carList.remove(index);
			location+=f;
		}
		return minPetrol;
	}

	private static int searchCarAtMinDistance(List<Integer> cars, int location) {
		int low =0 ;
		int high=cars.size();
		while(low<=high){
			int mid = (high+low)/2;
			if(mid-1>=0){
				if(mid+1<high){
					if(Math.abs(location-cars.get(mid))< Math.abs(location-cars.get(mid-1)) && Math.abs(location-cars.get(mid))< Math.abs(location-cars.get(mid+1))){
						return mid;
					}else{
						if(Math.abs(location-cars.get(mid))< Math.abs(location-cars.get(mid-1))){
							low=mid+1;
						}else{
							high=mid+1;
						}
					}
				}else{
					if(Math.abs(location-cars.get(mid))< Math.abs(location-cars.get(mid-1))){
						return mid;
					}else{
						high=mid-1;
					}
				}
			}else{
				if(mid+1<high){
					if(Math.abs(location-cars.get(mid))< Math.abs(location-cars.get(mid+1))){
						return mid;
					}else{
						low=mid+1;
					}
				}else{
					return mid;
				}
			}
			
		}
		
		return 0;
	}
	
}
