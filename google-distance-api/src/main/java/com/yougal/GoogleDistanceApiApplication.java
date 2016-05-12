package com.yougal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;

public class GoogleDistanceApiApplication {

	//AIzaSyBzuEW0zymhC_b3ojVd7Rd6g22c0Q93wXU
	public static void main(String[] args) throws Exception {
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBzuEW0zymhC_b3ojVd7Rd6g22c0Q93wXU");
		GeocodingResult[] origin  = GeocodingApi.geocode(context,"467 herndon parkway").await();
		GeocodingResult[] destination  = GeocodingApi.geocode(context,"sunrise valley drive herndon va").await();
		DistanceMatrixApiRequest distanceMatrixApiRequest = DistanceMatrixApi.getDistanceMatrix(context, new String[]{origin[0].formattedAddress}, new String[]{destination[0].formattedAddress});
		DistanceMatrix result = distanceMatrixApiRequest.await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jSonResult = gson.toJson(result);
		System.out.println(jSonResult);	
	}
}
