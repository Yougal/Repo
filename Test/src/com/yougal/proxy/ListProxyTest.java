package com.yougal.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListProxyTest {

	
	public static void main(String[] args) {
		List<String> myList=  new ArrayList<>();
		Object proxy = Proxy.newProxyInstance(
				  ListProxy.class.getClassLoader(),
				  new Class[] { Map.class },
				  new ListProxy(myList));
		//proxy.add("Yougal");
		
	}
}
