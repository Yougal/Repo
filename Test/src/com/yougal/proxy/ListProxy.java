package com.yougal.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import com.yougal.java8.State;

public class ListProxy<T>   extends State implements InvocationHandler{
	
	private List<T> proxiedList;
	
	ListProxy(List<T> proxiedList){
		this.proxiedList=proxiedList;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		proxy= new Object();
		if(method.getName().startsWith("add")){
			return false;
		}
		return method.invoke(proxiedList, args);
	}

}
