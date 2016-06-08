package com.yougal.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListProxyTest {

	
	public static void main(String[] args) {
		List<String> myList=  new ArrayList<>();
		List proxy = (List)Proxy.newProxyInstance(
				  ListProxy.class.getClassLoader(),
				  new Class[] { List.class },
				  new ListProxy(myList));
		proxy.add("Yougal");
		
	}
}
