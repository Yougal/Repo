package com.yougal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;

public class GoogleDistanceApiApplication {

	//AIzaSyBzuEW0zymhC_b3ojVd7Rd6g22c0Q93wXU
	public static void main(String[] args) throws Exception {
		// Replace the API key below with a valid API key.
		/**GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBzuEW0zymhC_b3ojVd7Rd6g22c0Q93wXU");
		DistanceMatrixApi distanceMatrixApi = DistanceMatrixApi.getDistanceMatrix(context, "Seattle", "San Francisco");
		
		GeocodingResult[] results =  GeocodingApi.geocode(context,
		    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
		System.out.println(results[0].formattedAddress);	**/
		
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBzuEW0zymhC_b3ojVd7Rd6g22c0Q93wXU");
		DistanceMatrixApiRequest distanceMatrixApiRequest = DistanceMatrixApi.getDistanceMatrix(context, new String[]{"Seattle"}, new String[]{"San Francisco"});
		DistanceMatrix result = distanceMatrixApiRequest.await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jSonResult = gson.toJson(result);
		System.out.println(jSonResult);	
	}
}
