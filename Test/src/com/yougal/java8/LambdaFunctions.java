package com.yougal.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaFunctions {
	
	
	public static void main(String[] args) {
		Function<String,Void> f = (a)->{
											System.out.println(a);
											return null;
				};
				
		MyIntf inf = (Person p1,Person p2)-> {
									if(p1.birthday.compareTo(p2.birthday)>0){
										return p1;
									}else{
										return p2;
									}
								};
								
								new ArrayList<String>().sort(new Comparator<String>() {

									@Override
									public int compare(String o1, String o2) {
										// TODO Auto-generated method stub
										return 0;
									}
								});
								
		Arrays.sort(new Person[5], Person::compareByAge);
	}
	
	
	
	public List<Person> filterAdultMalePerson(List<Person> personList, Predicate<Person> function){
		return personList.stream().filter(function).collect(Collectors.toList());
	}
	
}

interface MyIntf{
	
	public Person checkOld (Person p1, Person p2);
	
	
}

class Person {

    enum Sex {
        MALE, FEMALE
    }

    String name;
    Date birthday;
    Sex gender;
    String emailAddress;
    
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

}
